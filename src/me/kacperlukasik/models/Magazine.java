package me.kacperlukasik.models;

import java.util.List;
import java.util.UUID;

public class Magazine
{
    private String id;
    private String title;
    private int number;
    private List<EntryItem> entryItems;
    private String publishingId;

    public Magazine()
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

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public List<EntryItem> getEntryItems()
    {
        return entryItems;
    }

    public void setEntryItems(List<EntryItem> entryItems)
    {
        this.entryItems = entryItems;
    }

    public String getPublishingId()
    {
        return publishingId;
    }

    public void setPublishingId(String publishingId)
    {
        this.publishingId = publishingId;
    }

    @Override
    public String toString()
    {
        return String.format("%s,%s,%d,%s", id, title, number, publishingId);
    }
}
