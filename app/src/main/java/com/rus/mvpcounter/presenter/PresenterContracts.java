package com.rus.mvpcounter.presenter;

public class PresenterContracts {

    public interface CounterView {
        void updateCounter(int counter);

        void isFiveToast();

        void isTenColor();

    }

    public interface CounterPresenter {
        void toast();

        void colorChange();

        void increment();

        void decrement();

        void attachView(CounterView view);
    }
}
