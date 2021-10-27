package com.example.tangoroute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.etEmail = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        if (this.areValidCredentials()) {
            AuthCredential credential = EmailAuthProvider
                    .getCredential(this.etEmail.getText().toString(), this.etPassword.getText().toString());
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Snackbar.make(
                                        findViewById(android.R.id.content),
                                        "worked",
                                        Snackbar.LENGTH_LONG
                                )
                                        .show();
                            } else {
                                String message = getString(R.string.auth_failure);
                                message = message.replace("$", task.getException().getMessage());
                                Snackbar.make(
                                        findViewById(android.R.id.content),
                                        message,
                                        Snackbar.LENGTH_LONG
                                )
                                        .show();
                            }
                        }
                    });
        }
    }

    private boolean areValidCredentials() {
        boolean valid = true;
        if (TextUtils.isEmpty(this.etEmail.getText())) {
            this.etEmail.setError(getString(R.string.required_field));
            valid = false;
        } else {
            this.etEmail.setError(null);
        }
        if (TextUtils.isEmpty(this.etPassword.getText())) {
            this.etPassword.setError(getString(R.string.required_field));
            valid = false;
        } else {
            this.etPassword.setError(null);
        }
        return valid;
    }
}