package com.example.consert.consert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ConcertList_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concertlist);
        //init();
        TableRow tmp_OnClickTableRow = (TableRow) findViewById(R.id.tblRow_Concert1);
        tmp_OnClickTableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated showing description.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(ConcertList_Activity.this, ConcertDescriptionActivity.class));
            }
        });

    }

    TextView tmp_txtView_concertTitle;
    TextView tmp_txtView_artist;
    TextView tmp_txtView_concertDate;
    TableRow new_row;

    public void init(){
        TableLayout tbl_Layout = (TableLayout) findViewById(R.id.tblLayout_concertList);
        tmp_txtView_concertTitle = (TextView)getLayoutInflater().inflate(R.layout.template_textview_concerttitle, null);
        tmp_txtView_artist= (TextView)getLayoutInflater().inflate(R.layout.template_textview_artist, null);
        tmp_txtView_concertDate= (TextView)getLayoutInflater().inflate(R.layout.template_textview_date, null);
        //ToDo: change length depending on the given backs list

        for (int i = 0; i <5; i++) {
            new_row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            new_row.setLayoutParams(lp);
            //ToDo: need to take data from WebService/Database
            tmp_txtView_concertTitle.setText("Title: " + i);
            tmp_txtView_artist.setText("Artist: " + i);
            tmp_txtView_concertDate.setText("Date: " + i);
            //tmp_txtView_concertTitle.setText("DemoTitle");
            //tmp_txtView_concertTitle.setMaxLines(2);
            //tmp_txtView_concertTitle.setTextSize(18);

            new_row.addView(tmp_txtView_concertTitle);
            new_row.addView(tmp_txtView_artist);
            new_row.addView(tmp_txtView_concertDate);
            tbl_Layout.addView(new_row,i);
        }
    }
}
