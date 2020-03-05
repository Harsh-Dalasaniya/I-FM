package com.example.indiasforestmatrix.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indiasforestmatrix.Navigation.Navigationdrawer;
import com.example.indiasforestmatrix.R;

public class Loginactivity extends AppCompatActivity {
    EditText Username;
    EditText Password;
    Button Login;
    Button Signup;
    TextView Register;
    TextView Forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.loginbtn);
        Register = (TextView) findViewById(R.id.textview_register);
        Forgotpassword = (TextView) findViewById(R.id.forgot_password);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Loginscreen = new Intent(Loginactivity.this, com.example.indiasforestmatrix.Login.Signup.class);
                startActivity(Loginscreen);
            }
        });
        Forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Loginscreen = new Intent(Loginactivity.this, Forgotpassword.class);
                startActivity(Loginscreen);
            }
        });
    }

    public void login(View view) {

        String d=Username.getText().toString();

        if (Username.length()==0)
        {
            Username.requestFocus();
            Username.setError("Filled can not be empty");
        }
        else if (d.matches("[a-zA-Z ]"+""))
        {
            Username.requestFocus();
            Username.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        else if (Username.length() == 0)
        {
            Username.requestFocus();
            Username.setError("FIELD CANNOT BE EMPTY");
        }
        else
            {
            Toast.makeText(Loginactivity.this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent Loginscreen = new Intent(Loginactivity.this, Navigationdrawer.class);
            startActivity(Loginscreen);
            }
        if (TextUtils.isEmpty(Password.getText()))
        {
            Password.setError("Please enter password");
            Password.requestFocus();
        }
        else
        {
            String a= Password.getText().toString();
            Password.setText(a);
        }
    }
}
