package com.example.wahobuddy20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.wahobuddy20.MainActivity.co;
import static com.example.wahobuddy20.MainActivity.no;
import static com.example.wahobuddy20.MainActivity.oz;
import static com.example.wahobuddy20.MainActivity.pm;
import static com.example.wahobuddy20.MainActivity.so;
import static com.example.wahobuddy20.MainActivity.ziuaCurenta;

public class Main3Activity extends AppCompatActivity {
    static int m;
    TextView agloText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        String[] ids;
        InputStream inputStream = getResources().openRawResource(R.raw.trafic);

        int m;

        ImageView im = (ImageView)findViewById(R.id.fatza);
        if(m<70) {
            im.setBackgroundResource(R.drawable.green);
        } else
        if(m>70 & m <120)
            im.setBackgroundResource(R.drawable.yellow);
        else if(m>120)

            im.setBackgroundResource(R.drawable.red);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        agloText=(TextView)findViewById(R.id.aglo);
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {


                ids=csvLine.split(",");
                try{

                    String[] parts = ids[5].split("T");
                    String[] parts2 = parts[0].split("-");

                    int zi = Integer.parseInt(parts2[2]);
                    if(zi==ziuaCurenta)
                    {
                        m=Integer.parseInt(ids[6]);

                        if(m>10)
                            agloText.setText("Evitati utilizarea autovehiculului personal");
                        else
                            agloText.setText("Drumul este liber");
                    }


                    /*if(ziuaCurenta==zi)
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
}
