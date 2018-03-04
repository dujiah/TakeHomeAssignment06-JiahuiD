package com.example.du.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView amountTextView;
    private TextView tipTextView;
    private TextView taxTextView;
    private TextView grandTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        amountTextView = (TextView) findViewById(R.id.total);
        tipTextView = (TextView) findViewById(R.id.tip);
        taxTextView = (TextView) findViewById(R.id.tax);
        grandTextView = (TextView) findViewById(R.id.grandTotal);

        initializeTextViews();
    }

    private void initializeTextViews() {
        double total = getIntent().getExtras().getDouble(MainActivity.TAG_AMOUNT);
        double tip = getIntent().getExtras().getDouble(MainActivity.TAG_TIP);
        double tax = getIntent().getExtras().getDouble(MainActivity.TAG_TAX);
        double grandTotal = getIntent().getExtras().getDouble(MainActivity.TAG_GRAND);

        String currentAmount = amountTextView.getText().toString();
        currentAmount = currentAmount + total;

        String currentTip = tipTextView.getText().toString();
        currentTip = currentTip + tip;

        String currentTax = taxTextView.getText().toString();
        currentTax = currentTax + tax;

        String currentGrand = grandTextView.getText().toString();
        currentGrand = currentGrand + grandTotal;

        amountTextView.setText(currentAmount);
        tipTextView.setText(currentTip);
        taxTextView.setText(currentTax);
        grandTextView.setText(currentGrand);
    }

}
