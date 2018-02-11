package com.team3.fish_quality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button reportButton= (Button)findViewById(R.id.reportButton);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent);
            }
        });

        DataSet.calculate();
    }

    @Override
    public void onBackPressed() {

        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
