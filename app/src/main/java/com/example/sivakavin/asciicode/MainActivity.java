package com.example.sivakavin.asciicode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView viewvalue, ViewNumber;
    EditText insertvalue, insertNumber;
    Button button, insernumber;
    RadioGroup radioGroup;
    RelativeLayout charTOnum, numTochar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CharTonum
        insertvalue = (EditText) findViewById(R.id.asciicode);
        viewvalue = (TextView) findViewById(R.id.output_Value);
        button = (Button) findViewById(R.id.insertValue);
        button.setOnClickListener(this);

        //numTochar
        insertNumber = (EditText) findViewById(R.id.asciinumber);
        ViewNumber = (TextView) findViewById(R.id.char_output);
        insernumber = (Button) findViewById(R.id.insertnumber);
        insernumber.setOnClickListener(this);


        charTOnum = (RelativeLayout) findViewById(R.id.char_todesimalpage);
        numTochar = (RelativeLayout) findViewById(R.id.number_tocharpage);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insertValue:
                try {
                    char value = insertvalue.getText().charAt(0);
                    viewvalue.setText("" + CharToNum(value));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Insert Valid Input", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.insertnumber:
                try {
                    String number = insertNumber.getText().toString();
                    int numbervalue = Integer.parseInt(number);
                    if (numbervalue > -1 && numbervalue < 256) {
                        ViewNumber.setText("" + NumTochar(numbervalue));
                    } else {
                        Toast.makeText(MainActivity.this, "Value Should be [1-255]", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Insert Valid Input", Toast.LENGTH_LONG).show();
                }

                break;
        }

    }

    private int CharToNum(char value) {
        return value;
    }

    private char NumTochar(int value) {
        return (char) value;
    }


    public void changeNumber(View view) {
        charTOnum.setVisibility(View.GONE);
        numTochar.setVisibility(View.VISIBLE);
    }

    public void changeChar(View view) {
        charTOnum.setVisibility(View.VISIBLE);
        numTochar.setVisibility(View.GONE);
    }
}
