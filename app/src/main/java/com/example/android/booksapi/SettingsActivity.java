package com.example.android.booksapi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    LinearLayout setting_language,setting_reminder,setting_ads,setting_share,setting_rate,
            setting_notifications,setting_faq,setting_contact,setting_policy,setting_term_of_use;
    Switch notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        notification=(Switch)findViewById(R.id.switch_btn);
        setting_language=(LinearLayout) findViewById(R.id.setting_id_language);
        setting_reminder=(LinearLayout) findViewById(R.id.setting_id_reminder);
        setting_rate=(LinearLayout)findViewById(R.id.setting_id_rate_app);
        setting_faq=(LinearLayout) findViewById(R.id.setting_id_faq);
        setting_contact=(LinearLayout) findViewById(R.id.setting_id_contact_us);
        setting_policy=(LinearLayout) findViewById(R.id.setting_id_policy);
        setting_term_of_use=(LinearLayout) findViewById(R.id.setting_id_term_of_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });


        setting_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Setting_Language.class);
                startActivity(i);
            }
        });

        setting_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Setting_Reminder.class);
                startActivity(i);
            }
        });

        setting_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Settings_Faq.class);
                startActivity(i);
            }
        });

        setting_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Setting_Policy.class);
                startActivity(i);
            }
        });

        setting_term_of_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Setting_Term_of_use.class);
            }
        });

        setting_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SettingsActivity.this, Setting_Rate.class);
                startActivity(i);
            }
        });

    }
}
