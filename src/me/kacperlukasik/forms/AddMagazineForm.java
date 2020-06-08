package me.kacperlukasik.forms;

import me.kacperlukasik.ComboItem;
import me.kacperlukasik.events.AddMagazineEvent;
import me.kacperlukasik.exceptions.NoFillException;
import me.kacperlukasik.forms.dialogs.ErrorDialog;
import me.kacperlukasik.models.Publishing;
import me.kacperlukasik.models.repository.PublishingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddMagazineForm extends JFrame
{
    private JPanel mainPanel;
    private JComboBox publishingField;
    private JTextField titleField;
    private JSpinner numberField;
    private JList list1;
    private JTextField titleEntryItem;
    private JTextArea desEntryItem;
    private JButton entryItemAdd;
    private JButton addBtn;
    private DefaultListModel entryModel;
    private int listCount = 0;

    public AddMagazineForm()
    {
        super("Dodawanie nowego magazynu");
        entryModel = new DefaultListModel();
        list1.setModel(entryModel);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        init();
        entryItemAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    addEntryItem();
                } catch (NoFillException noFillException)
                {
                    ErrorDialog errorDialog = new ErrorDialog("Wypełnij wszystkie pola w spisie treści !");
                    errorDialog.pack();
                    errorDialog.setVisible(true);
                }
            }
        });

        addBtn.addActionListener(new AddMagazineEvent(
                publishingField,
                titleField,
                numberField,
                list1,
                this
        ));
    }

    private void init()
    {
        PublishingRepository publishingRepository = new PublishingRepository();
        List<Publishing> publishingList = publishingRepository.getAll();

        for (Publishing p : publishingList)
        {
            publishingField.addItem(new ComboItem(p.getTitle(), p.getId()));
        }

    }

    private void addEntryItem() throws NoFillException
    {
        if (titleEntryItem.getText().equals("") || desEntryItem.getText().equals(""))
        {
            throw new NoFillException("Nie wszystkie pola zostały wypełnione !");
        }

        entryModel.add(listCount, titleEntryItem.getText() + " : " + desEntryItem.getText());
        listCount++;
    }
}
