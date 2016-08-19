package com.example.sivakavin.asciicode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView viewvalue;
    EditText insertvalue;
    Button button;
    RadioGroup radioGroup;
    RelativeLayout charTOnum,numTochar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertvalue= (EditText) findViewById(R.id.asciicode);
        viewvalue= (TextView) findViewById(R.id.output_Value);
        button= (Button) findViewById(R.id.insertValue);
        button.setOnClickListener(this);

        charTOnum= (RelativeLayout) findViewById(R.id.char_todesimalpage);
        numTochar= (RelativeLayout) findViewById(R.id.number_tocharpage);

    }

    @Override
    public void onClick(View view) {
        char value=insertvalue.getText().charAt(0);
        viewvalue.setText(""+CharToNum(value));
    }

    private int CharToNum(char value) {
        return value;
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
