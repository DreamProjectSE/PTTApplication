package datamodels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CVSReader {

    public CVSReader() {
    }

    public static List<String[]> wholeFile(String fileName){
        List<String[]> lineRead = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine())!=null){
                String[] lines = line.split(",");
                lineRead.add(lines);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return lineRead;
    }

    }