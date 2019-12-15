package com.example.wahobuddy20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAwesomeTextView = (TextView)findViewById(R.id.textView2);
        text2=(TextView)findViewById(R.id.textView3);

        inputStream = getResources().openRawResource(R.raw.poluare);

        //CALENDAR
        Calendar calendar = Calendar.getInstance();
        int ziuaCurenta = calendar.get(Calendar.DAY_OF_MONTH);


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

                        int oz=Integer.parseInt(ids[0]);
                        int pm=Integer.parseInt(ids[1]);
                        int co=Integer.parseInt(ids[2]);
                        int so=Integer.parseInt(ids[3]);
                        int no=Integer.parseInt(ids[4]);
                        Log.d("Colomn 1"," "+oz+" "+pm+" "+co+" "+so+" "+no);
                        if(oz>100)
                            myAwesomeTextView.setText("Cantitate mare de Ozon in aer.\nSe recomanda inchiderea geamurilor.");
                        else
                            myAwesomeTextView.setText("Se recomanda aerisirea incaperilor.");
                        if(pm>25 & co>25)
                            text2.setText("Evitati sa parasiti locuinta daca aveti probleme respiratorii");
                        else
                            text2.setText("Cantitate normala de microparticule si monoxid de carbon in aer");

                        // myAwesomeTextView.setText(oz);
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


