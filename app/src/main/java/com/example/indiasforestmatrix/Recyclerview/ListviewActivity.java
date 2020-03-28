package com.example.indiasforestmatrix.Recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.indiasforestmatrix.R;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class ListviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<POJO> li;
    private static adapter adapterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        li = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.list_recycle);
        POJO data2[] = {new POJO("Gir National Park", R.drawable.gir,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Sunderbans National Park", R.drawable.sunderbans,"https://en.wikipedia.org/wiki/Sundarbans_National_Park")
                ,new POJO("Jim Corbett National Park", R.drawable.jimcorbett,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Ranthambore National Park", R.drawable.ranthambhor,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Bannerghatta Biological Park", R.drawable.bannerghata,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Kaziranga National Park", R.drawable.kaziranga,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Periyar National Park", R.drawable.periyar,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Bandhavgarh National Park", R.drawable.bandhavgarh,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Hemis National Park", R.drawable.hemis,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("The Great Himalayan National Park", R.drawable.himalayan,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Tadoba", R.drawable.tadoba,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Nanda Devi", R.drawable.nandadevi,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Khangchendzonga", R.drawable.khangchendzonga,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Panna National Park", R.drawable.panna,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Bera", R.drawable.bera,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Bhitarkanika National Park", R.drawable.bhitarkanika,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Jhalana Reserve Forest", R.drawable.jhalana,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Manas National Park", R.drawable.manas,"https://en.wikipedia.org/wiki/Gir_National_Park")};

        for (int i = 0; i < data2.length; i++) {
            li.add(data2[i]);
            Log.d("CREATETEST23", li.toString());
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Adapterr ada = new Adapterr(li, this);
        ada.setItemClickListener((v, position) -> {
            POJO data = li.get(position);
            Toast.makeText(getApplicationContext(), data.getWEB(), Toast.LENGTH_LONG ).show();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(data.getWEB()));
            startActivity(i);

        });
        recyclerView.setAdapter(ada);


    }
    public CardView title;
    public void RedirectLink(View view)
    {
        title = (androidx.cardview.widget.CardView) view.findViewById(R.id.C1);


        final String website = "https://en.wikipedia.org/wiki/Gir_National_Park";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
}
