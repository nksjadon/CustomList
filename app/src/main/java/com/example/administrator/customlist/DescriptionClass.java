package com.example.administrator.customlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 10/16/2015.
 */
public class DescriptionClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_view);
        TextView textView = (TextView) findViewById(R.id.myTitle);
        TextView textView1 =(TextView)findViewById(R.id.myDesc);

        Intent intent = getIntent();


        String stringData = intent.getStringExtra("title");
        String descString = intent.getStringExtra("desc");
        textView1.setText(descString);
        textView.setText(stringData);
    }
}
