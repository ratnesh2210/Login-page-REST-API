package com.example.loginpage_922;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText edtname,editpass;
    Button btnLogin;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = findViewById(R.id.editName);
        editpass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String pass = editpass.getText().toString();

                if(name.equals("admin") && pass.equals("pass")){
                    Intent i = new Intent(getApplicationContext(),Secocnd.class);
                    i.putExtra("iName",name);
                    startActivity(i);
                }
                else {
                    counter--;
                    if(counter > 0) {
                        alertBox();
                    }
                    else{
                        btnLogin.setEnabled(false);
                    }
                }
            }
        });
    }

    public void alertBox(){
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Alert!");
        ab.setIcon(R.drawable.alert);
        if(counter == 1) {
            ab.setMessage("Invalid Username or Password "+ counter +" attempt left!");
        }
        else {
            ab.setMessage("Invalid Username or Password "+ counter +" attempts left!");
        }
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ab.setCancelable(false);
        ab.create();
        ab.show();

    }
}