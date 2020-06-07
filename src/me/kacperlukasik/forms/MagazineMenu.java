package me.kacperlukasik.forms;

import me.kacperlukasik.ComboItem;
import me.kacperlukasik.events.CreateMagazineEventClick;
import me.kacperlukasik.filters.MagazineFilters;
import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.MagazineRepository;
import me.kacperlukasik.models.repository.PublishingRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MagazineMenu extends JFrame
{
    private JTable table1;
    private JComboBox comboBox1;
    private JButton searchBtn;
    private JLabel publishingCombo;
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton addBtn;
    private JButton showInfo;

    public MagazineMenu()
    {
        super("Baza magazynów");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        initCombo();
        createTable();
        searchBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                createTable();
            }
        });
        addBtn.addActionListener(new CreateMagazineEventClick(this));
        showInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        MagazineInfoForm magazineInfoForm = new MagazineInfoForm((String) table1.getModel().getValueAt(table1.getSelectedRow(), 0));
                    }
                });
            }
        });
    }

    private void initCombo()
    {
        PublishingRepository publishingRepository = new PublishingRepository();
        List<Publishing> publishingList = publishingRepository.getAll();

        comboBox1.addItem(new ComboItem("Wszystkie", "all"));
        for (Publishing p : publishingList)
        {
            comboBox1.addItem(new ComboItem(p.getTitle(), p.getId()));
        }

    }

    private void createTable()
    {
        MagazineRepository magazineRepository = new MagazineRepository();
        PublishingRepository publishingRepository = new PublishingRepository();
        List<Magazine> magazines = magazineRepository.getAll();

        Object item = comboBox1.getSelectedItem();
        String publishingFiltr = ((ComboItem) item).getValue();
        String keywordFiltr = textField1.getText();

        if (!publishingFiltr.equals("all"))
            magazines = MagazineFilters.byPublishing(publishingFiltr);

        if (!keywordFiltr.equals(""))
            magazines = MagazineFilters.byKeyWord(magazines, keywordFiltr);


        DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "Tytuł", "Numer wydania", "Wydawnictwo"},
                0
        );

        for (Magazine magazine : magazines)
        {
            model.addRow(
                    new Object[]{
                            magazine.getId(),
                            magazine.getTitle(),
                            magazine.getNumber(),
                            publishingRepository
                                    .getById(magazine.getPublishingId())
                                    .getTitle()
                    }
            );
        }

        table1.setModel(model);
    }
}
