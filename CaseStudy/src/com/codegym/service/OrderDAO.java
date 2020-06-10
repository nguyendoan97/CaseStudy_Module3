package com.codegym.service;

import com.codegym.utils.DBConnection;

public class OrderDAO {

    DBConnection dbConnection;
    public OrderDAO(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }



}
