package com.example.indiasforestmatrix.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.indiasforestmatrix.Content.FAQsActivity;
import com.example.indiasforestmatrix.Content.ImagesActivity;
import com.example.indiasforestmatrix.Content.Infoacti;
import com.example.indiasforestmatrix.Content.NewsActivity;
import com.example.indiasforestmatrix.Content.Places;
import com.example.indiasforestmatrix.R;

public class Dashboard extends AppCompatActivity {

    CardView Forestplaces,Map,Acti,News,Images,FAQs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Forestplaces = (CardView) findViewById(R.id.forestplaces);
        Acti = (CardView) findViewById(R.id.activities);
        Map = (CardView) findViewById(R.id.map);
        News = (CardView) findViewById(R.id.news);
        Images = (CardView) findViewById(R.id.images);
        FAQs = (CardView) findViewById(R.id.FAQs);

    }

    public void ForestPlaces(View view) {
        Intent Forestplaces = new Intent(Dashboard.this, Places.class);
        startActivity(Forestplaces);
    }

    public void News(View view) {
        Intent News = new Intent(Dashboard.this, NewsActivity.class);
        startActivity(News);
    }

    public void Images(View view) {
        Intent Images = new Intent(Dashboard.this, ImagesActivity.class);
        startActivity(Images);
    }

    public void FAQs(View view) {
        Intent FAQs = new Intent(Dashboard.this,FAQsActivity.class);
        startActivity(FAQs);
    }

    public void infoacti(View view) {
        Intent Activities = new Intent(Dashboard.this,Infoacti.class);
        startActivity(Activities);
    }
}
