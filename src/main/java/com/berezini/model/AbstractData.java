package com.berezini.model;

public abstract class AbstractData {

    private String name;
    private long id;
    private Category category;

    public AbstractData(String name, long id, Category category) {
        this.name = name;
        this.id = id;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }
}
