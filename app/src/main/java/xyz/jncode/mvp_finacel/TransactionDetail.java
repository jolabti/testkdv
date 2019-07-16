package xyz.jncode.mvp_finacel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

public class TransactionDetail extends AppCompatActivity {

    AppCompatButton btnOkTransactionDetail;
    AppCompatImageView iconClonseTransactionDetail;


    AppCompatTextView tvAmountProductBought, tvAmountTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);


        Bundle extras = getIntent().getExtras();

        tvAmountProductBought = findViewById(R.id.amount_product_bought_id);
        tvAmountTotal = findViewById(R.id.amount_total_id);


        btnOkTransactionDetail = findViewById(R.id.button_ok_payment_detail_id);
        iconClonseTransactionDetail = findViewById(R.id.close_payment_detail_id);


        tvAmountProductBought.setText(extras.getString("amount_total"));
        tvAmountTotal.setText(extras.getString("amount_total"));

        btnOkTransactionDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoHome = new Intent(TransactionDetail.this, MainActivity.class);
                startActivity(gotoHome);

                Toast.makeText(getApplicationContext(), "Transaction Succeed", Toast.LENGTH_LONG).show();

            }
        });

        iconClonseTransactionDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
