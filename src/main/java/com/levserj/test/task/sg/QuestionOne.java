package com.levserj.test.task.sg;


import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serhii Levchynskyi on 14.07.2016.
 *
 * To find a number without a pair in the array,
 * we need to sort this array and compare
 * every two elements, pair after pair, with each other -
 * the unequal one is the one we are searching for.
 *
 * To write this array to YAML file this code uses
 * external library yamlbeans-1.0.jar
 */
public class QuestionOne {
    public static void main(String[] args) {
        QuestionOne questionOne = new QuestionOne();
        questionOne.go();
    }

    public void go() {
        List<Integer> randomInts = createListOfRandomPairedInts();
        for (Integer i : randomInts){
            System.out.println(i);
        }
        System.out.println("---");

        /* We remove one of the numbers to have one unpaired in the list */
        int randomIndex = (int) (Math.random() * 10);
        randomInts.remove(randomIndex);
        for (Integer i : randomInts){
            System.out.println(i);
        }
        writeListToYamlFile(randomInts);
        System.out.println("Number without a pair = " +
                searchListOfIntsForIntWithoutPair(randomInts));
    }

    public List<Integer> createListOfRandomPairedInts() {
        List<Integer> result = new ArrayList<>();
        do {
            int x = (int) (Math.random() * 10);
            if (!result.contains(x)) {
                result.add(x);
                result.add(x);
            }
        } while (result.size() != 10);
        Collections.sort(result);
        return result;
    }

    public void writeListToYamlFile(List<Integer> list) {
        try {
            YamlWriter writer = new YamlWriter(new FileWriter("D:/listOfInts.yml"));
            writer.write(list);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* The list must be sorted, so that equal elements were next to each other */
    public Integer searchListOfIntsForIntWithoutPair(List<Integer> list) {
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals(list.get(i+1))){
                i++;
            } else {
                return list.get(i);
            }
        }
        return null;
    }
}
