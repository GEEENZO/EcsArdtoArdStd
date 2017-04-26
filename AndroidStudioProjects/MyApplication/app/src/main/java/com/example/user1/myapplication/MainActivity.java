package com.example.user1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView txv;
    EditText etx;
    Button btn;
    int befkey = R.id.button_equal;
    double result;
    boolean isRememberPushed;

    double calc(int opt,double value1,double value2){
        switch(opt){
            case R.id.button_add:
                return  value1+value2;
            case R.id.button_subtract:
                return  value1 - value2;
            case R.id.button_multiply:
                return value1 * value2;
            case R.id.button_divide:
                return value1 / value2;
            default:
                return value1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView)findViewById(R.id.textview1);
        txv.setText("=======TEXTVIEW=================");
        String str = String.valueOf(33);
        int i = Integer.parseInt("13");

        int a = 1;
        int b = 3;
        float c =  (float) a/b;

        etx = (EditText)findViewById(R.id.edittext);
        etx.setText("ここでテキストをエディット！");

        String getedit = etx.getText().toString();
        Log.e("EditOn: ",getedit);

        //Toast tst = (Toast)
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                txv.setText(etx.getText().toString());
            }
        });

        //上下のButtonキャスト・リスナー記述方法は同じ意味を持つ

        View.OnClickListener buttonNumListener = new View.OnClickListener(){
            public void onClick(View view){
                Button button = (Button)view;
                //etx.append(button.getText());
                //etx.setText(button.getText());

                if(isRememberPushed == true){
                    etx.setText(button.getText());
                }
                else{
                    etx.append(button.getText());
                }
                isRememberPushed = false;
            }
        };

        findViewById(R.id.button_1).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_2).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_3).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_4).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_5).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_6).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_7).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_8).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_9).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_0).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_dot).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_divide).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_multiply).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_subtract).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_add).setOnClickListener(buttonNumListener);
        findViewById(R.id.button_equal).setOnClickListener(buttonNumListener);


        View.OnClickListener optButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button pushbtn = (Button)view;
                double value = Double.parseDouble(etx.getText().toString());
                if(befkey == R.id.button_equal){
                    result = value;
                }
                else{
                    result = calc(befkey,result,value);
                }

                befkey = pushbtn.getId();
                txv.setText(pushbtn.getText());
                isRememberPushed = true;
            }
        };
    }
}
