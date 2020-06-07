package me.kacperlukasik.filters;

import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.PublishingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MagazineFilters
{
    public static List<Magazine> byKeyWord(List<Magazine> magazines, String value)
    {
        return magazines.stream()
                .filter(x -> x.getTitle().contains(value) || x.getId().contains(value))
                .collect(Collectors.toList());
    }

    public static List<Magazine> byPublishing(String value)
    {
        PublishingRepository publishingRepository = new PublishingRepository();
        List<Publishing> publishings = publishingRepository.getAll();

        List<Publishing> returnValue = publishings.stream()
                .filter(x -> x.getId().equals(value))
                .collect(Collectors.toList());

        return returnValue.get(0).getMagazines();
    }

}
