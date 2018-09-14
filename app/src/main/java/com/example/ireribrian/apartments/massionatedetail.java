package com.example.ireribrian.apartments;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import java.util.Arrays;

public class massionatedetail extends AppCompatActivity implements RatingDialogListener{

    TextView massionate_name, massionate_price, massionate_details;
    ImageView massionate_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart, btnRate;
    ElegantNumberButton numberButton;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massionatedetail);


        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);
        btnRate = (FloatingActionButton) findViewById(R.id.btnRating);
        ratingBar = (RatingBar) findViewById(R.id.RatingBar);


        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRatingDialog();
            }
        });


        massionate_name = (TextView) findViewById(R.id.massdesc);
        massionate_price = (TextView) findViewById(R.id.massprice);
        massionate_details = (TextView) findViewById(R.id.massdetails);

        massionate_image = (ImageView) findViewById(R.id.massimage);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);


    }

    private void showRatingDialog() {
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNoteDescriptions(Arrays.asList("Very Bad", "Bad", "Quite Good", "Excellent", "Superb" ))
                .setDefaultRating(1)
                .setTitle("Rate this house")
                .setDescription("Please select some stars and give your feddback")
                .setTitleTextColor(R.color.colorPrimary)
                .setDescriptionTextColor(R.color.colorPrimary)
                .setHint("Please write your comment here...")
                .setHintTextColor(R.color.colorAccent)
                .setCommentTextColor(R.color.black)
                .setCommentBackgroundColor(R.color.colorPrimary)
                .setWindowAnimation(R.style.RatingDialogFadeAnim)
                .create(massionatedetail.this)
                .show();
    }


    @Override
    public void onNegativeButtonClicked() {
        Toast.makeText(massionatedetail.this, "Thanks", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPositiveButtonClicked(int i, String s) {
        Toast.makeText(massionatedetail.this, "Thanks", Toast.LENGTH_SHORT).show();

    }
}
