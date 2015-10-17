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

(defn make-request [item]
  (get-item item #(parse-string %1 true)))

(defn gen-post [index, result]
  (contents/post index, @result))

(defn get-all-items [top-items]
  (def res (map-indexed gen-post
                (map make-request
                     (take 30 top-items)))) res)

(defroutes wackernews
  (GET "/" [] (layout/application "Home" @(get-top-articles get-all-items)))
  (route/resources "/"))

(defn -main []
  (println "Let the wackness begin...")
  ;; (get-top-articles group-print)
  (run-server wackernews {:port 5000}))
