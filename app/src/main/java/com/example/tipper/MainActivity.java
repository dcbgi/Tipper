package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double percentage = 0.0;
    double billTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView output = findViewById(R.id.Answer);
        final TextView bill = findViewById(R.id.EnterBill);
        final TextView newperce =  findViewById(R.id.OtherPerc);

        Button T10 = findViewById(R.id.Ten);
        Button F15 = findViewById(R.id.Fifteen);
        Button E18 =  findViewById(R.id.Eighteen);
        Button TF25 =  findViewById(R.id.TwentyFive);
        Button O = findViewById(R.id.Other);

        T10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = .10;
                getbill(bill);
                print(output);
            }
        });
        F15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = .15;
                getbill(bill);
                print(output);
            }
        });
        E18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = .18;
                getbill(bill);
                print(output);
            }
        });
        TF25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percentage = .25;
                getbill(bill);
                print(output);
            }
        });
        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getbill(bill);
                newperce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        percentage = Double.parseDouble( newperce.getText().toString());
                        percentage /= 100;
                        print(output);
                    }
                });

            }

        });

    }
        protected void getbill(TextView bill){
            billTotal = Double.parseDouble( bill.getText().toString());
        }
       protected void print(TextView output){
           double result = billTotal*percentage;
           output.setText("$" + String.valueOf(result));
       }

}
