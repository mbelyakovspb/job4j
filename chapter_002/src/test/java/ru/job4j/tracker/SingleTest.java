package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SingleTest {

    @Test
    public void whenSingleEagerThenOneObject() {
        SingleEager singleEager = SingleEager.getInstance();
        SingleEager singleEagerTwo = SingleEager.getInstance();
        assertThat(singleEager, is(singleEagerTwo));
    }

    @Test
    public void whenSingleEnumThenOneObject() {
        SingleEnum singleEnum = SingleEnum.INSTANCE;
        SingleEnum singleEnumTwo = SingleEnum.INSTANCE;
        assertThat(singleEnum, is(singleEnumTwo));
    }

    @Test
    public void whenSingleLazyOneStaticFieldThenOneObject() {
        SingleLazyOne singleLazyOne = SingleLazyOne.getInstance();
        SingleLazyOne singleLazyOne1 = SingleLazyOne.getInstance();
        assertThat(singleLazyOne, is(singleLazyOne1));
    }

    @Test
    public void whenSingleLazyTwoPrivateStaticFinalThenOneObject() {
        SingleLazyTwo singleLazyTwo = SingleLazyTwo.getInstance();
        SingleLazyTwo singleLazyTwo1 = SingleLazyTwo.getInstance();
        assertThat(singleLazyTwo, is(singleLazyTwo1));
    }
}