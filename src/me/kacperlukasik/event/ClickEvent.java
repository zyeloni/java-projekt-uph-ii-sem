package me.kacperlukasik.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ClickEvent implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        onEvent();
    }

    protected abstract void onEvent();
}
