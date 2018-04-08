package vam.whapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoria on 3/27/18.
 */

public class Inventory extends Activity{


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
//    private Dialog MyDialog;
//    Button hello,close;
    ListView listView;
    String item;
    LocalDB db = new LocalDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);

        Log.d("InvTag", "In inventory, congrats");

        listView = (ListView) findViewById(R.id.InvList);
        arrayList = db.getInv();
        adapter = new ArrayAdapter<String>(this, R.layout.inv_list, R.id.itemTxt, arrayList);


        listView.setAdapter(adapter);

/*
        Intent intent = getIntent();

        if(intent.hasExtra("Item")){
            item = getIntent().getStringExtra("Item");
            arrayList.add(item);
            adapter.notifyDataSetChanged();

        }
*/

        Button btnadd = (Button)findViewById(R.id.bAddInv);
        btnadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(Inventory.this, AddItem.class);
                startActivity(i);


            }
        });

        Button btnreturn = (Button)findViewById(R.id.bInvReturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inventory.this, home.class);
                startActivity(i);
            }
        });

    }


}




