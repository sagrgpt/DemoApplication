package com.example.sagar.demoapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    int FRAGMENTID=0;
    Button nextFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OrderFragment orderFragment = new OrderFragment();
        fragmentTransaction.add(R.id.fragmentContainer,orderFragment);
        fragmentTransaction.commit();
        FRAGMENTID=1;
        nextFragment = (Button) findViewById(R.id.nextFragmentButton);
        nextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextFragment(v);
            }
        });
    }

    public void onNextFragment(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (FRAGMENTID){
            case 1: {
                OrderFragment orderFragment = new OrderFragment();
                LocationFragment locationFragment = new LocationFragment();
                Boolean isClear = orderFragment.getClearance(getApplicationContext());
                if(isClear==true){
                    fragmentTransaction.replace(R.id.fragmentContainer,locationFragment);
                    fragmentTransaction.commit();

                }
                else
                    Toast.makeText(getApplicationContext(),"Delivery Time Not Selected!!",Toast.LENGTH_SHORT).show();
                break;
            }
            case 2: {
                OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
                fragmentTransaction.replace(R.id.fragmentContainer,orderDetailsFragment);
                fragmentTransaction.commit();
                break;
            }
        }
    }
}
