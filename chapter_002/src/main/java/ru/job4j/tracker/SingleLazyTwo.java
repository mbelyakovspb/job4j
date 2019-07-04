package ru.job4j.tracker;

public class SingleLazyTwo {

    private SingleLazyTwo() {
    }

    public static SingleLazyTwo getInstance() {
        return Holder.SINGLE_LAZY_TWO;
    }

    private static final class Holder {
        private static final SingleLazyTwo SINGLE_LAZY_TWO = new SingleLazyTwo();
    }
}
