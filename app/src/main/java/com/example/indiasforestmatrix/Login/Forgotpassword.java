package com.example.indiasforestmatrix.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.indiasforestmatrix.R;

public class Forgotpassword extends AppCompatActivity {

    EditText Mobilenumber;
    Button GenerateOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        Mobilenumber = (EditText) findViewById(R.id.mobile_number);
        GenerateOTP = (Button) findViewById(R.id.btn_generateotp);

    }

    public void forgot(View view) {

        String d=Mobilenumber.getText().toString();

        if (Mobilenumber.length()==0)
        {
            Mobilenumber.requestFocus();
            Mobilenumber.setError("Please enter the mobile number ");
        }
        else if (d.matches("[0-9]"+""))
        {
            Mobilenumber.requestFocus();
            Mobilenumber.setError("ENTER ONLY MOBILE NUMBER");
        }
        else if (Mobilenumber.length() == 0)
        {
            Mobilenumber.requestFocus();
            Mobilenumber.setError("FIELD CANNOT BE EMPTY");
        }
        else
        {
            Intent fg = new Intent(Forgotpassword.this, OTP.class);
            startActivity(fg);
        }
    }
}
