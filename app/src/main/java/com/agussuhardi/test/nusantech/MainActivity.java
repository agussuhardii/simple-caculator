package com.agussuhardi.test.nusantech;

import android.os.Bundle;
import android.widget.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

//    private final String plus = "plus";
//    private final String minus = "minus";
//    private final String x = "x";
//    private final String divide = "divide";

    private EditText edit1, edit2, edit3;

    private CheckBox chk1, chk2, chk3;

    private TextView result;

    private Button btnPlus, btnMinus, btnX, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.connect();

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });


    }

    private void calculate(String operator) {

        int txt1 = 0, txt2 = 0, txt3 = 0;
        List<Integer> data = new ArrayList<>();


        if (validateInput(edit1, chk1) != null) {
            txt1 = Integer.parseInt(Objects.requireNonNull(validateInput(edit1, chk1)));
            data.add(txt1);
        }
        if (validateInput(edit2, chk2) != null) {
            txt2 = Integer.parseInt(Objects.requireNonNull(validateInput(edit2, chk2)));
            data.add(txt2);
        }
        if (validateInput(edit3, chk3) != null) {
            txt3 = Integer.parseInt(Objects.requireNonNull(validateInput(edit3, chk3)));
            data.add(txt3);
        }

        if (data.size() <= 1) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            return;
        }


        this.result.setText(String.valueOf(calculate(data, operator)));
    }


    private int calculate(List<Integer> data, String operator) {

        int res = 0;

        for (int i : data) {
            if (res == 0)
                res = i;
            else {

                switch (operator) {
                    case "+": {
                        res = res + i;
                        break;
                    }
                    case "-": {
                        res = res - i;
                        break;
                    }
                    case "*": {
                        res = res * i;
                        break;
                    }
                    case "/": {
                        res = res / i;
                        break;
                    }
                }


            }
        }

        return res;
    }


    private String validateInput(EditText editText, CheckBox checkBox) {
        if (!checkBox.isChecked()) return null;
        if (editText.getText() == null) return null;
        if (editText.getText().toString().matches("0")) return null;
        if (editText.getText().toString().matches("")) return null;
        return editText.getText().toString();
    }


    private void connect() {
        edit1 = findViewById(R.id.txt_1);
        edit2 = findViewById(R.id.txt_2);
        edit3 = findViewById(R.id.txt_3);

        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnX = findViewById(R.id.btn_x);
        btnDivide = findViewById(R.id.btn_divide);

        result = findViewById(R.id.textViewResult);
    }

}