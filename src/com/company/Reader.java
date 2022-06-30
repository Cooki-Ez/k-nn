package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    List<Iris> trainingFile;
    List<Iris> testFile;
    int k;

    public Reader(String trainingExample, String testExample) {
        trainingFile = readFromFile(trainingExample);
        testFile = readFromFile(testExample);
        k = Main.k;
        new Tester(trainingFile, testFile, k);
    }

    public Reader(String trainingExample, String testExample, String line) {
        trainingFile = readFromFile(trainingExample);
        testFile = readFromFile(testExample);
        List<Iris> tmp = new ArrayList<>();
        tmp.add(readFromLine(line));
        new Tester(trainingFile, tmp, k);
    }

    public Iris readFromLine(String line) {
        String[] ln = line.replaceAll("\"", "").split(",");
        List<Double> ys = new ArrayList<>();
        for (int i = 0; i < ln.length - 1; i++)
            ys.add(Double.parseDouble(ln[i]));
        return new Iris(ln[ln.length - 1].replaceFirst("Iris-", ""), ys);
    }

    public List<Iris> readFromFile(String trainingExample) {
        List<Iris> tmp = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream((trainingExample))));
            String line;
            while ((line = br.readLine()) != null)
                tmp.add(readFromLine(line));
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }
}
