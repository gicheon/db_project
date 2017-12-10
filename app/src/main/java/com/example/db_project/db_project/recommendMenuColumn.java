package com.example.db_project.db_project;

public class recommendMenuColumn
{
    private String restaurant;
    private String menu;
    private int menuId;
    private int price;
    private int count;

    public recommendMenuColumn(String restaurant, String menu, int price, int count)
    {
        this.restaurant = restaurant;
        this.menu = menu;
        this.price = price;
        this.count = count;
    }

    public String getRestaurant() { return restaurant; }

    public String getMenu() { return menu; }

    public int getPrice() { return price; }

    public int getCount() { return count; }
}
