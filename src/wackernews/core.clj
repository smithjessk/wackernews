(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :refer :all]
            [wackernews.views.layout :as layout]
            [wackernews.views.contents :as contents]
            [clojure.string :as str]
            [org.httpkit.server :refer [run-server]]))

(defn group-print [articles]
  (println articles))

(defn get-article-json [item]
  (get-item item #(parse-string %1 true)))

(defn generate-post [index, result]
  (contents/post index, @result))

(defn get-all-items [top-items]
  (def res
    (map-indexed
     #(generate-post %1 (get-article-json %2))
     (take 30 top-items)))
  res)

(defroutes wackernews
  (GET "/" [] (layout/application "Home" @(get-top-articles get-all-items)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  ;; (get-top-articles group-print)
  (run-server wackernews {:port 5000}))
