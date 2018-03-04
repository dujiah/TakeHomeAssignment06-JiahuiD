package com.example.du.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_AMOUNT = "amount";
    public static final String TAG_TAX = "tax";
    public static final String TAG_TIP = "tip";
    public static final String TAG_GRAND = "grandTotal";

    private EditText amountText;
    private EditText taxText;
    private EditText tipText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountText = (EditText) findViewById(R.id.text_amount);
        taxText = (EditText) findViewById(R.id.tax_percentage);
        tipText = (EditText) findViewById(R.id.tip_percentage);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSecondActivity(Double.parseDouble(amountText.getText().toString()), Double.parseDouble(taxText.getText().toString()), Double.parseDouble(tipText.getText().toString()));
            }
        });
    }

    private void launchSecondActivity(double amountText, double taxText, double tipText) {
        double saleTax = taxText * amountText;
        double yourTip = tipText * amountText;
        double grandTotal = amountText + (taxText + tipText) * amountText;

        Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
        secondActivity.putExtra(TAG_AMOUNT, amountText);
        secondActivity.putExtra(TAG_TAX, saleTax);
        secondActivity.putExtra(TAG_TIP, yourTip);
        secondActivity.putExtra(TAG_GRAND, grandTotal);


        startActivity(secondActivity);

    }
}
