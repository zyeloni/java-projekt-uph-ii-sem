package me.kacperlukasik.forms;

import me.kacperlukasik.models.EntryItem;
import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.MagazineRepository;
import me.kacperlukasik.models.repository.PublishingRepository;

import javax.swing.*;
import java.awt.*;

public class MagazineInfoForm extends JFrame
{
    private String id;
    private JList entryItemList;
    private JLabel numberLabel;
    private JLabel titleLabel;
    private JLabel publishingLabel;
    private JPanel mainPanel;
    private DefaultListModel model;
    private int listCount = 0;

    public MagazineInfoForm(String id)
    {
        super("Informacje o czasopiśmie");
        this.id = id;
        model = new DefaultListModel();
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setData();
    }

    private void setData()
    {
        MagazineRepository magazineRepository = new MagazineRepository();
        PublishingRepository publishingRepository = new PublishingRepository();

        Magazine magazine = magazineRepository.getById(id);
        Publishing publishing = publishingRepository.getById(magazine.getPublishingId());

        titleLabel.setText(magazine.getTitle());
        numberLabel.setText(String.valueOf(magazine.getNumber()));
        publishingLabel.setText(publishing.getTitle());

        for (EntryItem entryItem : magazine.getEntryItems())
        {
            model.add(listCount, entryItem.getTitle() + " | " + entryItem.getDesc());
        }

        entryItemList.setModel(model);
    }


}
