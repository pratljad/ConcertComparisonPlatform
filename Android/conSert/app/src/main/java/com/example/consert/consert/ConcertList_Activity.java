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

    TextView tmp_txtView_concertTitle ;
    TextView tmp_txtView_artist ;
    public void init(){
        TableLayout ll = (TableLayout) findViewById(R.id.tblLayout_concertList);
        tmp_txtView_concertTitle = (TextView)getLayoutInflater().inflate(R.layout.template_textview_concerttitle, null);
        tmp_txtView_artist= (TextView)getLayoutInflater().inflate(R.layout.template_textview_concerttitle, null);
        //ToDo: change length depending on the given backs list

        for (int i = 0; i <2; i++) {

            TableRow new_row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            new_row.setLayoutParams(lp);
            tmp_txtView_concertTitle = new TextView(this);
            //ToDo: need to get data from WebService/Database
            tmp_txtView_concertTitle.setText("DemoTitle");
            tmp_txtView_concertTitle.setMaxLines(2);
            tmp_txtView_concertTitle.setTextSize(18);


            new_row.addView(tmp_txtView_concertTitle);
            ll.addView(new_row,i);
        }
    }

}
