package com.example.todoapps;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.widget.TextView;

public class hasiltask extends AppCompatActivity {

    TextView kst, jns, intime;
    String tsk, itjns, itTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasiltask);

        kst = findViewById(R.id.task1);
        jns = findViewById(R.id.task2);
        intime = findViewById(R.id.task3);

        Bundle bn = getIntent().getExtras();

        tsk = bn.getString("Task");
        itjns = bn.getString("jenis");
        itTime = bn.getString("time");

        kst.setText(tsk);
        jns.setText(itjns);
        intime.setText(itTime);
    }
}