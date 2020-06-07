package me.kacperlukasik.forms;

import me.kacperlukasik.events.MagazineEventClick;
import me.kacperlukasik.events.PublishingEventClick;

import javax.swing.*;
import java.awt.*;

public class MenuForm extends JFrame
{
    private JButton publishingBtn;
    private JPanel mainPanel;
    private JButton magazineBtn;
    private JLabel footerLabel;
    private JLabel headerLabel;

    public MenuForm()
    {
        super("Jednostanowiskowa Baza Czasopism");
        mainPanel.setSize(400, 600);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        publishingBtn.addActionListener(new PublishingEventClick());
        magazineBtn.addActionListener(new MagazineEventClick());
    }
}
