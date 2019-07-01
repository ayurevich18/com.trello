package com.trello.api.models;

public class Checklists {
    public String id;
    public String name;
    public String idBoard;
    public String idCard;

    @Override
    public String toString() {
        return "Checklists{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
