package com.telpa.ecommerce.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.utils.BaseActivity;

public class ScreenLActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_l);


        fcreateTitle("Product" );
        fcreateToolbar(this,false,false,false,R.id.toolbar);
        fcreateMenu(this, true);




    }
}
