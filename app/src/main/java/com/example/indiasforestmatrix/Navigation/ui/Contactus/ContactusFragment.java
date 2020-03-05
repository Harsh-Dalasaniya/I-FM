package com.example.indiasforestmatrix.Navigation.ui.Contactus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.indiasforestmatrix.R;

public class ContactusFragment extends Fragment {

    private ContactusViewModel contactusViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactusViewModel =
                ViewModelProviders.of(this).get(ContactusViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contactus, container, false);
       // final TextView textView = root.findViewById(R.id.nav_contactus);
        contactusViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
        //        textView.setText(s);
            }
        });
        return root;
    }
}