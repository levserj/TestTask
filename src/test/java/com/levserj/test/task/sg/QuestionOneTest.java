package com.levserj.test.task.sg;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Serhii Levchynskyi on 11.10.2016.
 */
public class QuestionOneTest {

    private QuestionOne questionOne;
    private int unpairedInt;
    private List<Integer> sortedListOfPairedIntsOneOfThemWithoutPair;

    @Before
    public  void setUp(){
        questionOne = new QuestionOne();
        List<Integer> result = new ArrayList<>();
        do {
            int x = (int) (Math.random() * 10);
            if (!result.contains(x)) {
                result.add(x);
                result.add(x);
            }
        } while (result.size() != 10);
        int randomIndex = (int) (Math.random() * 10);
        unpairedInt = result.get(randomIndex);
        sortedListOfPairedIntsOneOfThemWithoutPair = result;
        sortedListOfPairedIntsOneOfThemWithoutPair.remove(randomIndex);
    }

    @Test
    public void checkThatSearchListOfIntsForIntWithoutPairMethodReturnsCorrectInt(){
        assertThat(questionOne
                .searchListOfIntsForIntWithoutPair(sortedListOfPairedIntsOneOfThemWithoutPair),
                is(unpairedInt));
    }
}
