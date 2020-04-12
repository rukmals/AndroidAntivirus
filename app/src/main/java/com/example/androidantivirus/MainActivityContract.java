package com.example.androidantivirus;

import android.widget.EditText;

public interface MainActivityContract {

    interface View{
        void Error(String msg);
        void ShowResult(Double x);
    }
    interface Presenter{
        Double cal(String type, String number);
    }


}
