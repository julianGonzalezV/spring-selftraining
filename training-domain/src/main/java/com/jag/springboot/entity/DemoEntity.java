package com.jag.springboot.entity;

import org.springframework.stereotype.Component;


public class DemoEntity {
    private String model;

    public DemoEntity() {
    }

    public DemoEntity(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "model='" + model + '\'' +
                '}';
    }
}
