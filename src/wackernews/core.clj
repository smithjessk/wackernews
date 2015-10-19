(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
            [clojure.core.cache :as cache]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :refer :all]
            [wackernews.views.layout :as layout]
            [wackernews.views.contents :as contents]
            [clojure.string :as str]
            [org.httpkit.server :refer [run-server]]))

(defn get-article-json
  "Gets JSON for a single article ID"
  [item]
  (get-item item #(parse-string % true)))

(defn get-top-articles-json
  "Takes a list of article IDs and indexes them, gets their JSON
  representation and then renders them as posts."
  [items]
  (pmap #(contents/post (get % 0) @(get-article-json (get % 1)))
        (map-indexed #(-> [%1 %2]) (take 30 items))))

(def app-cache
  (cache/ttl-cache-factory
   {:articles @(get-top-articles get-top-articles-json)} :ttl 900000))

(defn fetch-articles-from-cache
  "Return cached articles. If articles aren't in cache, then fetch
  them and return them"
  []
  (if (cache/has? app-cache :articles)
    (get (cache/hit app-cache :articles) :articles)
    (get (cache/miss app-cache :articles
                     @(get-top-articles get-top-articles-json)) :articles)))

(defroutes wackernews
  (GET "/" [] (layout/application "Home" (fetch-articles-from-cache)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  (run-server wackernews {:port 5000}))
