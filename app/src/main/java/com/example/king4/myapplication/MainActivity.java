package com.example.king4.myapplication;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    static String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);

        //FragmentManager fragmentManager = getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //final BlankFragment blankFragment = BlankFragment.newInstance("a","b");

        btn1.setOnClickListener(new View.OnClickListener() {
            String mParam1 = "a";
            String mParam2 = "b";
            int i=0;

            @Override
            public void onClick(View v) {
                if(i==0) {
                    BlankFragment blankFragment = BlankFragment.newInstance(mParam1,mParam2);
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, blankFragment).commit();
                    i++;
                    Bundle bn = blankFragment.getData();
                    mParam1 = bn.getString("param1");
                    mParam2 = bn.getString("param2");
                    Log.e("para",mParam1 + " " + mParam2 + " " + i);
                }else {
                    Log.e("para",mParam1 + " " + mParam2);
                    BlankFragment2 blankFragment2 = BlankFragment2.newInstance(mParam2,mParam1);
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, blankFragment2).commit();
                    i--;
                    Bundle bn = blankFragment2.getData();
                    mParam1 = bn.getString("param1");
                    mParam2 = bn.getString("param2");
                }
            }
        });
    }
}
