package com.example.colorchanger;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.graphics.Color;

import java.util.Random;


public class MyViewModel extends ViewModel {


    int color;


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
