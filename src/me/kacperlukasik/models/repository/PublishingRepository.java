package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;
import me.kacperlukasik.models.Publishing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PublishingRepository extends DatabaseTable implements IRepository<Publishing>
{
    public PublishingRepository()
    {
        super("publishing.txt");
    }

    @Override
    public List<Publishing> getAll()
    {
        ArrayList<Publishing> results = new ArrayList<>();

        reloadDatabase();

        Scanner scanner = getScanner();

        while (scanner.hasNextLine())
        {
            String valueLine = scanner.nextLine();

            if (valueLine == "")
                continue;

            StringTokenizer tokenizer = new StringTokenizer(valueLine);

            if (tokenizer.hasMoreTokens())
            {
                Publishing publishing = new Publishing();
                publishing.setId(tokenizer.nextToken());
                publishing.setTitle(tokenizer.nextToken());
                //TODO Repository Magazine
            }
        }

        return results;
    }

    @Override
    public Publishing getById(String id)
    {
        reloadDatabase();

        Scanner scanner = getScanner();

        while (scanner.hasNextLine())
        {
            String valueLine = scanner.nextLine();

            if (valueLine == "")
                continue;

            StringTokenizer tokenizer = new StringTokenizer(valueLine);

            if (tokenizer.hasMoreTokens())
            {
                Publishing publishing = new Publishing();

                publishing.setId(tokenizer.nextToken());
                publishing.setTitle(tokenizer.nextToken());
                //TODO Repository Magazine
            }
        }

        return null;
    }

    @Override
    public boolean update(Publishing object)
    {
        return false;
    }

    @Override
    public boolean delete(String id)
    {
        return false;
    }

    @Override
    public boolean create(Publishing object)
    {
        reloadDatabase();
        setAppend();

        if (object == null)
            return false;

        getPrintWriter().println(object.toString());
        //TODO Magazine Repository

        return true;
    }

    @Override
    public boolean exist(String id)
    {
        reloadDatabase();

        Scanner scanner = getScanner();

        while (scanner.hasNextLine())
        {
            String valueLine = scanner.nextLine();

            if (valueLine == "")
                continue;

            StringTokenizer tokenizer = new StringTokenizer(valueLine);

            if (tokenizer.countTokens() >= 1)
            {
                if (tokenizer.nextToken() == id)
                    return true;
            }
        }

        return false;
    }
}
