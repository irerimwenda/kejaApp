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

public class register extends AppCompatActivity implements View.OnClickListener {

    private EditText mfirstNameText;
    private EditText mlastNameText;
    private EditText memailText;
    private EditText musername;
    private EditText mpasswordText;
    private CardView msignupCardview;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplication(), homepage.class));
        }

        progressDialog = new ProgressDialog(this);

        mfirstNameText = (EditText) findViewById(R.id.fname);
        mlastNameText = (EditText) findViewById(R.id.lname);
        memailText = (EditText) findViewById(R.id.regemail);
        musername = (EditText) findViewById(R.id.usernm);
        mpasswordText = (EditText) findViewById(R.id.pass);
        msignupCardview = (CardView) findViewById(R.id.cardView);


        TextView loginText = (TextView) findViewById(R.id.logtext);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent mainIntent = new Intent(register.this, login.class);
                register.this.startActivity(mainIntent);
                register.this.finish();
            }
        });

        msignupCardview.setOnClickListener(this);

    }

    private void registerUser() {
        String firstname = mfirstNameText.getText().toString().trim();
        String lastname = mlastNameText.getText().toString().trim();
        String email = memailText.getText().toString().trim();
        String username = musername.getText().toString().trim();
        String password = mpasswordText.getText().toString().trim();

        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(this, "Please enter First Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(lastname)) {
            Toast.makeText(this, "Please enter Last Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Signing Up....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Welcome", Toast.LENGTH_SHORT).show();
                            final Intent mainIntent = new Intent(register.this, homepage.class);
                            register.this.startActivity(mainIntent);
                            register.this.finish();
                        } else {
                            Toast.makeText(register.this, "Error in Signing Up. Please try again later....", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });

    }

        @Override
        public void onClick(View view) {
            if(view == msignupCardview){
                registerUser();
            }

        }

}
