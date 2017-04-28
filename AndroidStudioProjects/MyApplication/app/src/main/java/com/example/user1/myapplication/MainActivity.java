package com.example.user1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txv;
    EditText etx;
    Button btn;
    int befkey = R.id.button_equal;
    double result = 0;
    boolean isRememberPushed;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txv.setText(etx.getText().toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView)findViewById(R.id.textview1);
        etx = (EditText)findViewById(R.id.edittext);
        //etx.setText("ここでテキストをエディット！");

        //String getedit = etx.getText().toString();
        //Log.e("EditOn: ",getedit);

        btn = (Button)findViewById(R.id.button);
        //btn.setOnClickListener(new View.OnClickListener(){
        //    public void onClick(View view){
        //        txv.setText(etx.getText().toString());
        //    }
        //});
        btn.setOnClickListener(buttonListener);

        //上下のButtonキャスト・リスナー記述方法は同じ意味を持つ

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

        findViewById(R.id.button_divide).setOnClickListener(optButtonListener);
        findViewById(R.id.button_multiply).setOnClickListener(optButtonListener);
        findViewById(R.id.button_subtract).setOnClickListener(optButtonListener);
        findViewById(R.id.button_add).setOnClickListener(optButtonListener);
        findViewById(R.id.button_equal).setOnClickListener(optButtonListener);

        findViewById(R.id.button_clear).setOnClickListener(clearButtonListener);
    }

    private void toastset(String result){
        Toast toast = Toast.makeText(this,result,Toast.LENGTH_SHORT);
        toast.show();
    }


    View.OnClickListener optButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button optbtn = (Button)view;
            double value = Double.parseDouble(etx.getText().toString());
            if(befkey == R.id.button_equal){
                result = value;
            }
            else{
                result = calc(befkey,result,value);
                etx.setText(String.valueOf(result));

                toastset(String.valueOf(result));

                //toast = Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
            }

            befkey = optbtn.getId();
            txv.setText(optbtn.getText());
            isRememberPushed = true;
        }
    };

    View.OnClickListener clearButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            befkey = R.id.button_equal;
            result = 0;
            isRememberPushed = false;

            txv.setText("");
            etx.setText("");
        }
    };

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

}
