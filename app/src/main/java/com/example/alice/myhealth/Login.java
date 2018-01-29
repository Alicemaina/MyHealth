package com.example.alice.myhealth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    protected FirebaseAuth mAuth;
    protected EditText mEmail;
    protected EditText mPassword;

    protected Button mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mEmail =(EditText)findViewById(R.id.email);
        mPassword=(EditText)findViewById(R.id.password);

        mLogin=(Button)findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                startSignIn();

            }
        });
    }

    private void startSignIn() {
            String email = mEmail.getText().toString();
            String password=mPassword.getText().toString();

            if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)){


                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this,"Sign In Problem", Toast.LENGTH_LONG).show();
                        }

                    }

                });
            }

    }
}
