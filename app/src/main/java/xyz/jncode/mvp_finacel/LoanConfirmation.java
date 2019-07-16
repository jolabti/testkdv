package xyz.jncode.mvp_finacel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

public class LoanConfirmation extends AppCompatActivity {


    AppCompatTextView tvAmountProductBought, tvAmountTotal;
    AppCompatEditText edPin;

    AppCompatButton payButton;

    AppCompatImageView backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_confirmation);

        Bundle extras = getIntent().getExtras();
        final String amount= Function.rulesPricing(String.valueOf(extras.getInt("product_bought_value")));

        Log.d("trace_int", String.valueOf(extras.getInt("product_bought_value")));

        tvAmountProductBought = findViewById(R.id.amount_product_bought_id);
        tvAmountTotal = findViewById(R.id.amount_total_id);
        payButton = findViewById(R.id.pay_button_id);
        edPin = findViewById(R.id.edit_pin_id);
        backButton = findViewById(R.id.close_payment_detail_id);

        tvAmountProductBought.setText(amount);
        tvAmountTotal.setText(amount);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edPin.getText().toString().equals("")|| edPin.getText().length()<1){

                    edPin.setError("Masukkan pin");
                }
                else{

                    Intent goToFinalTransaction = new Intent(LoanConfirmation.this, TransactionDetail.class);
                    goToFinalTransaction.putExtra("amount_total", amount);
                    startActivity(goToFinalTransaction);
                }

            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
