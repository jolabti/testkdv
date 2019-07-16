package xyz.jncode.mvp_finacel.Adapter;
//https://www.androidhive.info/2015/09/android-material-design-working-with-tabs/

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.jncode.mvp_finacel.PromoActivity;
import xyz.jncode.mvp_finacel.R;

public class PromosAdapter extends RecyclerView.Adapter<PromosAdapter.CustomViewHolder> {

    private ArrayList<Integer> mypromos;
    private Context context;



    public PromosAdapter(Context context, ArrayList<Integer> mypromos ) {

        this.mypromos = mypromos;
        this.context = context;

    }

    @NonNull
    @Override
    public PromosAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        //View view = layoutInflater.inflate(R.layout.item_photos, parent, false);
        View view = layoutInflater.inflate(R.layout.item_promos, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromosAdapter.CustomViewHolder customViewHolder, int i) {


        customViewHolder.imagePromo.setImageResource(mypromos.get(i));

        customViewHolder.imagePromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoPromo = new Intent(context, PromoActivity.class);
                context.startActivity(gotoPromo);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mypromos.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {


        AppCompatImageView imagePromo;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePromo = itemView.findViewById(R.id.image_promo_id);


        }
    }
}
