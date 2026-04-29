package com.corporate.talent.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static AppConfig instance;
    
    private final Properties dbProp = new Properties();

    private AppConfig () {
        
        load("db.properties", dbProp);

    }
    
    private void load (String field, Properties prop){
        
        try(InputStream is = getClass().getClassLoader().getResourceAsStream(field)){
            
            if (is == null) throw new RuntimeException("Don't file found: " + field);
            
            prop.load(is);
            
        }catch (IOException err){

            throw new RuntimeException("Error to connect with" + field , err);
            
        }
        
    }
    
    public static AppConfig getInstance(){

        if (instance == null) {
            
            synchronized (AppConfig.class){
                
                if (instance == null) instance = new AppConfig();
                
            }
            
        }
        
        return instance;
        
    }

    public String getUrl () {

        return dbProp.getProperty("db.url");

    }

    public String getUser () {

        return dbProp.getProperty("db.user");

    }

    public String getPass () {

        return dbProp.getProperty("db.pass");

    }

    public String getDriver () {

        return dbProp.getProperty("db.driver");

    }

}
