package com.example.indiasforestmatrix.Navigation.ui.Customerreview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.indiasforestmatrix.R;

public class CustomerreviewFragment extends Fragment {

    private RatingBar ratingBar;
    private TextView tvRateCount,tvRateMessage;
    private float ratedValue;
    Button submit;

    private CustomerreviewViewModel customerreviewViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        customerreviewViewModel = ViewModelProviders.of(this).get(CustomerreviewViewModel.class);
        View root = inflater.inflate(R.layout.fragment_customerreview, container, false);


        ratingBar = (RatingBar) root.findViewById(R.id.ratingBar);
        tvRateCount = (TextView) root.findViewById(R.id.tvRateCount);
        tvRateMessage = (TextView) root.findViewById(R.id.tvRateMessage);
        submit=(Button)root.findViewById(R.id.submit);

      //  final TextView textView = root.findViewById(R.id.nav_customerreview);
        customerreviewViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override

            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ratedValue = ratingBar.getRating();
                tvRateCount.setText("Your Rating : " + ratedValue + "/5.");

                if(ratedValue<1){

                    tvRateMessage.setText("ohh ho...");

                }else if(ratedValue<2){

                    tvRateMessage.setText("Ok.");

                }else if(ratedValue<3){

                    tvRateMessage.setText("Not bad.");

                }else if(ratedValue<4){

                    tvRateMessage.setText("Nice");

                }else if(ratedValue<5){

                    tvRateMessage.setText("Very Nice");

                }else if(ratedValue==5){

                    tvRateMessage.setText("Thank you..!!!");

                }

            }

        });

        return root;
    }

}