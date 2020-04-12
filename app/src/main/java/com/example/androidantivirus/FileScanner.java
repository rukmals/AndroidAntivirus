
package com.example.androidantivirus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class FileScanner extends AppCompatActivity implements MainActivityContract.View{
    Double x = 0.0;
    EditText idEditText;
    int clicked_btn = 0;
    String type;
    MainActivityContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_scanner);

        TextView text = (TextView) findViewById(R.id.textView);
        idEditText = (EditText) findViewById(R.id.numbers);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button devide = (Button) findViewById(R.id.devide);
        Button equal = (Button) findViewById(R.id.equal);

        presenter = new MainActivityPresenter(this);
        equal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (clicked_btn==1){
                    if(TextUtils.isEmpty(idEditText.getText().toString())){
                        Double value =  Double.parseDouble(idEditText.getText().toString());
                        x += value;
                        idEditText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                    else{
                        idEditText.setText(String.valueOf(x));
                        x=0.0;
                    }

                }

            }

        });
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!TextUtils.isEmpty(idEditText.getText().toString())) {
                        cal("+", idEditText.getText().toString());
                } else {
                    Error("NO EMPTY TXET ALLOWED");
                }
            }
        });
    }
    public void cal(String type,String number){
        // Toast.makeText(this,number,Toast.LENGTH_SHORT).show();
        if(type.equals("+")){
            clicked_btn=1;
            Double numberDouble = Double.parseDouble(number);
            x = x + numberDouble;
            ShowResult(x);
            idEditText.setText("");
        }
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(FileScanner.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowResult(Double x) {
        Toast.makeText(FileScanner.this,String.valueOf(x), Toast.LENGTH_SHORT).show();
    }
}

