(ns wackernews.views.contents
  (:use [hiccup.form]
        [hiccup.page :only (html5 include-css include-js)]
        [hiccup.element :only (link-to)]))

(def hn-url "http://news.ycombinator.com/")

(defn post [ story ]
  [:tr 
   [:td 
    [:table {:border "0", :cellpadding "0", :cellspacing "0"}
     [:tbody 
      [:tr {:class "athing"}
       [:td {:align "right", :valign "top", :class "title"} 
        [:span {:class "rank"} "1."]] "      " 
       [:td 
        [:center 
         [:a {:id (str "up_" story.id), :onclick "return vote(this)", :href (str hn-url "vote?for=" story.id)} 
          [:div {:class "votearrow", :title "upvote"}]]]]
       [:td {:class "title"} 
        [:span {:class "deadmark"}] 
        [:a {:href story.url} story.title] 
        [:span {:class "sitebit comhead"} " (" 
         [:a {:href (str hn-url "from?site=rbth.co.uk")} 
          [:span {:class "sitestr"} "rbth.co.uk"]] ")"]]]
      [:tr 
       [:td {:colspan "2"}] 
       [:td {:class "subtext"}  
        [:span {:class "score", :id (str "score_" story.id } (str story.score " points")] " by " 
        [:a {:href (str hn-url "user?id=" story.by)} story.by ] " " 
        [:a {:href (str hn-url "item?id=" story.id)} story.time ] "  | " 
        [:a {:href (str hn-url "item?id=" story.id)} (str story.descendents " comments")] "              "]]  
      [:tr {:class "spacer", :style "height:5px"}]]]]])
