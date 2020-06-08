package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DBConfig;
import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;
import me.kacperlukasik.models.EntryItem;
import me.kacperlukasik.models.Magazine;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MagazineRepository extends DatabaseTable implements IRepository<Magazine>
{
    public MagazineRepository()
    {
        super(DBConfig.DB_MAGAZINE_NAME);
    }

    @Override
    public List<Magazine> getAll()
    {
        reloadDatabase();
        ArrayList<Magazine> magazines = new ArrayList<>();
        Scanner sc = getScanner();
        EntryItemRepository entryItemRepository = new EntryItemRepository();

        while (sc.hasNextLine())
        {
            String magazineLine = sc.nextLine();
            Magazine magazine = new Magazine();

            if (magazineLine.equals(""))
                continue;

            StringTokenizer tokenizer = new StringTokenizer(magazineLine, ",");

            magazine.setId(tokenizer.nextToken());
            magazine.setTitle(tokenizer.nextToken());
            magazine.setNumber(Integer.parseInt(tokenizer.nextToken()));
            magazine.setPublishingId(tokenizer.nextToken());

            List<EntryItem> entryItems = entryItemRepository.getAll().stream().filter(x -> x.getMagazineId().equals(magazine.getId())).collect(Collectors.toList());
            magazine.setEntryItems(entryItems);

            magazines.add(magazine);
        }

        return magazines;
    }

    @Override
    public Magazine getById(String id)
    {
        reloadDatabase();
        Scanner sc = getScanner();
        EntryItemRepository entryItemRepository = new EntryItemRepository();

        while (sc.hasNextLine())
        {
            String magazineLine = sc.nextLine();
            Magazine magazine = new Magazine();

            if (magazineLine.equals(""))
                continue;

            StringTokenizer tokenizer = new StringTokenizer(magazineLine, ",");
            String _id = tokenizer.nextToken();

            if (!_id.equals(id))
                continue;

            magazine.setId(_id);
            magazine.setTitle(tokenizer.nextToken());
            magazine.setNumber(Integer.parseInt(tokenizer.nextToken()));
            magazine.setPublishingId(tokenizer.nextToken());

            List<EntryItem> entryItems = entryItemRepository.getAll().stream().filter(x -> x.getMagazineId().equals(magazine.getId())).collect(Collectors.toList());
            magazine.setEntryItems(entryItems);

            return magazine;
        }

        return null;
    }

    @Override
    public boolean create(Magazine object)
    {
        reloadDatabase();

        EntryItemRepository entryItemRepository = new EntryItemRepository();

        if (object == null)
            return false;

        PrintWriter printWriter = getPrintWriter();

        printWriter.println(object.toString());
        for (EntryItem entryItem : object.getEntryItems())
            entryItemRepository.create(entryItem);

        printWriter.close();

        return true;
    }

}
