package com.example.indiasforestmatrix.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.indiasforestmatrix.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<POJO> li;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        li = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.list_recycle);
        POJO data2[] = {new POJO("Gir National Park", R.drawable.gir)
                ,new POJO("Sunderbans National Park", R.drawable.sunderbans)
                ,new POJO("Jim Corbett National Park", R.drawable.jimcorbett)
                ,new POJO("Ranthambore National Park", R.drawable.ranthambhor)
                ,new POJO("Bannerghatta Biological Park", R.drawable.bannerghata)
                ,new POJO("Kaziranga National Park", R.drawable.kaziranga)
                ,new POJO("Periyar National Park", R.drawable.periyar)
                ,new POJO("Bandhavgarh National Park", R.drawable.bandhavgarh)
                ,new POJO("Hemis National Park", R.drawable.hemis)
                ,new POJO("The Great Himalayan National Park", R.drawable.himalayan)
                ,new POJO("Tadoba", R.drawable.tadoba)
                ,new POJO("Nanda Devi", R.drawable.nandadevi)
                ,new POJO("Khangchendzonga", R.drawable.khangchendzonga)
                ,new POJO("Panna National Park", R.drawable.panna)
                ,new POJO("Bera", R.drawable.bera)
                ,new POJO("Bhitarkanika National Park", R.drawable.bhitarkanika)
                ,new POJO("Jhalana Reserve Forest", R.drawable.jhalana)
                ,new POJO("Manas National Park", R.drawable.manas)};


        for (int i = 0; i < data2.length; i++) {
            li.add(data2[i]);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Adapterr ada = new Adapterr(li,this);
        recyclerView.setAdapter(ada);


    }


}
