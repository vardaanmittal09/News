package com.example.android.booksapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    DatabaseHelper db;
    TextView tname,tsurname,tmobile,tbloodgroup,tstate,tdiseases,tmedications,tpincode,tcity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tname=(TextView)findViewById(R.id.name);
        tmobile=(TextView)findViewById(R.id.tmobile);
        tstate=(TextView)findViewById(R.id.tstate);
        tcity=(TextView)findViewById(R.id.tcity);
        tpincode=(TextView)findViewById(R.id.tpincode);
        tbloodgroup=(TextView)findViewById(R.id.tbloodgroup);
        tdiseases=(TextView)findViewById(R.id.tdiseases);
        tmedications=(TextView)findViewById(R.id.tmedications);
        db=new DatabaseHelper(this);
        String username=getIntent().getStringExtra("name");
        /*Cursor name=db.getname(username);
        name.moveToPosition(1);
        Cursor surname=db.getsurname(username);
        Cursor mobile=db.getmobile(username);*/


        String name=db.getname(username);
        String mobile=db.getmobile(username);
        String state=db.getstate(username);
        String city=db.getCity(username);
        String pincode=db.getPincode(username);
        String blood_group=db.getblood_group(username);
        String diseases=db.getDiseases(username);
        String medications=db.getMedications(username);
        tname.setText(name.toString());
        tmobile.setText(mobile.toString());
        tbloodgroup.setText(blood_group.toString());
        tdiseases.setText(diseases.toString());
        tmedications.setText(medications.toString());
        tstate.setText(state.toString());
        tcity.setText(city.toString());
        tpincode.setText(pincode.toString());
    }
}
