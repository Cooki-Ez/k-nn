package com.company;

import java.util.*;

public class Tester {
    static List<Iris> toTrain;
    double correct = 0;
    double all = 0;
    int k;

    public Tester(List<Iris> trainExample, List<Iris> testExample, int k) {
        toTrain = trainExample;
        this.k = k;
        test(testExample);
    }

    public void test(List<Iris> from) {
        for (Iris iris : from) {
            Map<String, Double> map = fromOneToAll(iris, toTrain);
            afterTest(iris, map);
        }
        System.out.println("Accuracy: " + Math.round((correct / all) * 100) + "%");
    }

    public Map<String, Double> fromOneToAll(Iris from, List<Iris> to) {     //find distance from 1 test iris to all others
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < to.size(); i++)
            map.put(toTrain.get(i).getName() + " " + i, getDist(from, toTrain.get(i))); //put in map name of iris and distance to it
        map = sortByValue(map, k);  //sort map by keyValue (distance) and take k first elements
        return map;
    }

    public void afterTest(Iris from, Map<String, Double> map) {
        List<String> names = new ArrayList<>(map.keySet());
        for (int j = 0; j < names.size(); j++) {
            String[] tmp = names.get(j).split(" ");
            names.set(j, tmp[0]);
        }
        Map<String, Integer> map1 = countByClassicalLoop(names); //count how many irises in a map with same name
        String res = answerForMaps(map1, map);  //get name of iris with minimum distance to test iris
        answer(res, from.getName());    //print found and real value of iris
        if (res.equals(from.getName())) correct++;  //represents how many right iris were found
        all++; //represents quantity of irises
    }

    public String answerForMaps(Map<String, Integer> nameAndNumber, Map<String, Double> nameAndDistance) {
        int key = Collections.max(nameAndNumber.entrySet(), Map.Entry.comparingByValue()).getValue(); //find key that is biggest in the map (most occurancies of iris)
        List<String> elements = new ArrayList<>();
        for (var a : nameAndNumber.keySet())
            if (nameAndNumber.get(a) == key) elements.add(a); //if key in map equals to max key add it to arraylist
        Map<String, Double> result = new HashMap<>();
        for (String element : elements) {
            for (String a : nameAndDistance.keySet()) {
                if (element.equals(a.replaceAll("\\s.*", ""))) {
                    if (result.containsKey(a.replaceAll("\\s.*", "")))
                        result.put(a.replaceAll("\\s.*", ""), nameAndDistance.get(a)
                                + result.get(a.replaceAll("\\s.*", "")));
                    else
                        result.put(a.replaceAll("\\s.*", ""), nameAndDistance.get(a)); //delete all other characters and add distance to existing or insert firstly
                }
            }
        }
        return Collections.min(result.entrySet(), Map.Entry.comparingByValue()).getKey(); //return min distance from map
    }

    public <T> Map<T, Integer> countByClassicalLoop(List<T> inputList) {
        Map<T, Integer> resultMap = new HashMap<>();
        for (T element : inputList) {
            if (resultMap.containsKey(element))
                resultMap.put(element, resultMap.get(element) + 1);
            else
                resultMap.put(element, 1);
        }
        return resultMap;
    }

    public static double getDist(Iris from, Iris to) {
        double result = 0;
        for (int i = 0; i < from.ys.size(); i++)
            result += Math.pow(to.ys.get(i) - from.ys.get(i), 2);
        return Math.sqrt(result);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, int k) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap<>();
        int i = 0;
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
            i++;
            if (i == k) break;
        }
        return result;
    }

    void answer(String res, String realIrisName) {
        System.out.println("Found - " + res + ". Real - " + realIrisName);
    }
}
