package com.example.androidantivirus;

import android.widget.EditText;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    Double x;
    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.x = x;
    }

    @Override
    public Double cal(String type, String number) {
        if(type.equals("+")){
            Double numberDouble = Double.parseDouble(number);
            x = x + numberDouble;
            //idEditText.setText("");
        }
        return x;
    }


}
