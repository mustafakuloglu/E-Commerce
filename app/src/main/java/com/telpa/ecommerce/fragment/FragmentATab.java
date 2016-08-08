package com.telpa.ecommerce.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.activities.ScreenAActivity;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.adapters.RecyclerAdapter_ABGSmall;
import com.telpa.ecommerce.interfaces.IBasket;
import com.telpa.ecommerce.interfaces.ICategory;
import com.telpa.ecommerce.interfaces.IProduct;
import com.telpa.ecommerce.models.Product;
import com.telpa.ecommerce.utils.TabHelper;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by volkan on 13.07.2016.
 */

public class FragmentATab extends TabHelper {
    @Inject
    IBasket basket;
    @Inject
    IProduct product;
    @Inject
    ICategory category;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private ArrayList<Product> products;

    private ImageButton imgBtn;

    public FragmentATab createTab(String title) {
        FragmentATab tabOne = new FragmentATab();
        tabOne.setTitle(title);
        return tabOne;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //TODO
        products = new ArrayList<Product>();
        ArrayList<String> url = new ArrayList<String>();
        url.add("http://www.batmanda.com/rsm.batmanda/1970335733.jpg");

        Product b = new Product();
        b.setName("");
        b.setID(1);
        b.setCategoryID(1);
        b.setDescripton("");
        b.setHighResImageUrls(url);
        b.setLowResImageUrls(url);
        b.setPrice(30);
        b.setRating(2);
        b.setRating(3);
        products.add(b);


        View rootView = inflater.inflate(R.layout.fragment_a_tab1, container, false);


        imgBtn = (ImageButton) rootView.findViewById(R.id.bigBasketButton);
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Basket Buttton", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerView.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(2));
        recyclerAdapter = new RecyclerAdapter_ABGSmall(getActivity(),products.size(), R.layout.item_a_and_b_small, products);
        recyclerView.setAdapter(recyclerAdapter);
        return rootView;

    }

}
