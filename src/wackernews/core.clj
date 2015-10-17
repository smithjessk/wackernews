(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
            [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defroutes wackernews
  (GET "/" [] "Hello World"))

(defn -main []
  (println "Let the wackness begin...")
  (get-top-articles println)
  (run-server wackernews {:port 5000}))