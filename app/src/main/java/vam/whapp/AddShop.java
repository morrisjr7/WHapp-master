package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Victoria on 4/5/2018.
 */

public class AddShop extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_shop);
    }

    void onShopConfirmClick(View v){

        EditText item = (EditText)findViewById(R.id.TFaddItem_Shop);
        EditText notes = (EditText)findViewById(R.id.TFaddNotes_Shop); //nonfunctional right now

        String item_str = item.getText().toString();
        String notes_str = notes.getText().toString();

        if(item_str == null){
            Toast popup = Toast.makeText(this, "Must enter item title", Toast.LENGTH_LONG);
            popup.show();
        }

        Intent i = new Intent(AddShop.this, Shopping.class);
        i.putExtra("Item", item_str);
        startActivity(i);
    }

    void onShopCancelClick(View v){

        Intent i = new Intent(AddShop.this, Shopping.class);
        startActivity(i);
    }
}
