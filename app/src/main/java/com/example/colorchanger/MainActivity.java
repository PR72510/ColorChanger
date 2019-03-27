package com.example.colorchanger;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.colorchanger.databinding.ActivityMainBinding;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ConstraintLayout mConstraint;
    MyViewModel model;
    MyClickHandlers handlers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setClick(this);
        mConstraint = binding.constraint;
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createColor(v);
            }
        });

        model= ViewModelProviders.of(this).get(MyViewModel.class);
        mConstraint.setBackgroundColor(model.color);
        handlers = new MyClickHandlers(this);
        binding.setHandlers(handlers);

    }

    public void createColor(View view){
        Random random = new Random();
        int randomColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        model.color=randomColor;
        mConstraint.setBackgroundColor(model.color);
    }
}
