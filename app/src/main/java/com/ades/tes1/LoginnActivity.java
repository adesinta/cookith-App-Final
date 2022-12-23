package com.ades.tes1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ades.tes1.database.DatabaseHelper;
import com.ades.tes1.databinding.ActivityLoginnBinding;

public class LoginnActivity extends AppCompatActivity {
    private ActivityLoginnBinding binding;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            boolean res = databaseHelper.checkUser(username, password);

            if (res) {
                Toast.makeText(LoginnActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                Intent contentIntent = new Intent(LoginnActivity.this, MainActivity.class);
                startActivity(contentIntent);
            } else {
                Toast.makeText(LoginnActivity.this,"Username or Password Invalid", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(LoginnActivity.this, RegisterrActivity.class);
            startActivity(registerIntent);
        });
    }
}