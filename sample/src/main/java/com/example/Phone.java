package com.example;

public class Phone extends ElectronicDevice implements Connectable{

    public Boolean connectToWiFi(){
        return false;
    }
}
