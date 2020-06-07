package me.kacperlukasik.forms;

import me.kacperlukasik.events.AddPublishingDisposeEvent;
import me.kacperlukasik.events.OnPublishingCreateEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPublishingForm extends JFrame
{
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton DODAJButton;

    public AddPublishingForm() throws HeadlessException
    {
        super("Dodawanie nowego wydawnictwa");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        this.addWindowListener(new AddPublishingDisposeEvent());

        DODAJButton.addActionListener(new OnPublishingCreateEvent(textField1,this));
    }
}
