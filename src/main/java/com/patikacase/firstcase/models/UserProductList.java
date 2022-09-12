package com.patikacase.firstcase.models;

import java.util.ArrayList;

public class UserProductList {
    private ArrayList<UserProductListModel> Users;

    private ArrayList<UserProductListModel> Products;

    public UserProductList(ArrayList<UserProductListModel> users, ArrayList<UserProductListModel> products) {
        this.Users = users;
        this.Products = products;
    }

    public ArrayList<UserProductListModel> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<UserProductListModel> users) {
        Users = users;
    }

    public ArrayList<UserProductListModel> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<UserProductListModel> products) {
        Products = products;
    }
}
