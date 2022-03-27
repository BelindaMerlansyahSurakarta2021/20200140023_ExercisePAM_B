package com.example.todoapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.jar.Attributes;

public class TableTask extends AppCompatActivity {

    TextView nama,getNama;
    EditText aaaa,bbbb,cccc;
    FloatingActionButton action;
    String Nm, Task, jenis, time, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_task);
        aaaa = findViewById(R.id.MasuukanTask);
        bbbb = findViewById(R.id.MasukkanJenisTask);
        cccc = findViewById(R.id.MasuukanLamaTask);

        action = findViewById(R.id.Registrasi);

        nama = findViewById(R.id.Nama);
        getNama = findViewById(R.id.Namaa);

        Bundle bnl = getIntent().getExtras();
        Nm = bnl.getString("a");
        nama.setText(Nm);

        Bundle nd = getIntent().getExtras();
        name = nd.getString("z");
        getNama.setText(name);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task = aaaa.getText().toString();
                jenis = bbbb.getText().toString();
                time = cccc.getText().toString();

                if (jenis.length() == 0) {
                    bbbb.setError("jenis task");
                    Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
                } else if (time.length() == 0) {
                    cccc.setError("Lama task");
                    Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
                } else if (Task.isEmpty()) {
                    Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TableTask.this, "Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle bn = new Bundle();

                    bn.putString("Task", Task.trim());
                    bn.putString("jenis", jenis.trim());
                    bn.putString("time", time.trim());

                    Intent nte = new Intent(getApplicationContext(), hasiltask.class);

                    nte.putExtras(bn);
                    startActivity(nte);

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.sumbit){
            Task = aaaa.getText().toString();
            jenis = bbbb.getText().toString();
            time = cccc.getText().toString();

            if (jenis.length() == 0) {
                bbbb.setError("jenis task");
                Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
            } else if (time.length() == 0) {
                cccc.setError("Lama task");
                Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
            } else if (Task.isEmpty()) {
                Toast.makeText(TableTask.this, "Isi semua data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(TableTask.this, "Berhasil", Toast.LENGTH_SHORT).show();

                Bundle bn = new Bundle();

                bn.putString("Task", Task.trim());
                bn.putString("jenis", jenis.trim());
                bn.putString("time", time.trim());

                Intent nte = new Intent(getApplicationContext(), hasiltask.class);

                nte.putExtras(bn);
                startActivity(nte);

            }
        }
        else{
            Intent its = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(its);
        }
        return super.onOptionsItemSelected(item);
    }
}
