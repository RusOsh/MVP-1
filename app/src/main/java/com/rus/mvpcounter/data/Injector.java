package com.rus.mvpcounter.data;

import com.rus.mvpcounter.presenter.CounterPresenter;

public class Injector {

    public static CounterPresenter getPresenter() {
        return new CounterPresenter();
    }
}

