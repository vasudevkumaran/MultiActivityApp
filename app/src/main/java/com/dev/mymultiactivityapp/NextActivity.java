package com.dev.mymultiactivityapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity implements MyInterface{

    private EditText editText2;
    private TextView textView2;

    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private  MyInterface myInterface = new MyInterface() {
        @Override
        public void aFunctionFromInterface() {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.next_title);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView2 = (TextView) findViewById(R.id.textView2);
        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editText2.getText().toString().equals("")){

                    Intent intent = new Intent();
                    intent.putExtra(Util.BACK_KEY,editText2.getText().toString());
                    setResult(Util.RES_CODE,intent);
                    finish();

                }else{
                    Toast.makeText(NextActivity.this,"Please enter some text",Toast.LENGTH_LONG).show();
                }


            }
        });


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String v = bundle.getString(Util.KEY);
            textView2.setText(v);
        }

    }


    @Override
    public void aFunctionFromInterface() {
        this.textView2.setText("any value");

        Toast.makeText(this,"Button pressed",Toast.LENGTH_LONG).show();
    }
}
