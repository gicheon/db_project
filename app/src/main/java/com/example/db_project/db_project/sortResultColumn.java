package com.example.db_project.db_project;

public class sortResultColumn
{
    private String name;
    private int score;
    private int service;
    private int reviewCount;

    public sortResultColumn(String name, int score, int service, int count)
    {
        this.name = name;
        this.score = score;
        this.service = service;
        this.reviewCount = count;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public int getService()
    {
        return service;
    }

    public int getReviewCount()
    {
        return reviewCount;
    }
}
