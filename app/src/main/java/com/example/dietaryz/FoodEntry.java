package com.example.dietaryz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.example.dietaryz.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

// to update to git,1. first press on comit,

public class FoodEntry extends AppCompatActivity {

    private EditText txtfoodname,txtfoodgroup,txttime,txtdate,txtmealtype,txtnote,txtnameofrepoter;
    private AppCompatButton btnadd, btncancel;
    private ImageView imgthumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_entry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );
        initialize();
        actionInitializer();
    }

    private void initialize(){
        txtfoodname = (EditText) findViewById(R.id.txtfoodname);
        txtfoodgroup = (EditText) findViewById(R.id.txtfoodgroup);
        txttime = (EditText) findViewById(R.id.txttime);
        txtdate = (EditText) findViewById(R.id.txtdate);
        txtmealtype = (EditText) findViewById(R.id.txtmealtype);
        txtnote = (EditText) findViewById(R.id.txtnote);
        txtnameofrepoter = (EditText) findViewById(R.id.txtnameofrepoter);
        btnadd = (AppCompatButton) findViewById(R.id.btnadd);
        btncancel = (AppCompatButton) findViewById(R.id.btncancel);
        imgthumb = (ImageView) findViewById(R.id.imgthumb);
    }

    private void actionInitializer(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isValid()){
                    Intent state = new Intent(getBaseContext(), MainActivity.class );
                    state.putExtra(Constants.FOODNAME , txtfoodname.getText().toString().trim() );
                    state.putExtra( Constants.FOODGROUP, txtfoodgroup.getText().toString().trim() );
                    state.putExtra( Constants.TIME, txttime.getText().toString().trim() );
                    state.putExtra( Constants.DATE, txtdate.getText().toString().trim() );
                    state.putExtra( Constants.MEALTYPE, txtmealtype.getText().toString().trim() );
                    state.putExtra(Constants.NOTE, txtnote.getText().toString().trim() );
                    state.putExtra(Constants.NAMEOFREPOTER, txtnameofrepoter.getText().toString().trim() );

                    setResult( RESULT_OK, state );
                    finish();
                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean isValid(){

        if( txtfoodname.getText().toString().trim().isEmpty() || txtfoodname.getText() == null ){
            Snackbar.make( txtfoodname, "Please enter food name", Snackbar.LENGTH_LONG).show();
            txtfoodname.requestFocus();
            return false;
        }

        if( txtfoodgroup.getText().toString().trim().isEmpty() || txtfoodgroup.getText() == null ){
            Snackbar.make( txtfoodgroup, "Please enter Food group", Snackbar.LENGTH_LONG).show();
            txtfoodgroup.requestFocus();
            return false;
        }

        if( txttime.getText().toString().trim().isEmpty() || txttime.getText() == null ){
            Snackbar.make( txttime, "Please enter time", Snackbar.LENGTH_LONG).show();
            txttime.requestFocus();
            return false;
        }

        if( txtdate.getText().toString().trim().isEmpty() || txtdate.getText() == null ){
            Snackbar.make( txtdate, "Please enter date", Snackbar.LENGTH_LONG).show();
            txtdate.requestFocus();
            return false;
        }
        if( txtnameofrepoter.getText().toString().trim().isEmpty() || txtnameofrepoter.getText() == null ){
            Snackbar.make( txtnameofrepoter, "Please enter name of repoter", Snackbar.LENGTH_LONG).show();
            txtnameofrepoter.requestFocus();
            return false;
        }

        return true;
    }

}
