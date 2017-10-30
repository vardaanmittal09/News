package com.example.android.booksapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    DatabaseHelper db;
    EditText name,mobile,username,password,confirm;
    Button add;
    Vibrator vibe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.pass);
        confirm=(EditText)findViewById(R.id.confirm);
        add=(Button)findViewById(R.id.button);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        addata();

    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }

        return false;
    };
    public void addata(){

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")){
                    name.setError("Please enter Name");
                    vibe.vibrate(200);
                }
                else if(mobile.getText().toString().equals("")){
                    mobile.setError("Please enter  mobile number");
                    vibe.vibrate(200);
                }
                else if(username.getText().toString().equals("")){
                    username.setError("Please enter username");
                    vibe.vibrate(200);
                }
                else if(password.getText().toString().equals("")){
                    password.setError("Please enter password");
                    vibe.vibrate(200);
                }
                else if(confirm.getText().toString().equals("")){
                    confirm.setError("Please confirm password");
                    vibe.vibrate(200);
                }
                else if(!password.getText().toString().equals(confirm.getText().toString())){
                    confirm.setError("Password Doesn't match");
                    vibe.vibrate(200);
                }
                else if(db.usernamevalid(username.getText().toString())==true){
                    username.setError("Username Already Taken");
                    vibe.vibrate(200);
                }
                else{
                    boolean result= db.insertdataprofile(name.getText().toString(),
                            mobile.getText().toString(),username.getText().toString(),
                            password.getText().toString(),confirm.getText().toString(),"n","n","n","n","n","n");
                    if(result==true){
                        Toast.makeText(register.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(register.this, "Some Error", Toast.LENGTH_SHORT).show();
                    }
                    Intent i=new Intent(register.this,MainActivity.class);
                    startActivity(i);
                    name.setText("");
                    mobile.setText("");
                    username.setText("");
                    password.setText("");
                    confirm.setText("");
                }

            }

        });

    }
}
