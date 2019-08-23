package com.senla.csvhelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

class CsvWriterReader {

    private String directory;
    private String filename;

    CsvWriterReader(String directory, String filename) {
        this.directory = directory;
        this.filename = filename;
    }

    void write(String line) {

        FileWriter writer = null;
        BufferedWriter bw = null;
        File dir = new File(directory);
        File file = new File(directory, filename);

        try {
            if (!dir.exists()){
                dir.mkdir();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file, true);
            bw = new BufferedWriter(writer);
            bw.write(line + "\n");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (writer != null)
                    writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    HashMap<Integer, String> read() {
        HashMap<Integer, String> objects = new HashMap<>();
        int i = 1;

        while (readLine(i) != null) {
            objects.put(i, readLine(i));
            i++;
        }

        return objects;
    }

    private String readLine(int row) {

        File file = new File(directory, filename);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            int lineCounter = 1;

            while ((line = br.readLine()) != null) {

                if (lineCounter == row) {
                    return line;
                }
                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}