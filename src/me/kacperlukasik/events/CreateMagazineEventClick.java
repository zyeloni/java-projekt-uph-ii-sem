package me.kacperlukasik.events;

import me.kacperlukasik.forms.AddMagazineForm;
import me.kacperlukasik.forms.AddPublishingForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMagazineEventClick implements ActionListener
{
    JFrame jFrame;

    public CreateMagazineEventClick(JFrame jFrame)
    {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        jFrame.dispose();
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                AddMagazineForm addMagazineForm = new AddMagazineForm();
            }
        });
    }
}
