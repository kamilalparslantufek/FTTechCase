package com.patikacase.firstcase.models;

public class UserProductListModel {
    private String Id;

    private String Name;

    public UserProductListModel(String id, String name) {

        this.Id = id;
        this.Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
