(ns wackernews.views.contents
  (:use [hiccup.form]
        [hiccup.element :only (link-to)]))

(defn index []
  [:div {:id "content"}
   [:h1 {:class "text-success" :style "text-align:center"} "It's whack AF"]])
