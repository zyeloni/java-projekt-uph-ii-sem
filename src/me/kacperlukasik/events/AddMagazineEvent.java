package me.kacperlukasik.events;

import me.kacperlukasik.forms.AddMagazineForm;
import me.kacperlukasik.forms.MagazineMenu;
import me.kacperlukasik.forms.dialogs.ErrorDialog;
import me.kacperlukasik.models.EntryItem;
import me.kacperlukasik.models.Magazine;
import me.kacperlukasik.models.repository.MagazineRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AddMagazineEvent implements ActionListener
{
    JFrame jFrame;
    String publishing;
    JTextField title;
    JSpinner number;
    JList entryItems;

    public AddMagazineEvent(String publishing, JTextField title, JSpinner number, JList entryItems, JFrame jFrame)
    {
        this.publishing = publishing;
        this.title = title;
        this.number = number;
        this.entryItems = entryItems;
        this.jFrame = jFrame;
    }

    private boolean validate()
    {
        try
        {
            number.commitEdit();
        } catch (ParseException parseException)
        {
            parseException.printStackTrace();
        }

        if (!publishing.equals("") && !title.getText().equals("") && (Integer) number.getValue() >= 1)
        {
            if (entryItems.getModel().getSize() > 0)
                return true;

            return false;
        }

        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (!validate())
        {
            ErrorDialog errorDialog = new ErrorDialog("<html>Nie wszystkie pola zostały wypełnione ! <br> Lub nie zostały dobrze wypełnione</html>");
            errorDialog.pack();
            errorDialog.setVisible(true);

            return;
        }

        Magazine magazine = new Magazine();
        MagazineRepository magazineRepository = new MagazineRepository();

        magazine.setTitle(title.getText());
        magazine.setPublishingId(publishing);
        magazine.setNumber((Integer) number.getValue());

        List<EntryItem> entryItemList = new ArrayList<EntryItem>();

        for (int i = 0; i < entryItems.getModel().getSize(); i++)
        {
            EntryItem entryItem = new EntryItem();
            entryItem.setMagazineId(magazine.getId());

            String[] values = ((String) entryItems.getModel().getElementAt(i)).split(" : ");

            entryItem.setTitle(values[0]);
            entryItem.setDesc(values[1]);

            entryItemList.add(entryItem);
        }

        magazine.setEntryItems(entryItemList);

        magazineRepository.create(magazine);

        jFrame.dispose();

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                MagazineMenu magazineMenu = new MagazineMenu();
            }
        });
    }
}
