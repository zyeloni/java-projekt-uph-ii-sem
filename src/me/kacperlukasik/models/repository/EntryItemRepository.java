package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;

import java.util.List;

public class EntryItemRepository extends DatabaseTable implements IRepository<EntryItemRepository>
{
    public EntryItemRepository()
    {
        super("entryitems.txt");
    }

    @Override
    public List<EntryItemRepository> getAll()
    {
        return null;
    }

    @Override
    public EntryItemRepository getById(String id)
    {
        return null;
    }

    @Override
    public boolean update(EntryItemRepository object)
    {
        return false;
    }

    @Override
    public boolean delete(String id)
    {
        return false;
    }

    @Override
    public boolean create(EntryItemRepository object)
    {
        return false;
    }

    @Override
    public boolean exist(String id)
    {
        return false;
    }
}
