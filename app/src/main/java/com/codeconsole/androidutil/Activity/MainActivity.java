package com.codeconsole.androidutil.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codeconsole.androidutil.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        findViewById(R.id.notify_btn).setOnClickListener(this);
    }


    int NOTIFICATION_CODE = 100;
    int count = 1;
    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
    Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("Title")
                .setContentText("Content text" + count)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(getDefaultBitMAp())
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setStyle(bigPictureStyle).build();

        bigPictureStyle.bigPicture(getDefaultBitMAp());

        inboxStyle.setBigContentTitle("content ");
        inboxStyle.addLine("new line " + count);

        notification.flags = Notification.FLAG_AUTO_CANCEL;
        nManager.notify(NOTIFICATION_CODE, notification);
        count++;
    }

    private Bitmap getDefaultBitMAp() {
        return BitmapFactory.decodeResource(getResources(),
                R.drawable.msd);
    }
}
