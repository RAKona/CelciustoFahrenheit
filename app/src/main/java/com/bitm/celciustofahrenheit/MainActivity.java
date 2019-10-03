package com.bitm.celciustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valueET;
    private Button convertBtn;
    private TextView resultTV;
    private ImageView itscoolIV, itshotIV, itstoohotIV;
    private String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        valueET = findViewById(R.id.valueET);
        convertBtn = findViewById(R.id.convertBtn);
        resultTV = findViewById(R.id.resultTV);
        itscoolIV = findViewById(R.id.itscoldIV);
        itshotIV = findViewById(R.id.itshotIV);
        itstoohotIV = findViewById(R.id.itstoohotIV);


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amount = valueET.getText().toString();

                if (amount.equals("")) {

                    Toast.makeText(MainActivity.this, "input amount", Toast.LENGTH_LONG).show();
                } else {
                    double totalAmount = Double.valueOf(amount);
                    double result = (totalAmount - 32) * 9/5  ;

                    if (result <= 25) {

                        itscoolIV.setVisibility(View.VISIBLE);
                        itshotIV.setVisibility(View.GONE);
                        itstoohotIV.setVisibility(View.GONE);

                    } else if (result > 25 && result <= 40) {

                        itshotIV.setVisibility(View.VISIBLE);
                        itscoolIV.setVisibility(View.GONE);
                        itstoohotIV.setVisibility(View.GONE);

                    } else {

                        itstoohotIV.setVisibility(View.VISIBLE);
                        itscoolIV.setVisibility(View.GONE);
                        itshotIV.setVisibility(View.GONE);
                    }
                    resultTV.setText(String.valueOf(result));
                }


            }
        });
    }
}
