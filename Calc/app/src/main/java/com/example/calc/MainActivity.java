package com.example.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editText1, editText2, editText3;
    private Button addButton, subbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText11);
        editText2 = findViewById(R.id.editText22);
        editText3 = findViewById(R.id.editText33);

        addButton = findViewById(R.id.addButtonn);
        subbutton = findViewById(R.id.button1);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });

        subbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSub();
            }
        });
    }

    private boolean validateInput() {
        String input1 = editText1.getText().toString().trim();
        String input2 = editText2.getText().toString().trim();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this,
                    "Please enter both numbers",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void calculateSum() {

        if (!validateInput()) {
            return;
        }

        int number1 = Integer.parseInt(
                editText1.getText().toString()
        );

        int number2 = Integer.parseInt(
                editText2.getText().toString()
        );

        int sum = number1 + number2;

        editText3.setText(String.valueOf(sum));
    }

    private void calculateSub() {

        if (!validateInput()) {
            return;
        }

        int number1 = Integer.parseInt(
                editText1.getText().toString()
        );

        int number2 = Integer.parseInt(
                editText2.getText().toString()
        );

        int result = number1 - number2;

        editText3.setText(String.valueOf(result));
    }
}
