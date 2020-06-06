package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;

import java.util.List;

public class MagazineRepository extends DatabaseTable implements IRepository<MagazineRepository>
{
    public MagazineRepository()
    {
        super("magazine.txt");
    }

    @Override
    public List<MagazineRepository> getAll()
    {
        return null;
    }

    @Override
    public MagazineRepository getById(String id)
    {
        return null;
    }

    @Override
    public boolean update(MagazineRepository object)
    {
        return false;
    }

    @Override
    public boolean delete(String id)
    {
        return false;
    }

    @Override
    public boolean create(MagazineRepository object)
    {
        return false;
    }

    @Override
    public boolean exist(String id)
    {
        return false;
    }
}
