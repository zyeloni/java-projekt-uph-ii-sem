package me.kacperlukasik.events;

import me.kacperlukasik.forms.MenuForm;
import me.kacperlukasik.forms.PublishingMenu;

import java.awt.*;

public class PublishingEventClick extends ClickEvent
{
    @Override
    protected void onEvent()
    {
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
