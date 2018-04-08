package vam.whapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by victoria on 3/27/18.
 */

public class Settings extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Button btnreturn = (Button)findViewById(R.id.bSettingsReturn);
        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Settings.this, home.class);
                startActivity(i);
            }
        });
    }

    //notification settings

    //other. . . .settings?
}
