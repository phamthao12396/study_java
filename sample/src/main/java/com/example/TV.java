package com.example;

public class TV extends ElectronicDevice implements Connectable{
    public TV(){};
    public TV(String imei, String status){
        this.name = imei;
        this.status = status;
    }

    @Override
    public Boolean connectToWiFi(){
        return true;
    }
}
