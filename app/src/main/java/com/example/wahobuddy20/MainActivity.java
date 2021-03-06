package com.example.wahobuddy20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    InputStream inputStream;
    String[] ids;
    TextView myAwesomeTextView = null;
    TextView text2=null;
    TextView text3=null;
    TextView text4=null;
    TextView text5=null;
    TextView text6=null;

    static int oz;
    static int pm;
    static int co;
    static int so;
    static int no;
    private Button buton;
    private Button buton2;
    static Calendar calendar = Calendar.getInstance();
    static int ziuaCurenta = calendar.get(Calendar.DAY_OF_MONTH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buton=(Button)findViewById(R.id.button);
        buton2=(Button)findViewById(R.id.button2);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        myAwesomeTextView = (TextView)findViewById(R.id.textView2);
        text2=(TextView)findViewById(R.id.textView3);
        text3=(TextView)findViewById(R.id.textView4);
        text4=(TextView)findViewById(R.id.textView5);
        text5=(TextView)findViewById(R.id.textView6);
        text6=(TextView)findViewById(R.id.textView7);

        inputStream = getResources().openRawResource(R.raw.poluare);

        //CALENDAR



        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {



                ids=csvLine.split(",");
                try{
                    String[] parts = ids[7].split("/");
                    int zi = Integer.parseInt(parts[1]);

                    if(ziuaCurenta==zi)
                    {

                        oz=Integer.parseInt(ids[0]);
                        pm=Integer.parseInt(ids[1]);
                        co=Integer.parseInt(ids[2]);
                        so=Integer.parseInt(ids[3]);
                        no=Integer.parseInt(ids[4]);
                        Log.d("Colomn 1"," "+oz+" "+pm+" "+co+" "+so+" "+no);


                        // myAwesomeTextView.setText(oz);
                        if(oz>100)
                        myAwesomeTextView.setText("Cantitate mare de Ozon in aer.");
                        else
                        myAwesomeTextView.setText("Cantitate OK de Ozon in aer.");
                        if(pm>25)
                            text2.setText("Cantitate mare de Particule PM2.5 si PM10 in aer.");
                        else
                            text2.setText("Cantitate OK de Particule PM2.5 si PM10 in aer.");
                        if(co>12.5)
                            text3.setText("Cantitate mare de Monoxid de Carbon in aer.");
                        else
                            text3.setText("Cantitate OK de Monoxid de Carbon in aer.");
                        if(so>250)
                            text4.setText("Cantitate mare de Dioxid de Sulf in aer.");
                        else
                            text4.setText("Cantitate OK de Dioxid de Sulf in aer.");
                        if(no>250)
                            text5.setText("Cantitate mare de Monoxid de Azot in aer.");
                        else
                            text5.setText("Cantitate OK de Monoxid de Azot in aer.");
                        if((oz>100 & pm>25) || (co>15 & so>200 & no>200))
                            text6.setText("Aerul este poluat. Este recomandat sa nu iesiti din casa si sa nu faceti activitati fizice fara o masca de antipoluare.");
                        else
                            text6.setText("Aerul nu este poluat. Puteti sa deschideti geamurile pentru aerisirea imobilului. De asemenea, calitatea aerului este buna pentru a practica activitati fizice.");
                        break;
                    }


                    /*if(zi==ziuaCurenta)
                    {
                        int oz=Integer.parseInt(ids[0]);
                        int pm=Integer.parseInt(ids[1]);
                        int co=Integer.parseInt(ids[2]);
                        int so=Integer.parseInt(ids[3]);
                        int no=Integer.parseInt(ids[4]);
                        Log.d("Colomn 1"," "+oz+" "+pm+" "+oz+" "+oz+" ");
                    }
                    */


                }catch (Exception e){
                    Log.d("Unknown",e.toString());
                }
            }

        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }



    }
    public void openActivity3()
    {
        Intent intent=new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}


