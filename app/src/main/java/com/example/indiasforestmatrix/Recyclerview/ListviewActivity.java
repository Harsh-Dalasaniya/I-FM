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
        POJO data2[] = {new POJO("Gir National Park", R.drawable.gir,"https://www.girnationalpark.in/book-gir-lion-safari.html")
                ,new POJO("Sunderbans National Park", R.drawable.sunderbans,"https://www.wbtourismgov.in/destination/place/sundarban")
                ,new POJO("Jim Corbett National Park", R.drawable.jimcorbett,"https://www.jimcorbettonlineuk.com/")
                ,new POJO("Ranthambore National Park", R.drawable.ranthambhor,"https://www.theranthamboresafari.com/")
                ,new POJO("Bannerghatta Biological Park", R.drawable.bannerghata,"https://www.thrillophilia.com/tours/bannerghatta-national-park-safari")
                ,new POJO("Kaziranga National Park", R.drawable.kaziranga,"https://www.kaziranganationalpark-india.com/online-kaziranga-safari-booking.html")
                ,new POJO("Periyar National Park", R.drawable.periyar,"https://thekkady.org/book-online/")
                ,new POJO("Bandhavgarh National Park", R.drawable.bandhavgarh,"http://bandhavgarh-national-park-mp-india.com/Tariff.aspx")
                ,new POJO("Hemis National Park", R.drawable.hemis,"https://www.altitudeadventureindia.com/category/chadar-trek/")
                ,new POJO("The Great Himalayan National Park", R.drawable.himalayan,"https://www.thrillophilia.com/tours/explore")
                ,new POJO("Tadoba", R.drawable.tadoba,"https://tadoba-national-park-booking.com/")
                ,new POJO("Nanda Devi", R.drawable.nandadevi,"https://www.yatra.com/hotels/adventure-hotels-near-nanda-devi-mandir-in-almora")
                ,new POJO("Khangchendzonga", R.drawable.khangchendzonga,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Panna National Park", R.drawable.panna,"https://www.yatra.com/hotels/adventure-hotels-in-panna")
                ,new POJO("Bera", R.drawable.bera,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Bhitarkanika National Park", R.drawable.bhitarkanika,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Jhalana Reserve Forest", R.drawable.jhalana,"https://en.wikipedia.org/wiki/Gir_National_Park")
                ,new POJO("Manas National Park", R.drawable.manas,"https://nexplore.org/destinations/Assam/manas-national-park.php")};

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
