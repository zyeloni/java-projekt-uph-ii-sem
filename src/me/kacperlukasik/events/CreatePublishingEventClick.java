package me.kacperlukasik.events;

import me.kacperlukasik.forms.AddPublishingForm;
import me.kacperlukasik.forms.PublishingMenu;

import javax.swing.*;
import java.awt.*;

public class CreatePublishingEventClick extends ClickEvent
{
    private JFrame jFrame;

    public CreatePublishingEventClick(JFrame jFrame)
    {
        this.jFrame = jFrame;
    }

    @Override
    protected void onEvent()
    {
        jFrame.dispose();
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                AddPublishingForm addPublishingForm = new AddPublishingForm();
            }
        });
    }
}
