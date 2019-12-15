package com.example.wahobuddy20;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.wahobuddy20.MainActivity.co;
import static com.example.wahobuddy20.MainActivity.no;
import static com.example.wahobuddy20.MainActivity.oz;
import static com.example.wahobuddy20.MainActivity.pm;
import static com.example.wahobuddy20.MainActivity.so;

public class Main2Activity extends AppCompatActivity {

    TextView text=null;
    TextView text2=null;
    TextView text3=null;
    TextView text4=null;
    TextView text5=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text=(TextView)findViewById(R.id.ozon);
        text.setText("Ozon = "+oz+"ug");
        text=(TextView)findViewById(R.id.particule);
        text.setText("Microparticule = "+pm+"ug");
        text=(TextView)findViewById(R.id.carbon);
        text.setText("Monoxid de carbon= "+co+"mg");
        text=(TextView)findViewById(R.id.sulf);
        text.setText("Dioxid de sulf = "+so+"ug");
        text=(TextView)findViewById(R.id.azot);
        text.setText("Monoxid de azot = "+no+"ug");


        int value=(oz+pm+co+so+no)/5;
            ImageView im = (ImageView)findViewById(R.id.fatza);
               if(value<70) {
                   im.setBackgroundResource(R.drawable.green);
               } else
                   if(value>70 & value <120)
                   im.setBackgroundResource(R.drawable.yellow);
                   else if(value>120)

               im.setBackgroundResource(R.drawable.red);





    }
}
