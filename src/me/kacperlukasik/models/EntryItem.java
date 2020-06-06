package me.kacperlukasik.models;

import java.util.UUID;

public class EntryItem
{
    private String id;
    private String title;
    private String desc;
    private String magazineId;

    public EntryItem()
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

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getMagazineId()
    {
        return magazineId;
    }

    public void setMagazineId(String magazineId)
    {
        this.magazineId = magazineId;
    }
}
