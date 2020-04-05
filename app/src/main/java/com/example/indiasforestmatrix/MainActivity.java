
package com.example.indiasforestmatrix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.indiasforestmatrix.Model.common_responce;
import com.example.indiasforestmatrix.Network.API;
import com.example.indiasforestmatrix.Network.RestClient;

import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    API rescall;
    EditText etName;
    EditText etPass;
    String unsme,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        rescall =RestClient.createService(API.class);
        Button btnLogin = (Button) findViewById(R.id.loginbtn);
          etName = (EditText) findViewById(R.id.username);
          etPass = (EditText) findViewById(R.id.password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unsme= etName.getText().toString().trim();
                pass= etPass.getText().toString().trim();
                Adddata();
            }
        });


    }

    private void Adddata() {
        rescall.ADD_STUDENT("add_student",unsme,pass)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<common_responce>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(final Throwable e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onNext(final common_responce common_responce) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(common_responce.getStatus()==200)
                                {
                                    etName.setText("");
                                    etPass.setText("");
                                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });

    }

}
