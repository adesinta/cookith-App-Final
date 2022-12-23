package com.ades.tes1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ades.tes1.database.DatabaseHelper;
import com.ades.tes1.databinding.ActivityRegisterrBinding;

public class RegisterrActivity extends AppCompatActivity {
    private ActivityRegisterrBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view -> {
            Intent LoginIntent = new
                    Intent(RegisterrActivity.this, LoginnActivity.class);
            startActivity(LoginIntent);
        });

        binding.btnRegister.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            String confPass = binding.edtConfirm.getText().toString().trim();
            if (password.equals(confPass)) {
                long val = databaseHelper.addUser(username, password);
                if (val > 0) {
                    Toast.makeText(RegisterrActivity.this,"You must register", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(RegisterrActivity.this, LoginnActivity.class);
                    startActivity(moveToLogin);
                }
            } else {
                Toast.makeText(RegisterrActivity.this,"Password not matching", Toast.LENGTH_SHORT).show();
            }
        });
    }
}