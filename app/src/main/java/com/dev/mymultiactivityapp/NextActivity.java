package com.dev.mymultiactivityapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private EditText editText2;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.next_title);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView2 = (TextView) findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String v = bundle.getString(Util.KEY);
            textView2.setText(v);
        }

    }


    public void onBackPressed(View view){

    }
}
