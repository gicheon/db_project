package com.example.db_project.db_project;

public class restaurantColumn
{
    private String name;
    private String sort;
    private int service;

    public restaurantColumn (String name, String sort, int service)
    {
        this.name = name;
        this.sort = sort;
        this.service = service;
    }

    public String getName()
    {
        return name;
    }

    public String getSort()
    {
        return sort;
    }

    public int getService()
    {
        return service;
    }
}
