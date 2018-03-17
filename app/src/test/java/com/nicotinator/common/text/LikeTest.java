package com.nicotinator.common.text;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LikeTest {

    @Test
    public void containsShouldAddLikeCriteriaToStartAndEndOfTerm() {

        String term = "something";
        String expected = "%something%";

        String containsTerm = Like.contains(term);

        assertThat(containsTerm, is(expected));
    }

    @Test(expected = NullPointerException.class)
    public void containsShouldThrowErrorIfTermIsNull() {

        Like.contains(null);
    }
}