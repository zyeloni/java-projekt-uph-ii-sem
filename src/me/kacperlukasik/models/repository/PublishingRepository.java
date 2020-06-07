package me.kacperlukasik.models.repository;

import me.kacperlukasik.database.DatabaseTable;
import me.kacperlukasik.database.IRepository;
import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.Publishing;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PublishingRepository extends DatabaseTable implements IRepository<Publishing>
{
    public PublishingRepository()
    {
        super("publishing.txt");
    }

    @Override
    public List<Publishing> getAll()
    {
        reloadDatabase();
        ArrayList<Publishing> publishings = new ArrayList<>();

        Scanner scanner = getScanner();
        MagazineRepository magazineRepository = new MagazineRepository();

        while (scanner.hasNextLine())
        {
            String valueLine = scanner.nextLine();

            if (valueLine == "")
                continue;

            StringTokenizer tokenizer = new StringTokenizer(valueLine, ",");

            if (tokenizer.hasMoreTokens())
            {
                Publishing publishing = new Publishing();
                publishing.setId(tokenizer.nextToken());
                publishing.setTitle(tokenizer.nextToken());

                List<Magazine> magazines = magazineRepository.getAll().stream().filter(x -> x.getPublishingId().equalsIgnoreCase(publishing.getId())).collect(Collectors.toList());
                publishing.setMagazines(magazines);

                publishings.add(publishing);
            }
        }

        return publishings;
    }

    @Override
    public Publishing getById(String id)
    {
        reloadDatabase();

        Scanner scanner = getScanner();
        MagazineRepository magazineRepository = new MagazineRepository();

        while (scanner.hasNextLine())
        {
            String valueLine = scanner.nextLine();

            if (valueLine == "")
                continue;

            StringTokenizer tokenizer = new StringTokenizer(valueLine, ",");
            String _id = tokenizer.nextToken();

            if (_id.equals(id))
            {
                Publishing publishing = new Publishing();

                publishing.setId(_id);
                publishing.setTitle(tokenizer.nextToken());

                List<Magazine> magazines = magazineRepository.getAll().stream().filter(x -> x.getPublishingId() == publishing.getId()).collect(Collectors.toList());
                publishing.setMagazines(magazines);

                return publishing;
            }
        }

        return null;
    }

    @Override
    public boolean create(Publishing object)
    {
        reloadDatabase();

        if (object == null)
            return false;

        PrintWriter printWriter = getPrintWriter();
        MagazineRepository magazineRepository = new MagazineRepository();

        printWriter.println(object.toString());

        printWriter.close();

        return true;
    }
}
