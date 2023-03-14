package datamodels;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

    public static void writeToFile(String filename, List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)))) {
            for (String[] line : data) {
                String lineToWrite = String.join(",", line);
                writer.write(lineToWrite);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}