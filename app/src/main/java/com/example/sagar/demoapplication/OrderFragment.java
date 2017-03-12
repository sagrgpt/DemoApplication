package com.example.sagar.demoapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderFragment extends Fragment {

    private ImageButton decrease,increase;
    static private TextView quantity;
    SharedPreferences sharedpreferences;
    static private RadioButton slot1, slot2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.order_fragment,container,false);

        slot1 = (RadioButton) view.findViewById(R.id.slot1);
        slot2 = (RadioButton) view.findViewById(R.id.slot2);
        quantity = (TextView) view.findViewById(R.id.quantity);
        decrease = (ImageButton) view.findViewById(R.id.decreaseQuantity);
        increase = (ImageButton) view.findViewById(R.id.increaseQuantity);
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(quantity.getText().toString());
                if(x==1)
                    Toast.makeText(view.getContext(),"Invalid Order!!",Toast.LENGTH_SHORT).show();
                else{
                    x = x-1;
                    quantity.setText(String.valueOf(x));
                }
            }
        });
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(quantity.getText().toString());
                if(x==10)
                    Toast.makeText(view.getContext(),"Invalid Order!!",Toast.LENGTH_SHORT).show();
                else{
                    x = x+1;
                    quantity.setText(String.valueOf(x));
                }
            }
        });
        return view;
    }

    public Boolean getClearance(Context ctx){
        sharedpreferences = ctx.getSharedPreferences("OrderPreference", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
//        slot1 = (RadioButton) v.findViewById(R.id.slot1);
//        slot2 = (RadioButton) v.findViewById(R.id.slot2);
        if(slot1.isChecked()){
            String qty = quantity.getText().toString();
            editor.putString("Order",qty);
            editor.putString("DeliverySlot","morning");
            editor.apply();
            return true;
        }
        else if (slot2.isChecked()){
            String qty = quantity.getText().toString();
            editor.putString("Order",qty);
            editor.putString("DeliverySlot","evening");
            editor.apply();
            return true;
        }
        else{
            return false;
        }


    }
}
