package com.shuttle.orders.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Services implements Serializable {

    private long id;
    private String name;
    private String color;
    private String icon;

}