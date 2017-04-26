package com.example.user1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.TextView;
//import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txv = (TextView)findViewById(R.id.textview1);
        txv.setText("=======TEXTVIEW=================");
        String str = String.valueOf(33);
        int i = Integer.parseInt("13");

        int a = 1;
        int b = 3;
        float c =  (float) a/b;

         EditText etx = (EditText)findViewById(R.id.edittext);
        etx.setText("ここでテキストをエディット！");

        final String getedit = etx.getText().toString();
        Log.e("EditOn: ",getedit);

        //Toast tst = (Toast)
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                txv.setText(getedit);//etx.getText().toString());
            }
        });


    }
}
