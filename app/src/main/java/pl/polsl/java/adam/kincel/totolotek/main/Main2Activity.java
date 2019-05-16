package pl.polsl.java.adam.kincel.totolotek.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import pl.polsl.java.adam.kincel.totolotek.R;
import pl.polsl.java.adam.kincel.totolotek.model.*;

import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        Totolotek totolotek = (Totolotek)i.getSerializableExtra("obj"); //get model from first activity
        TextView t1 = (TextView) findViewById(R.id.textView6);
        TextView t2 =  (TextView) findViewById(R.id.textView7);
        TextView t3 =  (TextView) findViewById(R.id.textView8);
        totolotek.drawing();
        t1.setText(Arrays.toString(totolotek.getUserArray()));
        t2.setText((totolotek.getDrawnArray().toString()));
        t3.setText(Integer.toString(totolotek.getPoints()));
    }
}