(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [wackernews.views.layout :as layout]
            [wackernews.views.contents :as contents]
            [clojure.string :as str]
            [org.httpkit.server :refer [run-server]]))

(defroutes wackernews
  (GET "/" [] (layout/application "Home" "Poo"))
  (route/resources "/"))

(defn group-print [articles]
  (println articles))

(defn get-all-items [top-items]
  (def top top-items)
  (doseq [i top] (get-item i)))

(println (get-top-articles get-all-items))

(defn -main []
  (println "Let the wackness begin...")
  (get-top-articles group-print)
  (run-server wackernews {:port 5000}))
