package com.addressapp.umairkhan.sampletest;

import android.content.Context;
import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button tp1,tp2,md1,tp3;

    String[] titles,descriptions,rpt;

    int[] images={R.drawable.bk,R.drawable.mcd,R.drawable.elco,R.drawable.azr,R.drawable.sh,R.drawable.mom,R.drawable.mama,R.drawable.pc,R.drawable.bw,R.drawable.pbb,R.drawable.bt,R.drawable.nb,R.drawable.sb};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp1=findViewById(R.id.top1);
        tp2=findViewById(R.id.top2);
        tp3=findViewById(R.id.top3);
        md1=findViewById(R.id.middle1);

        tp1.setOnClickListener(this);
        tp2.setOnClickListener(this);
        tp3.setOnClickListener(this);
        md1.setOnClickListener(this);

        Resources rs=getResources();
        titles=rs.getStringArray(R.array.titles);
        descriptions=rs.getStringArray(R.array.descriptions);
        rpt=rs.getStringArray(R.array.ratings);

        lv= findViewById(R.id.list_view);
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

        lv=findViewById(R.id.list_view);
        myADAP list_adapter=new myADAP(this, images, titles, descriptions, rpt);
        lv.setAdapter(list_adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int item, long item_id) {
               if(item==0) {

                   Intent next = new Intent(view.getContext(), Main2Activity.class);
                   startActivityForResult(next, 0);
               }
                if(item==1) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 1);
                }
                if(item==2) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 2);
                }
                if(item==3) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 3);
                }
                if(item==4) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 4);
                }
                if(item==5) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 5);
                }
                if(item==6) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 6);
                }
                if(item==7) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 7);
                }
                if(item==8) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 8);
                }
                if(item==9) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 9);
                }
                if(item==10) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 10);
                }
                if(item==11) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 11);
                }
                if(item==12) {

                    Intent next = new Intent(view.getContext(), Main2Activity.class);
                    startActivityForResult(next, 12);
                }

            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.top1:
                Toast.makeText(MainActivity.this, "Clicked NOW", Toast.LENGTH_SHORT).show();
                break;
            case R.id.top2:
                Toast.makeText(MainActivity.this, "Clicked OTHER", Toast.LENGTH_SHORT).show();
                break;
            case R.id.top3:
                Toast.makeText(MainActivity.this, "Clicked OFFERS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.middle1:
                Toast.makeText(MainActivity.this, "Clicked Sort/Filter", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}


class myADAP extends ArrayAdapter<String>{
    private int[] imgs;
    private Context context;
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


    class MyViewHolder {
        ImageView img;
        TextView textView;
        TextView td;
        TextView tr;
        MyViewHolder(View v){
            img=v.findViewById(R.id.img);
            textView=v.findViewById(R.id.textView);
            td=v.findViewById(R.id.td);
            tr=v.findViewById(R.id.tr);
        }
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row=convertView;
        MyViewHolder holder;
        if(row==null) {
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            row = inflater.inflate(R.layout.list_layout, parent, false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
        }
        else
        {
           holder= (MyViewHolder) row.getTag();
        }

        holder.img.setImageResource(imgs[position]);
        holder.textView.setText(titles[position]);
        holder.td.setText(descriptions[position]);
        holder.tr.setText(ratings[position]);

        return row;
    }

}