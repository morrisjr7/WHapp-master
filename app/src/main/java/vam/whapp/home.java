package vam.whapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import static android.app.NotificationManager.IMPORTANCE_LOW;

public class home extends AppCompatActivity {

    private BottomNavigationView navBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBot = (BottomNavigationView)findViewById(R.id.NavBot);
        navBot.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch(item.getItemId()){
                    case R.id.action_add:
                        i = new Intent(home.this, AddItem.class);
                        //putExtra
                        startActivity(i);
                        return true;
                    case R.id.action_inv:
                        i = new Intent(home.this, Inventory.class);
                        startActivity(i);
                        return true;
                    case R.id.action_shop:
                        i = new Intent(home.this, Shopping.class);
                        startActivity(i);
                        return true;
                    case R.id.action_wh:
                        i = new Intent(home.this, WM.class);
                        startActivity(i);
                        return true;
                    case R.id.action_set:
                        i = new Intent(home.this, Settings.class);
                        startActivity(i);
                        return true;

                }
                return false;
            }
        });
        sendNotification("Welcome to Warehouse App!", "You currently have no items in storage.");

    }
    public void sendNotification (String NotificationtTitle, String NotificationContent){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Warehouse_Ch";
            String CH_description = "Warehouse App Channel";
            NotificationChannel mChannel =  new NotificationChannel("Warehouse",name,IMPORTANCE_LOW);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(mChannel);

        }
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder (this,"Warehouse");
                mBuilder
                .setSmallIcon(R.drawable.ic_shop)
                .setContentTitle(NotificationtTitle)
                .setContentText(NotificationContent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mBuilder.build());

    }

}
