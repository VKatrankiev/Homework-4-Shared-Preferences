package com.example.user1.homework4sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    EditText edtPass;
    EditText edtUser;
    EditText edtConfPass;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final SharedPreferences sp = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();


        edtConfPass = (EditText) findViewById(R.id.edt_reg_conf_password);
        edtPass = (EditText) findViewById(R.id.edt_reg_password);
        edtUser = (EditText) findViewById(R.id.edt_reg_username);
        btnRegister = (Button) findViewById(R.id.btn_register_user);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(edtPass.getText()).equals(String.valueOf(edtConfPass.getText()))) {
                    editor.putString(String.valueOf(edtUser.getText()), String.valueOf(edtUser.getText()));
                    editor.putString(String.valueOf(edtPass.getText()), String.valueOf(edtPass.getText()));
                    editor.commit();
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                }
            }
        });

    }
}
