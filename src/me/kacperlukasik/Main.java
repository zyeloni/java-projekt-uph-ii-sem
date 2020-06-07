package me.kacperlukasik;

import me.kacperlukasik.forms.MenuForm;
import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.repository.EntryItemRepository;
import me.kacperlukasik.models.repository.MagazineRepository;
import me.kacperlukasik.models.repository.PublishingRepository;

import java.awt.*;
import java.util.UUID;

public class Main {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MenuForm menuForm = new MenuForm();
            }
        });

    }
}
