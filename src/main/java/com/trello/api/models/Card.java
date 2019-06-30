package com.trello.api.models;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;
    public String comments;
    public Badges badges;
    public List<Labels>labels;


    public Card() {
    }

    public Card(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", comments='" + comments + '\'' +

                ", badges=" + badges +
                '}';
    }




        public class Badges {
        Badges badges=new Badges();


    public String location;
    public String votes;
    public String viewingMemberVoted;
    public String subscribed;
    public String fogbugz;
    public String checkItems;
    public String checkItemsChecked;
    public String comments;
    public String attachments;
    public String description;
    public String due;
    public String  dueComplete;

    @Override
    public String toString() {
        return "Badges{" +
                "badges=" + badges +
                ", location=" + location +
                ", votes='" + votes + '\'' +
                ", viewingMemberVoted=" + viewingMemberVoted +
                ", subscribed=" + subscribed +
                ", fogbugz='" + fogbugz + '\'' +
                ", checkItems='" + checkItems + '\'' +
                ", checkItemsChecked='" + checkItemsChecked + '\'' +
                ", comments='" + comments + '\'' +
                ", attachments='" + attachments + '\'' +
                ", description=" + description +
                ", due='" + due + '\'' +
                ", dueComplete=" + dueComplete +
                '}';
    }
}

public class Labels{
        public List<Labels> labels=new ArrayList<>();
        public String color;

}
}




