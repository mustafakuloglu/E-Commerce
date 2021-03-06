package com.telpa.ecommerce.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.adapters.RecyclerAdapter_E;
import com.telpa.ecommerce.interfaces.IBasket;
import com.telpa.ecommerce.interfaces.ICategory;
import com.telpa.ecommerce.interfaces.IProduct;
import com.telpa.ecommerce.models.Category;
import com.telpa.ecommerce.utils.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class ScreenEActivity extends BaseActivity {
    @Inject
    IBasket basket;
    @Inject
    IProduct product;
    @Inject
    ICategory category;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private ArrayList<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_e);


        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        categories = new ArrayList<Category>();
        Category a = new Category();
        a.setName("Category");
        a.setHighResImageUrl("http://formatatma.net/wp-content/uploads/2015/07/General-Mobile-Discovery-Air-format-atma.jpg");
        a.setLowResImageUrl("");
        a.setID(1);
        a.setNumOfProduct(2);
        a.setParentID(0);
        categories.add(a);
        categories.add(a);
        categories.add(a);
        categories.add(a);
        categories.add(a);


        fcreateTitle("My Store" + " E");
        fcreateToolbar(this, false, true, true, R.id.toolbar);
        fcreateMenu(this, true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewE);

        recyclerView.setHasFixedSize(true);

        /*
        recyclerLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        */

        recyclerLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerView.addItemDecoration(new RecyclerAdapter_E.SpaceItemDecoration(0));
        recyclerAdapter = new RecyclerAdapter_E(ScreenEActivity.this, categories.size(), R.layout.item_e, categories);
        recyclerView.setAdapter(recyclerAdapter);

    }
}
