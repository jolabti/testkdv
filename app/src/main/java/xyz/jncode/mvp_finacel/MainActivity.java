package xyz.jncode.mvp_finacel;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import xyz.jncode.mvp_finacel.Adapter.CustomAdapter;
import xyz.jncode.mvp_finacel.Adapter.TabAdapter;
import xyz.jncode.mvp_finacel.Fragments.FragmentDataPackage;
import xyz.jncode.mvp_finacel.Fragments.FragmentPulsa;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> productPulsa;

    CustomAdapter customAdapter;

    RecyclerView rvComponent;

    private TabAdapter tabadapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);

        rvComponent = findViewById(R.id.rv_products);
        productPulsa = new ArrayList<>();

        productPulsa.clear();

        tabadapter = new TabAdapter(getSupportFragmentManager());
        tabadapter.addFragment(new FragmentPulsa(), "Pulsa");
        tabadapter.addFragment(new FragmentDataPackage(), "Data Package");
        viewPager.setAdapter(tabadapter);
        tabLayout.setupWithViewPager(viewPager);

//        for (int a = 1; a <= 8; a++) {
//
//            if(a%2==0 && a >0){
//                result = a * 25000;
//                productPulsa.add(result);
//            }
//        }
//
//        generateList(productPulsa);


    }

//    void generateList(ArrayList<Integer> mycollectionProduct) {
//        customAdapter = new CustomAdapter(this, mycollectionProduct);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL, false);
//
//        rvComponent.setLayoutManager(layoutManager);
//        rvComponent.setAdapter(customAdapter);
//
//    }
}
