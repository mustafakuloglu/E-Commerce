package com.telpa.ecommerce.fragment.FragmentB;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.activities.ScreenFActivity;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.adapters.RecyclerAdapter_ABCG;
import com.telpa.ecommerce.adapters.RecyclerAdapter_BBig;
import com.telpa.ecommerce.models.Category;
import com.telpa.ecommerce.models.Product;
import com.telpa.ecommerce.utils.TabHelper;

import java.util.ArrayList;

/**
 * Created by SAMSUNGNB on 12.08.2016.
 */
public class FragmentBView extends TabHelper implements IFragmentBView {
    private IFragmentBPresenter fragmentBPresenter;
    private View view;
    private Category category;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentBPresenter = new FragmentBPresenter(this);
        this.view = getView();
        this.category = getCategory();
        setTitle("Test");

        fragmentBPresenter.loadView(this.category);
        fragmentBPresenter.getTopSubCategory(this.view);
        fragmentBPresenter.getSubCategories(this.view);
    }

/*
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b_tab1, container, false);

        return view;
    }
*/
    @Override
    public void viewAll() {
        view.findViewById(R.id.viewallTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ScreenFActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void setTopCategoryTitle(String title) {
        TextView subCategoryTop = (TextView) view.findViewById(R.id.subcategories);
        subCategoryTop.setText(title);
    }

    @Override
    public void setTopCategoryProducts(ArrayList<Product> products) {


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager recyclerLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        recyclerView.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(2));
        RecyclerAdapter_BBig recyclerAdapter = new RecyclerAdapter_BBig(getActivity(), products.size(), R.layout.item_b_big, products);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void setOtherSubCategories(ArrayList<Category> subCategories) {
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        StaggeredGridLayoutManager recyclerLayoutManager2 = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(recyclerLayoutManager2);
        recyclerView2.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(0));
        RecyclerAdapter_ABCG recyclerAdapter2 = new RecyclerAdapter_ABCG(getActivity(), subCategories.size(), R.layout.item_abcg, subCategories, "b");
        recyclerView2.setAdapter(recyclerAdapter2);
    }

    @Override
    public void goToProduct(int ProductID) {

    }

    @Override
    public void addFavorites(int ProductID) {

    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(), "Connection failed!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), "Başarılı", Toast.LENGTH_SHORT).show();
    }
}