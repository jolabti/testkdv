package xyz.jncode.mvp_finacel;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.ArrayList;

import xyz.jncode.mvp_finacel.Adapter.CustomAdapter;
import xyz.jncode.mvp_finacel.Adapter.PromosAdapter;
import xyz.jncode.mvp_finacel.Adapter.TabAdapter;
import xyz.jncode.mvp_finacel.Fragments.FragmentDataPackage;
import xyz.jncode.mvp_finacel.Fragments.FragmentPulsa;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> productPulsa;
    ArrayList<Integer> productPromotions;

    PromosAdapter promosAdapter;

    RecyclerView rvPromotion;

    AppCompatEditText editTextPhoneNumber;

    private TabAdapter tabadapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPromotion = findViewById(R.id.rv_promos);

        productPromotions = new ArrayList<>();
        productPromotions.clear();

        productPromotions.add(R.drawable.bann_2);
        productPromotions.add(R.drawable.bann_3);
        productPromotions.add(R.drawable.bann_5);
        productPromotions.add(R.drawable.bann_6);

        editTextPhoneNumber = findViewById(R.id.number_phone_input_id);


        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);


        viewPager.setVisibility(View.GONE);


        editTextPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>=4){
                    viewPager.setVisibility(View.VISIBLE);
                }

                if(s.length()<4){
                    viewPager.setVisibility(View.GONE);
                }

                if(s.length()>=22){
                    editTextPhoneNumber.setError("Format nomor telepon tidak valid !");
                }

            }
        });


        productPulsa = new ArrayList<>();

        productPulsa.clear();

        tabadapter = new TabAdapter(getSupportFragmentManager());
        tabadapter.addFragment(new FragmentPulsa(), getResources().getString(R.string.tab_view_pulsa), editTextPhoneNumber.getText().toString());
        tabadapter.addFragment(new FragmentDataPackage(), getResources().getString(R.string.tab_view_data_package), editTextPhoneNumber.getText().toString());

        viewPager.setAdapter(tabadapter);
        tabLayout.setupWithViewPager(viewPager);


        generatePromo(productPromotions);


    }



    void generatePromo(ArrayList<Integer> mycollectionPromo) {
        promosAdapter = new PromosAdapter(this, mycollectionPromo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        rvPromotion.setLayoutManager(layoutManager);
        rvPromotion.setAdapter(promosAdapter);

    }
}
