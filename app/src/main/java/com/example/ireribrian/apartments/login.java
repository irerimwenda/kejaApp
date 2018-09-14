package com.example.ireribrian.apartments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private EditText memailText;
    private EditText mpasswordText;
    private CardView mcardView;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memailText = (EditText) findViewById(R.id.regemail);
        mpasswordText = (EditText) findViewById(R.id.pass);
        mcardView = (CardView) findViewById(R.id.cardView);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplication(), homepage.class));
        }

        mcardView.setOnClickListener(this);

        TextView registerText = (TextView) findViewById(R.id.signtext);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent mainIntent = new Intent(login.this, register.class);
                login.this.startActivity(mainIntent);
                login.this.finish();
            }
        });
    }

    private void userLogin() {

        String email = memailText.getText().toString().trim();
        String password = mpasswordText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing In....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(login.this, "Welcome", Toast.LENGTH_SHORT).show();
                            final Intent mainIntent = new Intent(login.this, homepage.class);
                            login.this.startActivity(mainIntent);
                            login.this.finish();
                        } else {
                            Toast.makeText(login.this, "Error in Login. Please try again later....", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {

        if(view == mcardView){
            userLogin();
        }

    }

    }
