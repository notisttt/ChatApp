package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterLogin extends AppCompatActivity {
    TextInputLayout email,password;
    Button login,register;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getEditText().getText().toString();
                String pass = password.getEditText().getText().toString();
                auth.signInWithEmailAndPassword(em,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()) {

                        startActivity(new Intent(RegisterLogin.this, MainActivity.class));
                        finish();

                    }

                    else {

                        Toast.makeText( RegisterLogin.this, "Wrong Email/Password", Toast.LENGTH_SHORT).show();
                    }

                    }
                });

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String em = email.getEditText().getText().toString();
                String pass = password.getEditText().getText().toString();

                auth.createUserWithEmailAndPassword(em,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                         Toast.makeText(RegisterLogin.this, "Account registered!", Toast.LENGTH_SHORT).show();

                      }

                      else {
                          Toast.makeText(RegisterLogin.this, "Error, please try again.", Toast.LENGTH_SHORT).show();
                      }

                    }
                });

            }
        });

    }


}