package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile;
        try( BufferedReader br
                     = new BufferedReader(new java.io.FileReader(file.getPath()))) {
            String name = String.valueOf(br.readLine()).split(": ")[1];
            String age = String.valueOf(br.readLine()).split(": ")[1];
            String email = String.valueOf(br.readLine()).split(": ")[1];
            String phoneNum = String.valueOf(br.readLine()).split(": ")[1];
            profile = new Profile(name, Integer.parseInt(age), email, Long.parseLong(phoneNum));
            return profile;
        } catch (IOException e) {
            Logger logger = Logger.getLogger(FileReader.class.getName());
            logger.log(Level.WARNING, e.getMessage());
        }
        return new Profile();
    }
}
