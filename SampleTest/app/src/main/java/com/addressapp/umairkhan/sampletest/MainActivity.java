package com.addressapp.umairkhan.sampletest;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] titles;
    String[] descriptions;
    String[] rpt;

    int[] images={R.drawable.bk,R.drawable.mcd,R.drawable.elco,R.drawable.azr,R.drawable.sh,R.drawable.mom,R.drawable.mama,R.drawable.pc,R.drawable.bw,R.drawable.pbb,R.drawable.bt,R.drawable.nb,R.drawable.sb};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources rs=getResources();
        titles=rs.getStringArray(R.array.titles);
        descriptions=rs.getStringArray(R.array.descriptions);
        rpt=rs.getStringArray(R.array.ratings);

        lv=(ListView) findViewById(R.id.list_view);
        myADAP adap=new myADAP(this,images,titles,descriptions,rpt);
        lv.setAdapter(adap);

        BottomNavigationView bottomNavigationView= findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.action_nearme:
                        Toast.makeText(MainActivity.this, "Clicked NearMe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_explore:
                        Toast.makeText(MainActivity.this, "Clicked Explore", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_cart:
                        Toast.makeText(MainActivity.this, "Clicked Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_account:
                        Toast.makeText(MainActivity.this, "Clicked Account", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}

class myADAP extends ArrayAdapter<String>{
    int[] imgs;
    Context context;
    String[] titles;
    String[] descriptions;
    String[] ratings;
    myADAP(Context c, int[] imgs, String[] titles, String[] descriptions, String[] ratings){
        super(c,R.layout.list_layout,R.id.title,titles);{
            this.context=c;
            this.imgs=imgs;
            this.titles=titles;
            this.descriptions=descriptions;
            this.ratings=ratings;

        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row;
        row = inflater.inflate(R.layout.list_layout, parent, false);

        ImageView img=(ImageView)row.findViewById(R.id.img);
        TextView tt=(TextView)row.findViewById(R.id.textView);
        TextView tt1=(TextView)row.findViewById(R.id.td);
        TextView tt2=(TextView)row.findViewById(R.id.tr);

        img.setImageResource(imgs[position]);
        tt.setText(titles[position]);
        tt1.setText(descriptions[position]);
        tt2.setText(ratings[position]);


        return row;
    }

}