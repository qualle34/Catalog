package com.senla.csvhelper;

import java.io.*;

class CsvWriterReader {

    private String filename;

    CsvWriterReader(String filename) {
        this.filename = filename;
    }

    void write(String line) {

        FileWriter writer = null;
        BufferedWriter bw = null;
        File file = new File(filename);

        try {
            file.createNewFile();
            writer = new FileWriter(file, true);
            bw = new BufferedWriter(writer);
            bw.write(line + "\n");

        } catch (IOException e) {
            System.out.println("Error");

        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (writer != null)
                    writer.close();

            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    String read(int row) {

        File file = new File(filename);
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
            System.out.println("Error");

        } finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException e) {
                System.out.println("Error");
            }
        }
        return null;
    }
}