package com.example.android.booksapi;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText uname,pass;
    Button login;
    TextView register;
    String passsss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        uname=(EditText)findViewById(R.id.luser);
        pass=(EditText)findViewById(R.id.lpass);
        login=(Button)findViewById(R.id.login);
        register=(TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,register.class);
                startActivity(i);
            }
        });


        // Toast.makeText(this, pass.getText().toString(), Toast.LENGTH_SHORT).show();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    if(db.usernamevalid(uname.getText().toString())==false){
                        uname.setError("Please enter valid username");
                    }
                    else if(uname.getText().toString().equals("")){
                        uname.setError("Please enter username");
                    }
                    else if(pass.getText().toString().equals("")){
                        pass.setError("Please enter password");
                    }
                    else {
                        passsss = db.getpassword(uname.getText().toString());
                        if (passsss.equals(pass.getText().toString())) {
                            Intent i = new Intent(MainActivity.this, TAbbed.class);
                            i.putExtra("name", uname.getText().toString());
                            startActivity(i);
                            uname.setText("");
                            pass.setText("");

                        } else {
                            Toast.makeText(MainActivity.this, "Please check password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                else
                {
                    try {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                        alertDialog.setTitle("Info");
                        alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);

                        alertDialog.show();
                    }
                    catch(Exception e)
                    {
                        Log.d("Error",  "Show Dialog: "+e.getMessage());
                    }
                }

            }
        });

    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(MainActivity.this, "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
