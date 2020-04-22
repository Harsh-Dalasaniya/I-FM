package com.example.indiasforestmatrix.Navigation.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.indiasforestmatrix.Content.FAQsActivity;
import com.example.indiasforestmatrix.Content.ImagesActivity;
import com.example.indiasforestmatrix.Content.Infoacti;
import com.example.indiasforestmatrix.Content.NewsActivity;
import com.example.indiasforestmatrix.GoogleMap.MapsActivity;
import com.example.indiasforestmatrix.Recyclerview.ListviewActivity;
import com.example.indiasforestmatrix.R;

public class HomeFragment extends Fragment {
    CardView Forestplaces,Map,Activities,News,Images,FAQs;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Forestplaces = (CardView) root.findViewById(R.id.forestplaces);
        Activities = (CardView) root.findViewById(R.id.infoacti);
        Map = (CardView) root.findViewById(R.id.map);
        News = (CardView) root.findViewById(R.id.news);
        Images = (CardView) root.findViewById(R.id.images);
        FAQs = (CardView) root.findViewById(R.id.FAQs);

       // final TextView textView = root.findViewById(R.id.nav_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
       //         textView.setText(s);
            }
        });

        Forestplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Forestplaces = new Intent(getActivity(), ListviewActivity.class);
                startActivity(Forestplaces);
            }
        });

        Activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CardView title = (CardView) view.findViewById(R.id.infoacti);
                final String website = "https://en.wikipedia.org/wiki/Gir_National_Park";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent News = new Intent(getActivity(),NewsActivity.class);
                startActivity(News);
            }
        });

        Images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Images = new Intent(getActivity(),ImagesActivity.class);
                startActivity(Images);
            }
        });

        FAQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FAQs = new Intent(getActivity(),FAQsActivity.class);
                startActivity(FAQs);
            }
        });

        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Map = new Intent(getActivity(), MapsActivity.class);
                startActivity(Map);
            }
        });

        return root;
    }

}

