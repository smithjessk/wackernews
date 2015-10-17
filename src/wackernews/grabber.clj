(ns wackernews.grabber
  (:require [org.httpkit.client :as http]))

(def options {:timeout 5000 ;; ms
              :basic-auth ["user" "pass"]
              :query-params {:print "pretty"}
              :user-agent "User-Agent-string"
              :headers {"X-Header" "Value"}})

(defn generate-item-url [id]
  (str "https://hacker-news.firebaseio.com/v0/item/" id ".json"))

(def top-articles-url 
  "https://hacker-news.firebaseio.com/v0/topstories.json")

(defn get-top-articles [callback-fn]
  (http/get top-articles-url options
            (fn [{:keys [status headers body error]}]
              (if error
                (println "Failed to get latest articles. Exception is " error)
                (callback-fn (load-string body))))))

(defn get-item [id callback-fn]
  (http/get (generate-item-url id) options
            (fn [{:keys [status headers body error]}]
              (if error
                (println "Failed, exception is " error)
                (callback-fn body)))))
