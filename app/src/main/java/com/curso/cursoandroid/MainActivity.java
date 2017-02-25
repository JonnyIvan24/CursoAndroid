package com.curso.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","Estoy en onCrate");

        username = (EditText)findViewById(R.id.usernameEditText);
        password = (EditText)findViewById(R.id.passwordEditText);

        Button login = (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (passValidation()){
                    checkCredentials();
                }
            }
        });
    }
    private boolean checkCredentials(){
        boolean rightCredetentials = true;
        //return false;// para chequeo rapido
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        if (usernameText.equalsIgnoreCase("jonny")){
            if (passwordText.equalsIgnoreCase("admin")){
                //las credenciales son correctas
                Toast.makeText(getApplicationContext(),"Credenciales correctas!!",Toast.LENGTH_LONG).show();
            }else {
                password.setError("Password incorrecto");
                rightCredetentials = false;
            }
        }else {
            username.setError("Usuario incorrecto");
            rightCredetentials = false;
        }
        return rightCredetentials;
    }
    private boolean passValidation() {
        boolean passValidation = true;
        username.setError(null);
        password.setError(null);
        String usernameText = username.getText().toString();
        if (usernameText.length() == 0){ //en caso de estar vacio
            username.setError("Username no puede estar vacio");
            passValidation = false;
        }
        String passwordText = password.getText().toString();
        if (passwordText.length() == 0){
            password.setError("Password no puede estar vacio");
            passValidation = false;
        }
        return passValidation;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","Estoy en onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","Estoy en onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","Estoy en onDestroyd");
    }
}
