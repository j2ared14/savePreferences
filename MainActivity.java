package com.example.jared.savepreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView count = (TextView) findViewById(R.id.numberCount);
        SharedPreferences share = getSharedPreferences("count", 0);
        int theCount = share.getInt("count", 0);
        String theCountString = Integer.toString(theCount);
        count.setText(theCountString);
    }

    public void onClickSave (View v) {
        TextView count = (TextView) findViewById(R.id.numberCount);
        SharedPreferences sp = getSharedPreferences("count", 0);
        SharedPreferences.Editor editer = sp.edit();
        int theCount = Integer.parseInt(count.getText().toString());
        editer.putInt("count", theCount);
        editer.commit();
    }

    public void onClickAdvance (View v) {
        TextView count = (TextView) findViewById(R.id.numberCount);
        int ourCount = Integer.parseInt(count.getText().toString());
        ourCount++;
        String ourCountString = Integer.toString(ourCount);
        count.setText(ourCountString);
    }
}
