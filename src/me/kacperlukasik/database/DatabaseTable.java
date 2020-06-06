package me.kacperlukasik.database;

import java.io.*;
import java.util.Scanner;

public abstract class DatabaseTable
{
    private final String FILE_NAME;
    private Scanner scanner;
    private PrintWriter printWriter;

    public DatabaseTable(String FILE_NAME)
    {
        this.FILE_NAME = FILE_NAME;
        reloadDatabase();
    }

    public void reloadDatabase()
    {
        try
        {
            printWriter = new PrintWriter(FILE_NAME);
            scanner = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void setAppend()
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(FILE_NAME, true);
            this.printWriter = new PrintWriter(fileWriter);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public PrintWriter getPrintWriter()
    {
        return printWriter;
    }
}
