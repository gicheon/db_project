package com.example.db_project.db_project;

public class saleColumn
{
    private String name;
    private int menuId;

    public saleColumn(String name, int menuId)
    {
        this.name = name;
        this.menuId = menuId;
    }

    public String getName()
    {
        return name;
    }

    public int getMenuId()
    {
        return menuId;
    }
}
