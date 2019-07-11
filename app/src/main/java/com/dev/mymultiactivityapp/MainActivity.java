package com.dev.mymultiactivityapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.main_title);

        editText1 = (EditText) findViewById(R.id.editText1);
        textView1 = (TextView) findViewById(R.id.textView1);

    }

    public void onBtnPressed(View view){
        Intent intent = new Intent(this,NextActivity.class);
        intent.putExtra(Util.KEY,editText1.getText().toString());
        startActivityForResult(intent,Util.REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Util.REQ_CODE){
            if (resultCode == Util.RES_CODE){
                Bundle bundle = data.getExtras();
                if (bundle != null){
                    textView1.setText(bundle.getString(Util.BACK_KEY));
                }
            }
        }

    }
}
