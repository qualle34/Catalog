package com.senla.csvhelper;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

class CsvWriterReader {

    private static Logger LOGGER;

    private String directory;
    private String filename;

    static {
        try (FileInputStream ins = new FileInputStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(CsvWriterReader.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    CsvWriterReader(String directory, String filename) {
        this.directory = directory;
        this.filename = filename;
    }

    void write(String line, String header) {
        File dir = new File(directory);
        File file = new File(directory, filename);

        if (!dir.exists()) {
            dir.mkdir();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Create file error: " + e.getMessage());
            }
            write(header, "");
        }

        try (FileWriter writer = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(line + "\n");

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Writing into file error: " + e.getMessage());
        }
    }

    Map<Integer, String> read() {
        Map<Integer, String> objects = new HashMap<>();
        File file = new File(directory, filename);
        int i = 1;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                objects.put(i, line);
                i++;
            }

        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Reading from file error: " + e.getMessage());
        }
        return objects;
    }
}