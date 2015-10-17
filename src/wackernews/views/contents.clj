(ns wackernews.views.contents
  (:use [hiccup.form]
        [hiccup.page :only (html5 include-css include-js)]
        [hiccup.element :only (link-to)]))

(defn index []
  [:tr 
   [:td 
    [:table {:border "0", :cellpadding "0", :cellspacing "0"}
     [:tbody 
      [:tr {:class "athing"}
       [:td {:align "right", :valign "top", :class "title"} 
        [:span {:class "rank"} "1."]] "      " 
       [:td 
        [:center 
         [:a {:id "up_10402150", :onclick "return vote(this)", :href "vote?for=10402150&dir=up&auth=764bf5d09d9b274e86125bbeb4790a3f9439ccbc&goto=news"} 
          [:div {:class "votearrow", :title "upvote"}]]]] 
       [:td {:class "title"} 
        [:span {:class "deadmark"}] 
        [:a {:href "http://rbth.co.uk/multimedia/pictures/2014/04/07/before_the_internet_top_11_soviet_pcs_35711"} "Soviet PCs"] 
        [:span {:class "sitebit comhead"} " (" 
         [:a {:href "from?site=rbth.co.uk"} 
          [:span {:class "sitestr"} "rbth.co.uk"]] ")"]]]
           [:tr 
            [:td {:colspan "2"}] 
            [:td {:class "subtext"}  
             [:span {:class "score", :id "score_10402150"} "112 points"] " by " 
             [:a {:href "user?id=grhmc"} "grhmc"] " " 
             [:a {:href "item?id=10402150"} "2 hours ago"] "  | " 
             [:a {:href "flag?id=10402150&auth=764bf5d09d9b274e86125bbeb4790a3f9439ccbc&goto=news"} "flag"] " | " 
             [:a {:href "item?id=10402150"} "49 comments"] "              "]]  
           [:tr {:class "spacer", :style "height:5px"}]]]]])
