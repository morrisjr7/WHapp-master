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

public class Welcome extends Activity {

    LocalDB db = new LocalDB(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }

    void onWelcomeClick(View v){

        if(v.getId() == R.id.bLogin){
            //
            EditText email = (EditText)findViewById(R.id.TFloginemail);
            EditText pword = (EditText)findViewById(R.id.TFloginpword);
            String str_email = email.getText().toString();
            String str_pword = pword.getText().toString();

            //check if correct
            if(db.isUser(str_email, str_pword)){
                Intent i = new Intent(Welcome.this, home.class);
                startActivity(i);
            }else{
                Toast popup = Toast.makeText(this, "Email or password incorrect", Toast.LENGTH_LONG);
                popup.show();
            }

        }

        if(v.getId() == R.id.bSignup){

            Intent i = new Intent(Welcome.this, Signup.class);
            startActivity(i);
        }
    }
}
