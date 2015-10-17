(ns wackernews.grabber
  (:require [org.httpkit.client :as http]))

(def options {:timeout 5000             ; ms
              :basic-auth ["user" "pass"]
              :user-agent "User-Agent-string"
              :headers {"X-Header" "Value"}})

(def url "https://hacker-news.firebaseio.com/v0/item/8863.json?print=pretty")

(defn grab [criteria]
  (http/get url options
    (fn [{:keys [status headers body error]}] 
      (if error
        (println "Failed, exception is " error)
        (println "Async HTTP GET: " status)))))