package com.example.db_project.db_project;

public class userColumn
{
    private int id;
    private String name;
    private int quantityPref;
    private int spicePref;
    private int creamyPref;
    private int hotPref;
    private int sweetPref;

    public userColumn(int id, String name, int quantityPref,
                      int spicePref, int creamyPref, int hotPref, int sweetPref)
    {
        this.id = id;
        this.name = name;
        this.quantityPref = quantityPref;
        this.spicePref = spicePref;
        this.creamyPref = creamyPref;
        this.hotPref = hotPref;
        this.sweetPref = sweetPref;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantityPref()
    {
        return quantityPref;
    }
    public int getSpicePref()
    {
        return spicePref;
    }

    public int getCreamyPref()
    {
        return creamyPref;
    }

    public int getHotPref()
    {
        return hotPref;
    }

    public int getSweetPref()
    {
        return  sweetPref;
    }
}
