package com.example.todoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ogin;
    TextView RRegister;
    EditText nama, password;
    String nm, alpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ogin = findViewById(R.id.Login);

        nama = findViewById(R.id.IdNama);

        password = findViewById(R.id.psd);

        RRegister =findViewById(R.id.Register);

        RRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itr = new Intent(getApplicationContext(),MenuRegister.class);
                startActivity(itr);
            }
        });
        ogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm = nama.getText().toString();

                alpassword = password.getText().toString();

                String nam ="Belinda";
                String Pass ="123";

                if(nm.length()==0){
                    nama.setError("Nama Harus Diperlukan");
                    Toast.makeText(MainActivity.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else if (alpassword.length()==0){
                    Toast.makeText(MainActivity.this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else if (!nm.equals(nam)){
                    Toast.makeText(MainActivity.this, "Nama salah", Toast.LENGTH_SHORT).show();

                }
                else if (!alpassword.equals(Pass)){
                    Toast.makeText(MainActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                }
                else if (nm.equals(nam)&&alpassword.equals(Pass)) {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();

                    Bundle bn = new Bundle();
                    bn.putString("a", nm.trim());
                    Intent in = new Intent(getApplicationContext(), TableTask.class);
                    in.putExtras(bn);
                    startActivity(in);
                }
                else {
                    Toast.makeText(MainActivity.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}