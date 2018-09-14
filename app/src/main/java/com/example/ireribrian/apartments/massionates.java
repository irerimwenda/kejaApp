package com.example.ireribrian.apartments;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class massionates extends AppCompatActivity {



    int [] IMAGES = {R.drawable.mans1, R.drawable.mans2, R.drawable.mans6, R.drawable.mans4, R.drawable.mans5, R.drawable.mans6};

    String [] DESCRIPTION = {"Rock Villa", "Don Palace", "Membley Spring", "Hilton Villa", "Lake Palace", "Membley Spring", "Hilton Villa"};

    String [] LOCATION = {"Kileleshwa", "Karen", "Membley Estate", "Kileleshwa", "Karen", "Membley Estate", "Membley Estate"};

    String [] PRICE = {"Ksh 5 million", "Ksh 3 million", "Ksh 8 million", "Ksh 5 million", "Ksh 3 million", "Ksh 8 million", "Ksh 3 million"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massionates);

        ListView massionates = (ListView) findViewById(R.id.massionatelist);

        CustomAdapterMassionate customAdapter = new CustomAdapterMassionate();
        massionates.setAdapter(customAdapter);

        massionates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Intent intent = new Intent(massionates.this, massionatedetail.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(massionates.this, massionatedetail.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(massionates.this, massionatedetail.class);
                    startActivity(intent);
                }
            }



        });

    }


    class CustomAdapterMassionate extends BaseAdapter {

        @Override
        public int getCount() {
            return  IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.massionateview, null);



            ImageView imageview =(ImageView) view.findViewById(R.id.massimage);
            TextView desctext = (TextView) view.findViewById(R.id.massdesc);
            TextView locationtext = (TextView) view.findViewById(R.id.massloc);
            TextView pricetext = (TextView) view.findViewById(R.id.massprice);

            imageview.setImageResource(IMAGES[i]);
            desctext.setText(DESCRIPTION[i]);
            locationtext.setText(LOCATION[i]);
            pricetext.setText(PRICE[i]);
            return view;

        }
    }
}
