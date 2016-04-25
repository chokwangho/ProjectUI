package com.example.administrator.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-04-12.
 */
public class KeyPadActivity extends Activity{
    EditText edit1;
    Button btnIntegral;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keypad);

                edit1 = (EditText) findViewById(R.id.edit1);


        btnIntegral = (Button) findViewById(R.id.btnIntegral);

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edit1.getWindowToken(), 0);
            }
        });


                btnIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString() + "∫";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
    }

}
