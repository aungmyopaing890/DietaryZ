package com.example.dietaryz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dietaryz.utils.Constants;

public class FoodDisplay extends AppCompatActivity {

    private TextView txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );

        txtphone = (TextView) findViewById(R.id.txtphone);

        Bundle bundle = getIntent( ).getExtras( );
        if( bundle!= null && bundle.getString(Constants.FOODNAME) != null ){
            ((TextView)findViewById(R.id.txtfoodname)).setText( bundle.getString(Constants.FOODNAME) );
            ((TextView)findViewById(R.id.txtfoodgroup)).setText( bundle.getString(Constants.FOODGROUP) );
            ((TextView)findViewById(R.id.txtdate)).setText( bundle.getString(Constants.DATE) );
            ((TextView)findViewById(R.id.txttime)).setText( bundle.getString(Constants.TIME) );
            ((TextView)findViewById(R.id.txtmealtype)).setText( bundle.getString(Constants.MEALTYPE) );
            ((TextView)findViewById(R.id.txtnote)).setText( bundle.getString(Constants.NOTE) );
            ((TextView)findViewById(R.id.txtnameofrepoter)).setText( bundle.getString(Constants.NAMEOFREPOTER) );
        }
    }

}
