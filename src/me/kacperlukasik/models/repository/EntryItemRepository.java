package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DBConfig;
import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;
import me.kacperlukasik.models.EntryItem;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EntryItemRepository extends DatabaseTable implements IRepository<EntryItem>
{
    public EntryItemRepository()
    {
        super(DBConfig.DB_ENTRY_ITEM_NAME);
    }

    @Override
    public List<EntryItem> getAll()
    {
        reloadDatabase();
        ArrayList<EntryItem> entryItems = new ArrayList<>();

        Scanner sc = getScanner();

        while (sc.hasNextLine())
        {
            String entryItemLine = sc.nextLine();
            EntryItem entryItem = new EntryItem();

            if (entryItemLine.equals(""))
                continue;

            StringTokenizer tokenizer = new StringTokenizer(entryItemLine, ",");
            entryItem.setId(tokenizer.nextToken());
            entryItem.setTitle(tokenizer.nextToken());
            entryItem.setDesc(tokenizer.nextToken());
            entryItem.setMagazineId(tokenizer.nextToken());

            entryItems.add(entryItem);
        }

        return entryItems;
    }

    @Override
    public EntryItem getById(String id)
    {
        reloadDatabase();
        Scanner sc = getScanner();

        while (sc.hasNextLine())
        {
            String entryItemLine = sc.nextLine();
            EntryItem entryItem = new EntryItem();

            if (entryItemLine.equals(""))
                continue;

            StringTokenizer tokenizer = new StringTokenizer(entryItemLine, ",");
            String _id = tokenizer.nextToken();

            if (!_id.equals(id))
                continue;
            ;

            entryItem.setId(_id);
            entryItem.setTitle(tokenizer.nextToken());
            entryItem.setDesc(tokenizer.nextToken());
            entryItem.setMagazineId(tokenizer.nextToken());

        }

        return null;
    }

    @Override
    public boolean create(EntryItem object)
    {
        reloadDatabase();

        if (object == null)
            return false;

        PrintWriter pw = getPrintWriter();
        pw.println(object.toString());
        pw.close();
        return true;
    }
}
