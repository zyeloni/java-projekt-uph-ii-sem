package me.kacperlukasik.filters;

import me.kacperlukasik.models.Publishing;

import java.util.List;
import java.util.stream.Collectors;

public class PublishingFilters
{
    public static List<Publishing> byKeyWord(List<Publishing> publishings, String value)
    {
        return publishings.stream()
                .filter(x -> x.getTitle().contains(value) || x.getId().contains(value))
                .collect(Collectors.toList());
    }
}
