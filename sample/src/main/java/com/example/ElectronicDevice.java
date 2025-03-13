package com.example;

public abstract class ElectronicDevice implements Connectable{
    protected String name;
    protected Boolean status;

    @Override
    public Boolean connectToWiFi(){
        return true;
    };
}
