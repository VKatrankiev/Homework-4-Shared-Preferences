package com.example.user1.homework4sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPass;
    Button btnLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_reg);
        edtPass = (EditText) findViewById(R.id.edt_password);
        final SharedPreferences sp = getPreferences(MODE_PRIVATE);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            String username = String.valueOf(edtUsername.getText());
            String password = String.valueOf(edtPass.getText());

            @Override
            public void onClick(View view) {
                if (sp.getString(username, username + " ").equals(username)
                        && sp.getString(password, password + " ").equals(password)) {
                    startActivity(new Intent(MainActivity.this, LoggedInActivity.class));
                }
            }
        });
    }

}
