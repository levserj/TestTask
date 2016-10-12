package com.levserj.test.task.sg;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Levchynskyi Serhii on 11.10.16.
 */
public class QuestionTwoTest {

    private QuestionTwo questionTwo;

    @Before
    public void setUp(){
        questionTwo = new QuestionTwo();
    }

    @Test
    public void checkMethodFindPalindromeReturnsCorrectInt(){
        assertThat(questionTwo.nextPalindromeFinder(10), is(11));
        assertThat(questionTwo.nextPalindromeFinder(15), is(22));
        assertThat(questionTwo.nextPalindromeFinder(235), is(242));
    }
}
