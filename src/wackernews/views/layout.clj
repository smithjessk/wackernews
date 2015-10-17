(ns wackernews.views.layout
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn application [title & content]
  (html5 {:lang "en"}
         [:head
          [:title title]
          (include-css "css/news.css")]
         [:body
          [:center 
           [:table {:id "hnmain", :border "0", :cellpadding "0", :cellspacing "0", :width "85%", :bgcolor "#f6f6ef"}  
            [:tbody 
             [:tr 
              [:td {:bgcolor "#ff6600"} 
               [:table {:border "0", :cellpadding "0", :cellspacing "0", :width "100%", :style "padding:2px"} 
                [:tbody 
                 [:tr 
                  [:td {:style "width:18px;padding-right:4px"} 
                   [:a {:href "http://www.ycombinator.com"} 
                    [:img {:src "img/logo.png", :width "18", :height "18", :style "border:1px #ffffff solid;"}]]]  
                  [:td {:style "line-height:12pt; height:10px;"} 
                   [:span {:class "pagetop"} 
                    [:b 
                     [:a {:href "news"} "Wacker News"]] 
                    [:img {:src "img/s.gif", :height "1", :width "10"}] 
                    [:a {:href "newest"} "new"] " | " 
                    [:a {:href "threads?id=Xyzodiac"} "threads"] " | " 
                    [:a {:href "newcomments"} "comments"] " | " 
                    [:a {:href "show"} "show"] " | " 
                    [:a {:href "ask"} "ask"] " | " 
                    [:a {:href "jobs"} "jobs"] " | " 
                    [:a {:href "submit"} "submit"]]] 
                  [:td {:style "text-align:right;padding-right:4px;"} 
                   [:span {:class "pagetop"}  
                    [:a {:href "user?id=pg"} "pg"] "\n                (42069) |\n                " 
                    [:a {:href "logout?goto=news"} "logout"] ]] ]]]]]  
             [:tr {:style "height:10px"}]
             content]]]]))
