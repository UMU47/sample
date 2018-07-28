package com.addressapp.umairkhan.sampletest;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private int lasttop=0;

    public void parallax(final View v){
        final Rect r=new Rect();
        v.getLocalVisibleRect(r);
        if(lasttop!=r.top){
            lasttop=r.top;
            v.post(new Runnable() {
                @Override
                public void run() {
                    v.setY((float)(r.top/2.0));
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
