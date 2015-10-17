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

(defn parse-json [item]
  (def i item)
  (parse-string i true))

(defn gen-post [item]
  (def f (future (get-item item parse-json)))
  (contents/post @@f))

(defn get-all-items [top-items]
  (def top top-items)
  (def res (map gen-post top)) res)

(defroutes wackernews
  (GET "/" [] (layout/application "Home" @(get-top-articles get-all-items)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  ;; (get-top-articles group-print)
  (run-server wackernews {:port 5000}))
