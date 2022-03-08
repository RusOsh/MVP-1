package com.rus.mvpcounter.presenter;

import com.rus.mvpcounter.data.CounterModel;

public class CounterPresenter implements PresenterContracts.CounterPresenter {
    private PresenterContracts.CounterView counterView;
    private CounterModel model;

    public CounterPresenter() {
        model = new CounterModel();
    }

    @Override
    public void toast() {
        if (model.getCount() == 5) {
            counterView.isFiveToast();
        }
    }

    @Override
    public void colorChange() {
        if (model.getCount() == 10) {
            counterView.isTenColor();
        }
    }

    @Override
    public void increment() {
        model.increment();
        counterView.updateCounter(model.getCount());
    }

    @Override
    public void decrement() {
        model.decrement();
        counterView.updateCounter(model.getCount());
    }

    @Override
    public void attachView(PresenterContracts.CounterView view) {
        this.counterView = view;
    }
}

