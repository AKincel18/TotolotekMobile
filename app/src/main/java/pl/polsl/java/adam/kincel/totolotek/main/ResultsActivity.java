package pl.polsl.java.adam.kincel.totolotek.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import pl.polsl.java.adam.kincel.totolotek.R;
import pl.polsl.java.adam.kincel.totolotek.model.*;
import pl.polsl.java.adam.kincel.totolotek.util.Util;

import android.widget.TextView;
import java.util.Arrays;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);
        Intent i = getIntent();
        Totolotek totolotek = (Totolotek)i.getSerializableExtra("model"); //get model from first activity
        TextView userNumbersTxt = (TextView) findViewById(R.id.userNumbers);
        TextView drawnNumbersTxt =  (TextView) findViewById(R.id.drawnNumbers);
        TextView pointsTxt =  (TextView) findViewById(R.id.points);
        totolotek.drawing();
        userNumbersTxt.setText(Util.removeFirstAndLast(Arrays.toString(totolotek.getUserArray())));
        drawnNumbersTxt.setText(Util.removeFirstAndLast(totolotek.getDrawnArray().toString()));
        pointsTxt.setText(Integer.toString(totolotek.getPoints()));
    }
}

