package xyz.jncode.mvp_finacel.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.jncode.mvp_finacel.Adapter.CustomAdapter;
import xyz.jncode.mvp_finacel.R;

public class FragmentDataPackage extends Fragment {

    RecyclerView rvComponent, rvPromotion;
    CustomAdapter customAdapter;

    ArrayList<Integer> productPulsa;

    int result;

    public FragmentDataPackage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        productPulsa = new ArrayList<>();
        productPulsa.clear();


        for (int a = 1; a <= 8; a++) {

            if (a % 2 == 0 && a > 0) {
                result = a * 25000;
                productPulsa.add(result);
            }
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pulsa, container, false);

        rvComponent = rootView.findViewById(R.id.rv_products);
        rvPromotion = rootView.findViewById(R.id.rv_promos);

        return rootView;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        generateList(productPulsa);

    }

    void generateList(ArrayList<Integer> mycollectionProduct) {
        customAdapter = new CustomAdapter(getActivity(), mycollectionProduct,"");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rvComponent.setLayoutManager(layoutManager);
        rvComponent.setAdapter(customAdapter);

    }


}
