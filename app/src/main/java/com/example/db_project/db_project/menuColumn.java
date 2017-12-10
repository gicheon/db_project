package com.example.db_project.db_project;

public class menuColumn
{
    private int menuId;
    private String name;
    private int price;
    private int quantity;
    private int spice;
    private int creamy;
    private int hot;
    private int sweet;
    private int reviewCount;

    public menuColumn(int menuId, String name, int price, int quantity, int spice, int creamy, int hot, int sweet, int reviewCount)
    {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.spice = spice;
        this.creamy = creamy;
        this.hot = hot;
        this.sweet = sweet;
        this.reviewCount = reviewCount;
    }

    public int getMenuId()
    {
        return menuId;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getSpice()
    {
        return spice;
    }

    public int getCreamy()
    {
        return creamy;
    }

    public int getHot()
    {
        return hot;
    }

    public int getSweet()
    {
        return  sweet;
    }

    public int getReviewCount()
    {
        return reviewCount;
    }
}
