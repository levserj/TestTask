package com.levserj.test.task.sg;

import com.esotericsoftware.yamlbeans.YamlWriter;

import java.io.FileWriter;
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

    /**
     * Returns integer without a pair from the list,
     * or null, if no such found.
     */
    public Integer searchListOfIntsForIntWithoutPair(List<Integer> list) {
        // The list must be sorted, so that equal elements were next to each other
        Collections.sort(list);
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals(list.get(i+1))){
                i++;
            } else {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Writes list to the YAML file, specified with pathToFile string.
     */
    public void writeListToYamlFile(List<Integer> list, String pathToFile) {
        try {
            YamlWriter writer = new YamlWriter(new FileWriter(pathToFile));
            writer.write(list);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
