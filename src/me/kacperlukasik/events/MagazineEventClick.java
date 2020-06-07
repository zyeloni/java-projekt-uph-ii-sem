package me.kacperlukasik.events;

import me.kacperlukasik.forms.AddPublishingForm;
import me.kacperlukasik.forms.MagazineMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MagazineEventClick implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MagazineMenu magazineMenu = new MagazineMenu();
            }
        });
    }
}
