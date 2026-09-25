package com.example.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties{
    public Config() {
        try {
            InputStream is = new FileInputStream("config.properties");
            load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
