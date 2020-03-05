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

import com.example.indiasforestmatrix.Home.Dashboard;
import com.example.indiasforestmatrix.Navigation.Navigationdrawer;
import com.example.indiasforestmatrix.R;

public class Signup extends AppCompatActivity {
    EditText Name;
    EditText Email;
    EditText Password;
    Button CreateAccount;
    TextView Forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.password);
        CreateAccount=(Button)findViewById(R.id.create_account);
        Forgotpassword=(TextView)findViewById(R.id.forgot_password);

        Forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Signup = new Intent(Signup.this,Forgotpassword.class);
                startActivity(Signup);
            }
        });
    }

    public void createaccount(View view) {

        String d=Name.getText().toString();

        if (Name.length()==0)
        {
            Name.requestFocus();
            Name.setError("Filled can not be empty");
        }
        else if (d.matches("[a-zA-Z ]"+""))
        {
            Name.requestFocus();
            Name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        else if (Name.length() == 0)
        {
            Name.requestFocus();
            Name.setError("FIELD CANNOT BE EMPTY");
        }
        else
        {
            Toast.makeText(Signup.this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent Loginscreen = new Intent(Signup.this, Navigationdrawer.class);
            startActivity(Loginscreen);
        }

        if (TextUtils.isEmpty(Email.getText()))
        {
            Email.setError("Please enter Email");
            Email.requestFocus();
        }
        else
        {
            String a= Email.getText().toString();
            Password.setText(a);
        }
        if (TextUtils.isEmpty(Password.getText()))
        {
            Password.setError("Please enter passwoed");
            Password.requestFocus();
        }
        else
        {
            String a= Password.getText().toString();
            Name.setText(a);
        }

    }
}

