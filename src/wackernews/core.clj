(ns wackernews.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]])) ; httpkit is a server

(defroutes wackernews
  (GET "/" [] "Hello World"))

(defn -main []
  (run-server wackernews {:port 5000}))