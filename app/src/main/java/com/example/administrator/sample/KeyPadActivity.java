package com.example.administrator.sample;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

/**
 * Created by Administrator on 2016-04-12.
 */
public class KeyPadActivity extends Activity {
    EditText edit1;

    //키패드
    RelativeLayout keyPad1, keyPad2, keyPad3, keyPad4;
    //키패드1 버튼들
    ImageButton[] key1Button = new ImageButton[30];
    //키패드2 버튼들
    ImageButton[] key2Button = new ImageButton[30];
    //키패드3 버튼들
    ImageButton[] key3Button = new ImageButton[30];
    //키패드4 버튼들
    ImageButton[] key4Button = new ImageButton[30];
    //키패드 아이디
    Integer[] key1ButtonID = {
            R.id.key1Button1, R.id.key1Button2, R.id.key1Button3, R.id.key1Button4, R.id.key1Button5, R.id.key1Button6,
            R.id.key1Button7, R.id.key1Button8, R.id.key1Button9, R.id.key1Button10, R.id.key1Button11, R.id.key1Button12,
            R.id.key1Button13, R.id.key1Button14, R.id.key1Button15, R.id.key1Button16, R.id.key1Button17, R.id.key1Button18,
            R.id.key1Button19, R.id.key1Button20, R.id.key1Button21, R.id.key1Button22, R.id.key1Button23, R.id.key1Button24,
            R.id.key1Button25, R.id.key1Button26, R.id.key1Button27, R.id.key1Button28, R.id.key1Button29, R.id.key1Button30
    };

    Integer[] key2ButtonID = {
            R.id.key2Button1, R.id.key2Button2, R.id.key2Button3, R.id.key2Button4, R.id.key2Button5, R.id.key2Button6,
            R.id.key2Button7, R.id.key2Button8, R.id.key2Button9, R.id.key2Button10, R.id.key2Button11, R.id.key2Button12,
            R.id.key2Button13, R.id.key2Button14, R.id.key2Button15, R.id.key2Button16, R.id.key2Button17, R.id.key2Button18,
            R.id.key2Button19, R.id.key2Button20, R.id.key2Button21, R.id.key2Button22, R.id.key2Button23, R.id.key2Button24,
            R.id.key2Button25, R.id.key2Button26, R.id.key2Button27, R.id.key2Button28, R.id.key2Button29, R.id.key2Button30
    };

    Integer[] key3ButtonID = {
            R.id.key3Button1, R.id.key3Button2, R.id.key3Button3, R.id.key3Button4, R.id.key3Button5, R.id.key3Button6,
            R.id.key3Button7, R.id.key3Button8, R.id.key3Button9, R.id.key3Button10, R.id.key3Button11, R.id.key3Button12,
            R.id.key3Button13, R.id.key3Button14, R.id.key3Button15, R.id.key3Button16, R.id.key3Button17, R.id.key3Button18,
            R.id.key3Button19, R.id.key3Button20, R.id.key3Button21, R.id.key3Button22, R.id.key3Button23, R.id.key3Button24,
            R.id.key3Button25, R.id.key3Button26, R.id.key3Button27, R.id.key3Button28, R.id.key3Button29, R.id.key3Button30
    };

    Integer[] key4ButtonID = {
            R.id.key4Button1, R.id.key4Button2, R.id.key4Button3, R.id.key4Button4, R.id.key4Button5, R.id.key4Button6,
            R.id.key4Button7, R.id.key4Button8, R.id.key4Button9, R.id.key4Button10, R.id.key4Button11, R.id.key4Button12,
            R.id.key4Button13, R.id.key4Button14, R.id.key4Button15, R.id.key4Button16, R.id.key4Button17, R.id.key4Button18,
            R.id.key4Button19, R.id.key4Button20, R.id.key4Button21, R.id.key4Button22, R.id.key4Button23, R.id.key4Button24,
            R.id.key4Button25, R.id.key4Button26, R.id.key4Button27, R.id.key4Button28, R.id.key4Button29, R.id.key4Button30
    };

    int i;

    String result;

    WebView webTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keypad);


        //레이아웃 아이디 얻어오기
        edit1 = (EditText) findViewById(R.id.edit1);

        keyPad1 = (RelativeLayout) findViewById(R.id.keyPad1);
        keyPad2 = (RelativeLayout) findViewById(R.id.keyPad2);
        keyPad3 = (RelativeLayout) findViewById(R.id.keyPad3);
        keyPad4 = (RelativeLayout) findViewById(R.id.keyPad4);

//        webTv = (WebView) findViewById(R.id.webTv);

        for (i = 0; i < key1ButtonID.length; i++) {
            key1Button[i] = (ImageButton) findViewById(key1ButtonID[i]);
            key2Button[i] = (ImageButton) findViewById(key2ButtonID[i]);
            key3Button[i] = (ImageButton) findViewById(key3ButtonID[i]);
            key4Button[i] = (ImageButton) findViewById(key4ButtonID[i]);

        }

        //1번째 키패드 리스너
        key1Button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += " ";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "";
                edit1.setText(result);
                edit1.setSelection(edit1.length());

            }
        });
        key1Button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                if(result.equals("")) return;
                result = result.substring(0, result.length()-1);
                edit1.setText(result);
                edit1.setSelection(edit1.length());

            }
        });
        key1Button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "(";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += ")";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "+";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.VISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);

            }
        });
        key1Button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "%";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "7";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "8";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "9";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "-";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.VISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);

            }
        });
        key1Button[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "x^y";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "4";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "5";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "6";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "*";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.VISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });
        key1Button[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "√";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "1";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "2";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "3";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "/";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.VISIBLE);
            }
        });
        key1Button[25].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "!";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[26].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "0";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[27].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += ".";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key1Button[28].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        key1Button[29].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 2번째 키패드 리스너
        key2Button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += " ";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key2Button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "";
                edit1.setText(result);
                edit1.setSelection(edit1.length());

            }
        });
        key2Button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                if(result.equals("")) return;
                result = result.substring(0, result.length()-1);
                edit1.setText(result);
                edit1.setSelection(edit1.length());

            }
        });
        key2Button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "(";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key2Button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += ")";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key2Button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = edit1.getText().toString();
                result += "+";
                edit1.setText(result);
                edit1.setSelection(edit1.length());
            }
        });
        key2Button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.VISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key2Button[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.VISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key2Button[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.VISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key2Button[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.VISIBLE);

            }
        });
        //3번째 키패드 리스너
        key3Button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.VISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key3Button[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.VISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key3Button[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.VISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key3Button[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.VISIBLE);

            }
        });

        //키패드 4번째 리스너

        key4Button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.VISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key4Button[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.VISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);

            }
        });

        key4Button[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.VISIBLE);
                keyPad4.setVisibility(View.INVISIBLE);
            }
        });

        key4Button[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPad1.setVisibility(View.INVISIBLE);
                keyPad2.setVisibility(View.INVISIBLE);
                keyPad3.setVisibility(View.INVISIBLE);
                keyPad4.setVisibility(View.VISIBLE);

            }
        });

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //키보드 감추기
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edit1.getWindowToken(), 0);
            }
        });

//        webTv.loadUrl("http://113.198.80.233:80/PS/results");




    }

}
