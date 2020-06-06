package me.kacperlukasik.models;

import me.kacperlukasik.database.DatabaseTable;

import java.util.List;
import java.util.UUID;

public class Publishing
{
    private String id;
    private String title;
    private List<Magazine> magazines;

    public Publishing()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<Magazine> getMagazines()
    {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines)
    {
        this.magazines = magazines;
    }

    @Override
    public String toString()
    {
        return String.format("%s;%s", id);
    }
}
