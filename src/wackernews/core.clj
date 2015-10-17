(ns wackernews.core
  (:require [wackernews.grabber :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [wackernews.views.layout :as layout]
            [wackernews.views.contents :as contents]
            [org.httpkit.server :refer [run-server]]))

(defroutes wackernews
  (GET "/" [] (layout/application "Home" (contents/index)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  (get-top-articles println)
  (run-server wackernews {:port 5000}))
