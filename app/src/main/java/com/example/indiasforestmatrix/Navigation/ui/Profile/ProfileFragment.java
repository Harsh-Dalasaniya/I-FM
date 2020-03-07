package com.example.indiasforestmatrix.Navigation.ui.Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.indiasforestmatrix.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    EditText Username,Email,Contact,City,Address;
    RadioGroup radioButton;
    Button submit;
    CircleImageView imageView;


    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
       // final TextView textView = root.findViewById(R.id.nav_profile);
        profileViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
           //     textView.setText(s);
            }
        });

        Username = (EditText) root.findViewById(R.id.PU1);
        Email = (EditText) root.findViewById(R.id.PE1);
        Contact = (EditText) root.findViewById(R.id.PC1);
        City = (EditText) root.findViewById(R.id.PC2);
        Address = (EditText) root.findViewById(R.id.PA1);
        submit = (Button) root.findViewById(R.id.PBS1);
        imageView=(CircleImageView)root.findViewById(R.id.pre_dp);

        submit.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {
                Intent Edit = new Intent(getActivity(),ProfileFragment.class);
                startActivity(Edit);
            }
        });

        return root;
    }

}