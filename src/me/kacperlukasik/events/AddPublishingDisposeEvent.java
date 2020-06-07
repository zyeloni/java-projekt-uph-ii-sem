package me.kacperlukasik.events;

import me.kacperlukasik.forms.PublishingMenu;

import java.awt.*;
import java.awt.event.WindowAdapter;

public class AddPublishingDisposeEvent extends WindowAdapter
{
    @Override
    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                PublishingMenu publishingMenu = new PublishingMenu();
            }
        });
    }
}
