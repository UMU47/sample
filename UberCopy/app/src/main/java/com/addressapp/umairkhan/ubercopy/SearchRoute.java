package com.addressapp.umairkhan.ubercopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchRoute extends AppCompatActivity {

    Spinner user;
    ArrayAdapter<CharSequence> adapuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_route);

        user=findViewById(R.id.user);
        adapuser=ArrayAdapter.createFromResource(this,R.array.adaptuser,android.R.layout.simple_spinner_item);
        adapuser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user.setAdapter(adapuser);
        user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i)+" Is Selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
