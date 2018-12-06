package com.example.consert.consert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;

public class ConcertList_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concertlist);

        TableRow tmp_OnClickTableRow = (TableRow) findViewById(R.id.tblRow_COncert1);
        tmp_OnClickTableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Simulated showing description.", Toast.LENGTH_LONG).show();
                //attemptLogin();
                startActivity(new Intent(ConcertList_Activity.this, ConcertDescriptionActivity.class));
            }
        });
    }
}
