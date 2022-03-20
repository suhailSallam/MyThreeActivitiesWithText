package com.example.mythreeactivitieswithtext;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button2, button3;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //   Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();

        button2 = findViewById(R.id.buttonSecond);
        button3 = findViewById(R.id.buttonThird);
        textView = findViewById(R.id.textViewComingFrom);




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("coming_from_text", "First Page");
                intent.putExtra("i_am_in_txt", "Second Page");
                intent.putExtra("coming_from_int", 1);
                intent.putExtra("i_am_in_double", 2.0);

//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);

            }//end of onClick() button2
        }); //end of setOnClickListener() button2

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("coming_from_text", "First Page");
                intent.putExtra("i_am_in_txt", "Third Page");
                intent.putExtra("coming_from_int", 1);
                intent.putExtra("i_am_in_double", 3.0);
//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }//end of onClick() button3
        }); //end of setOnClickListener() button3
    }//end of onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returnData = data.getStringExtra("i_am_in_txt");
                //Toast.makeText(getApplicationContext(), returnData, Toast.LENGTH_LONG).show();
                textView.setText(returnData);
            }//end of inner if
        }//end of outer if
    }//end of onActivityResult()
}//end class