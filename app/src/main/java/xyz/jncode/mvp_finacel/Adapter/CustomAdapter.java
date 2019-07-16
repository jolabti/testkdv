package xyz.jncode.mvp_finacel.Adapter;
//https://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.jncode.mvp_finacel.Function;
import xyz.jncode.mvp_finacel.LoanConfirmation;
import xyz.jncode.mvp_finacel.R;
import xyz.jncode.mvp_finacel.TransactionDetail;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Integer> myproducts;
    private Context context;
    private String numberPhone;


    public CustomAdapter(Context context, ArrayList<Integer> myproducts, String numberPhone) {

        this.myproducts = myproducts;
        this.context = context;
        this.numberPhone = numberPhone;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        //View view = layoutInflater.inflate(R.layout.item_photos, parent, false);
        View view = layoutInflater.inflate(R.layout.item_products, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder customViewHolder, final int i) {

            customViewHolder.btnNominal.setText("Rp "+Function.rulesPricing(String.valueOf(myproducts.get(i))));
            customViewHolder.btnNominal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToLoan = new Intent(context, LoanConfirmation.class);
                    goToLoan.putExtra("product_bought_value", myproducts.get(i));
                    goToLoan.putExtra("product_phone_number", numberPhone);
                    context.startActivity(goToLoan);
                }
            });



            customViewHolder.tvNominal.setText(Function.rulesPricing(String.valueOf(myproducts.get(i))));
    }

    @Override
    public int getItemCount() {
        return myproducts.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {


        AppCompatTextView tvNominal;
        AppCompatButton btnNominal;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNominal = itemView.findViewById(R.id.products_nominal_id);
            btnNominal = itemView.findViewById(R.id.products_button_id);


        }
    }


}
