package me.kacperlukasik.events;

import me.kacperlukasik.forms.dialogs.ErrorDialog;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.PublishingRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnPublishingCreateEvent implements ActionListener
{
    JTextField value;
    JFrame jFrame;


    public OnPublishingCreateEvent(JTextField value, JFrame jFrame)
    {
        this.value = value;
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (value.getText().equals(""))
        {
            ErrorDialog errorDialog = new ErrorDialog("Nie wypełniono wszystkich pół !");
            errorDialog.pack();
            errorDialog.setVisible(true);
            errorDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            return;
        }

        PublishingRepository publishingRepository = new PublishingRepository();
        Publishing publishing = new Publishing();
        publishing.setTitle(value.getText());
        publishingRepository.create(publishing);

        jFrame.dispose();
    }
}
