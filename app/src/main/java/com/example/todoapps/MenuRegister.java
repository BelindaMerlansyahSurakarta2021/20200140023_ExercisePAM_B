package com.example.todoapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MenuRegister extends AppCompatActivity {

    EditText nama,email,password,rpass;
    Button bn;
    String mn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_register);

        nama = findViewById(R.id.MasukkanNama);
        email = findViewById(R.id.MasukkanEmail);
        password = findViewById(R.id.pasword);
        rpass = findViewById(R.id.pass);
        bn = findViewById(R.id.button);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mn = nama.getText().toString();

                if (nama.getText().toString().length()==0) {
                    nama.setError("Nama tidak boleh kosong");
                }
                else if (email.getText().toString().length()==0){
                    email.setError("Nama tidak boleh kosong");
                }
                else if (password.getText().toString().isEmpty()
                ||rpass.getText().toString().isEmpty()) {
                    Toast.makeText(MenuRegister.this, "Data Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.getText().toString().equals(rpass.getText().toString())) {
                        Toast.makeText(MenuRegister.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                        Bundle bn = new Bundle();

                        bn.putString("z", mn.trim());

                        Intent nt = new Intent(getApplicationContext(), TableTask.class);

                        nt.putExtras(bn);
                        startActivity(nt);
                    }
                    else{
                        Toast.makeText(MenuRegister.this, "Password Salah", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}