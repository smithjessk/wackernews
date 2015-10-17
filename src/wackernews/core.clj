(ns wackernews.core
  (:require [wackernews.grabber :refer [grab]]
            [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defroutes wackernews
  (GET "/" [] "Hello World"))

(defn -main []
  (println "Let the wackness begin...")
  (grab (list "ye" "dog"))
  (run-server wackernews {:port 5000}))