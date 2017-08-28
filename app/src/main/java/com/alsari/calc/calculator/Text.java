package com.alsari.calc.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String Title;
        Title = getIntent().getExtras().getString("manualTitle");
        setTitle(Title);


        WebView infoWebView = (WebView)findViewById(R.id.textViewInfo);

        String myHtml = getIntent().getExtras().getString("manualKey");

        infoWebView.setBackgroundColor(getResources().getColor(R.color.trans));

        infoWebView.loadDataWithBaseURL("file:///android_asset/", myHtml, "text/html", "UTF-8", null);

    }

    public boolean onOptionsItemSelected(MenuItem item){

        finish();
        return true;
    }

}
