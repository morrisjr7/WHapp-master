package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by victoria on 3/29/18.
 */

public class Signup extends Activity {

    LocalDB helper = new LocalDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    void onSignupClick(View v){

        if(v.getId() == R.id.bConfirm){

            EditText pword = (EditText)findViewById(R.id.TFpwordSU);
            EditText pword2 = (EditText)findViewById(R.id.TFconpwordSU);

            if((pword.getText().toString()).compareTo(pword2.getText().toString()) == 0) {
                EditText email = (EditText)findViewById(R.id.TFemailSU);
                EditText phone = (EditText)findViewById(R.id.TFphoneSU);

                String stremail = email.getText().toString();
                String strpword = pword.getText().toString();
                String strphone = phone.getText().toString();

                User u = new User(stremail, strpword, strphone);
                helper.insertUser(u);

                Intent i = new Intent(Signup.this, home.class);
                startActivity(i);
            }else{

                Toast popup = Toast.makeText(this, "Passwords did not match", Toast.LENGTH_LONG);
                popup.show();
                //pop up: Passwords don't match
            }
        }

        if(v.getId() == R.id.bCancel){
            Intent i = new Intent(Signup.this, Welcome.class);
            startActivity(i);
        }
    }
}
