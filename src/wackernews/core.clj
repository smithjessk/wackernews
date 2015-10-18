(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
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

(defroutes wackernews
  (GET "/" [] (layout/application "Home" @(get-top-articles get-top-articles-json)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  (run-server wackernews {:port 5000}))
