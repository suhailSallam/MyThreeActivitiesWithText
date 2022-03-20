package com.example.mythreeactivitieswithtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView ;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        textView = findViewById(R.id.textViewPage2);
        button = findViewById(R.id.back_Btn);

        String coming_from_text = extras.getString("coming_from_text");
        String i_am_in_txt = extras.getString("i_am_in_txt");
        int coming_from_int = extras.getInt("coming_from_int");
        double i_am_in_double = extras.getDouble("i_am_in_double");

        textView.setText("Coming from page: "+coming_from_text+"\n"
                +"I am in Page: "+i_am_in_txt+"\n"
                +"coming from page: "+coming_from_int+"\n"
                +"I am in page: "+i_am_in_double);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent  = getIntent();
                backIntent.putExtra("i_am_in_txt","I was in Page 2");
                setResult(RESULT_OK, backIntent);
                finish();
            }//end of onClick()
        }); //end of setOnClickListener()
    }//end of onCreate()
}//end class