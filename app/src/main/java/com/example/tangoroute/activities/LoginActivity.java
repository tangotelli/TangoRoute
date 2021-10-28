package com.example.tangoroute.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.tangoroute.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

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
            LoginActivity activity = this;
            AuthCredential credential = EmailAuthProvider
                    .getCredential(this.etEmail.getText().toString(), this.etPassword.getText().toString());
            firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(activity, MainActivity.class));
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