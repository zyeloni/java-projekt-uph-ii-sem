package me.kacperlukasik.forms.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ErrorDialog extends JDialog
{
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel errorLabel;

    public ErrorDialog(String errorMessage)
    {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        errorLabel.setText(errorMessage);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        buttonOK.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onOK();
            }
        });
    }

    private void onOK()
    {
        // add your code here
        dispose();
    }
}
