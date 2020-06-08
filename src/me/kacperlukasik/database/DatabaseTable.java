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

    protected void reloadDatabase()
    {
        try
        {
            FileWriter fileWriter = new FileWriter(FILE_NAME, true);
            this.printWriter = new PrintWriter(fileWriter);
            scanner = new Scanner(new File(FILE_NAME));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected Scanner getScanner()
    {
        return scanner;
    }

    protected PrintWriter getPrintWriter()
    {
        return printWriter;
    }
}
