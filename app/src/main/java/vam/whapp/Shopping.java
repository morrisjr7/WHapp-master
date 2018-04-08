package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by victoria on 3/27/18.
 */

public class Shopping extends Activity{

    private
    ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    ListView listView;
    String temp;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.shopping);


            listView = (ListView) findViewById(R.id.ShopList);
            arrayList = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(this, R.layout.shop_list, R.id.shopTxt, arrayList);

            listView.setAdapter(adapter);

            Intent intent = getIntent();
            if(intent.hasExtra("Item")) {
                temp = getIntent().getStringExtra("Item");
                arrayList.add(temp);
                adapter.notifyDataSetChanged();
            }


            Button btn_add_shop = (Button)findViewById(R.id.bAddShop);
            btn_add_shop.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent i = new Intent(Shopping.this, AddShop.class);
                    startActivity(i);

                }
            });

            Button btn_return_shop = (Button)findViewById(R.id.bReturnShop);
            btn_return_shop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Shopping.this, home.class);
                    startActivity(i);
                }
            });
        }

}

