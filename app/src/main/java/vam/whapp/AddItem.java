package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by resnet on 4/2/18.
 */

public class AddItem extends Activity {

    LocalDB db = new LocalDB(this);
    String item_str;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

    }


    void onAddConfirmClick(View v){


        EditText item = (EditText)findViewById(R.id.TFaddItem);
            EditText exp = (EditText)findViewById(R.id.TFaddExp);
            EditText price = (EditText)findViewById(R.id.TFaddPrice);
            EditText loc = (EditText)findViewById(R.id.TFaddLoc);
            EditText notes = (EditText)findViewById(R.id.TFaddNotes);

        item_str = item.getText().toString();
            String exp_str = exp.getText().toString();
            String price_str = price.getText().toString();
            String loc_str = loc.getText().toString();
            String notes_str = notes.getText().toString();
            if(item_str == null){
                Toast popup = Toast.makeText(this, "Must enter item title", Toast.LENGTH_LONG);
                popup.show();
            }else if(exp_str == null){
                Toast popup = Toast.makeText(this, "Must enter expiration date", Toast.LENGTH_LONG);
                popup.show();
            }else if(price_str == null){
                Toast popup = Toast.makeText(this, "Must enter price of item", Toast.LENGTH_LONG);
                popup.show();
            }else if(loc_str == null){
                Toast popup = Toast.makeText(this, "Must enter item location", Toast.LENGTH_LONG);
                popup.show();
            }else{
          String output = (item_str + " " + exp_str + " " + price_str + " " + loc_str + " " + notes_str);
                Item new_item = new Item(item_str, exp_str, price_str, loc_str, notes_str);
                Log.d("ItemTag", output);
                if(new_item == null){
                    Log.d("NullTag", "Item is null");
                }
                db.insertItem(new_item);
            }
        Intent i = new Intent(AddItem.this, Inventory.class);
 //       i.putExtra("Item", item_str);
        startActivity(i);

    }

    void onAddCancelClick(View v){

        Intent i = new Intent(AddItem.this, Inventory.class);
        startActivity(i);
    }

}
