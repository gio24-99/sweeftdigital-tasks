package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Spinner fromCurrency;
    TextView outPut;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        fromCurrency = findViewById(R.id.fromCurrency);
        outPut = findViewById(R.id.outPut);


        List < String > currencyNames = new ArrayList < String > ();
        List < String > exchangeRateFrom = new ArrayList < > ();
        List < String > exchangeRateTo = new ArrayList < > ();

        try {
            URL url = new URL("http://www.nbg.ge/rss.php");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            Boolean test = false;
            while ((str = in .readLine()) != null) {
                if (str.contains("td")) {

                    str = str.replaceAll("<[^>]*>", "");
                    str = str.replaceAll("(\\s)", "");

                    if (str.length() == 3) {
                        currencyNames.add(str);
                    }
                    if (str.length() == 6) {
                        if (!test) {
                            exchangeRateFrom.add(str);
                            test = true;
                        } else {
                            exchangeRateTo.add(str);
                            test = false;
                        }

                    }
                }
            } in .close();
        } catch (MalformedURLException e) {} catch (IOException e) {}

        ArrayAdapter cT = new ArrayAdapter < String > (this, R.layout.support_simple_spinner_dropdown_item, currencyNames);
        fromCurrency.setAdapter(cT);


        fromCurrency.setSelection(0);

        fromCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView < ? > parentView, View selectedItemView, int position, long id) {
                String rateText = new String();

                rateText = exchangeRateFrom.get(position) + "\n" + exchangeRateTo.get(position);
                outPut.setText(rateText);
            }

            @Override
            public void onNothingSelected(AdapterView < ? > parentView) {

            }

        });
    }
}