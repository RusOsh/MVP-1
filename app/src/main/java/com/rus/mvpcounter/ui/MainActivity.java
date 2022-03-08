package com.rus.mvpcounter.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rus.mvpcounter.R;
import com.rus.mvpcounter.data.Injector;
import com.rus.mvpcounter.databinding.ActivityMainBinding; 
import com.rus.mvpcounter.presenter.CounterPresenter;
import com.rus.mvpcounter.presenter.PresenterContracts;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PresenterContracts.CounterView {
    private ActivityMainBinding binding;
    private CounterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = Injector.getPresenter();
        presenter.attachView(this);
        initListeners();
    }

    private void initListeners() {
        binding.btnPlus.setOnClickListener(view -> {
            presenter.increment();
            presenter.toast();
            presenter.colorChange();
        });
        binding.btnMinus.setOnClickListener(view -> {
            presenter.decrement();
            presenter.toast();
            presenter.colorChange();
        });
    }


    @Override
    public void updateCounter(int counter) {
        binding.tvCount.setText(String.valueOf(counter));
    }

    @Override
    public void isFiveToast() {
        Toast.makeText(this, "Ураа", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isTenColor() {
        binding.tvCount.setTextColor(this.getResources().getColor(R.color.green, getTheme()));
    }
}