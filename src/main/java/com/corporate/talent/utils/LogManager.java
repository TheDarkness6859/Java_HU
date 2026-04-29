package com.corporate.talent.utils;

import javax.xml.xpath.XPath;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogManager {

    private final static String path = "app.logs";

    private LogManager () {}

    public static synchronized void addLog (String status, String description){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path , true))){

            String time = LocalDateTime.now().toString();

            bw.write("[" + time + "] [" + status + "]" + description);
            bw.newLine();

        }catch (IOException err){

            System.err.println("Sorry cannot write logs" + err.getMessage());

        }

    }

}
