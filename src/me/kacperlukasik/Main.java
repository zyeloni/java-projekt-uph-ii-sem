package me.kacperlukasik;

import me.kacperlukasik.models.repository.PublishingRepository;

import java.util.UUID;

public class Main {

    public static void main(String[] args)
    {
        for(int i = 0; i <5;i++)
            System.out.println(UUID.randomUUID().toString());
    }
}
