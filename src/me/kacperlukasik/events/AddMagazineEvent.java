package me.kacperlukasik.events;

import me.kacperlukasik.ComboItem;
import me.kacperlukasik.exceptions.NoFillException;
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

public class AddMagazineEvent implements ActionListener
{
    JFrame jFrame;
    JComboBox publishing;
    JTextField title;
    JSpinner number;
    JList entryItems;

    public AddMagazineEvent(JComboBox publishing, JTextField title, JSpinner number, JList entryItems, JFrame jFrame)
    {
        this.publishing = publishing;
        this.title = title;
        this.number = number;
        this.entryItems = entryItems;
        this.jFrame = jFrame;
    }

    private boolean validate() throws NoFillException
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
        }

        throw new NoFillException("Nie wszystkie pola zostały wypełnione !");
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            validate();
        }
        catch (NoFillException noFillException)
        {
            ErrorDialog errorDialog = new ErrorDialog("<html>Nie wszystkie pola zostały wypełnione ! <br> Lub nie zostały dobrze wypełnione</html>");
            errorDialog.pack();
            errorDialog.setVisible(true);
            return;
        }

        Magazine magazine = new Magazine();
        MagazineRepository magazineRepository = new MagazineRepository();

        magazine.setTitle(title.getText());

        Object item = publishing.getSelectedItem();
        String publishingItem = ((ComboItem)item).getValue();

        magazine.setPublishingId(publishingItem);
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
