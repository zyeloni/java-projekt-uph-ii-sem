package me.kacperlukasik.forms;

import me.kacperlukasik.events.CreatePublishingEventClick;
import me.kacperlukasik.filters.PublishingFilters;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.PublishingRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PublishingMenu extends JFrame
{
    private JPanel mainPanel;
    private JTable publishingTable;
    private JButton createBtn;
    private JTextField filterField;
    private JButton searchBtn;

    public PublishingMenu()
    {
        super("Baza wydawnictw");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        createTable();
        createBtn.addActionListener(new CreatePublishingEventClick(this));
        searchBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createTable();
            }
        });
    }

    private void createTable()
    {
        PublishingRepository publishingRepository = new PublishingRepository();
        List<Publishing> publishings = publishingRepository.getAll();

        if (!filterField.getText().equals(""))
            publishings = PublishingFilters.byKeyWord(publishings,filterField.getText());

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nazwa"}, 0);
        for (Publishing publishing : publishings)
        {
            model.addRow(
                    new Object[]{
                            publishing.getId(),
                            publishing.getTitle()
                    }
            );
        }

        publishingTable.setModel(model);
    }
}
