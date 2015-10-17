(ns wackernews.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5 {:lang "en"}
         [:head
          [:title title]
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          [:body
           [:nav {:class "navbar navbar-defaultl"}
            [:div {:class "container-fluid"}
             [:div {:class "navbar-header"}]]]
           [:div {:class "container"} content ]]]))

