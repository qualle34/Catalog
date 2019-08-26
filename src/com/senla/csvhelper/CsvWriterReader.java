package com.senla.csvhelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

class CsvWriterReader {

    private String directory;
    private String filename;

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
                e.printStackTrace();
            }
            write(header, "");
        }

        try(FileWriter writer = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(line + "\n");

        } catch (IOException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return objects;
    }
}