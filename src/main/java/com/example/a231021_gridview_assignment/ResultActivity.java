package com.example.a231021_gridview_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends MainActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar ratingBar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rtBar1, R.id.rtBar2, R.id.rtBar3, R.id.rtBar4, R.id.rtBar5, R.id.rtBar6, R.id.rtBar7, R.id.rtBar8, R.id.rtBar9};

        for (int i=0; i<voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            ratingBar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for (int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            ratingBar[i].setRating((float) voteResult[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


