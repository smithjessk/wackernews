(ns wackernews.views.contents
  (:use [hiccup.form]
        [hiccup.page :only (html5 include-css include-js)]
        [hiccup.element :only (link-to)]))

(def hn-url "http://news.ycombinator.com/")

(defn post [index, story]
  [:span
   [:tr {:class "athing"}
    [:td {:align "right", :valign "top", :class "title"} 
     [:span {:class "rank"} (str (+ index 1) ".")]] "      " 
    [:td 
     [:center 
      [:a {:id (str "up_" (get story :id)), :onclick "return vote(this)", :href (str hn-url "vote?for=" (get story :id))} 
       [:div {:class "votearrow", :title "upvote"}]]]]
    [:td {:class "title"} 
     [:span {:class "deadmark"}] 
     [:a {:href (get story :url)} (get story :title)] 
     [:span {:class "sitebit comhead"} " (" 
      [:a {:href (str hn-url "from?site=rbth.co.uk")}
       [:span {:class "sitestr"} "rbth.co.uk"]] ")"]]]
   [:tr 
    [:td {:colspan "2"}] 
    [:td {:class "subtext"}  
     [:span {:class "score", :id (str "score_" (get story :id))} (str (get story :score) " points")] " by " 
     [:a {:href (str hn-url "user?id=" (get story :by))} (get story :by)] " " 
     [:a {:href (str hn-url "item?id=" (get story :id))} (get story :time)] "  | " 
     [:a {:href (str hn-url "item?id=" (get story :id))} (str (get story :descendants) " comments")] "              "]]  
   [:tr {:class "spacer", :style "height:5px"}]])
