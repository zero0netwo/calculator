package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.crypto.spec.DESKeySpec;

public class MainActivity extends AppCompatActivity {

    TextView dsplay;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button zeroButton;
    Button clearButton;

    Button plusButton;
    Button equalsButton;
    Button minusButton;
    Button multiplicationButton;
    Button divisionButton;
    int firstNumber;
    int secondNumber;



    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // цифровые кнопки + дисплей
        dsplay = findViewById(R.id.Display);
        oneButton = findViewById(R.id.oneBtn);
        twoButton = findViewById(R.id.twoBtn);
        threeButton = findViewById(R.id.threeBtn);
        fourButton = findViewById(R.id.fourBtn);
        fiveButton = findViewById(R.id.fiveBtn);
        sixButton = findViewById(R.id.sixBtn);
        sevenButton = findViewById(R.id.sevenBtn);
        eightButton = findViewById(R.id.eightBtn);
        nineButton = findViewById(R.id.nineBtn);
        zeroButton = findViewById(R.id.zeroBtn);

        // операции и  клир
        clearButton = findViewById(R.id.clearBtn);
        plusButton = findViewById(R.id.plusBtn);
        equalsButton = findViewById(R.id.equalsBtn);
        minusButton = findViewById(R.id.minusBtn);
        multiplicationButton = findViewById(R.id.MltplicationBtn);
        divisionButton = findViewById(R.id.divisionBtn);

        oneButton.setOnClickListener(v -> {enterValue("1");});
        twoButton.setOnClickListener(v -> {enterValue("2");});
        threeButton.setOnClickListener(v -> {enterValue("3");});
        fourButton.setOnClickListener(v ->{enterValue("4");});
        fiveButton.setOnClickListener(v -> {enterValue("5");});
        sixButton.setOnClickListener(v -> {enterValue("6");});
        sevenButton.setOnClickListener(v -> {enterValue("7");});
        eightButton.setOnClickListener(v ->{enterValue("8");});
        nineButton.setOnClickListener(v -> {enterValue("9");});
        zeroButton.setOnClickListener(v ->{enterValue("0");});

        clearButton.setOnClickListener(v ->{dsplay.setText("0");});

        plusButton.setOnClickListener(v -> {
            firstNumber = Integer.parseInt(dsplay.getText().toString());
            operation = "+";
            dsplay.setText("0");

        });

        equalsButton.setOnClickListener(v ->{
            secondNumber = Integer.parseInt(dsplay.getText().toString());
                if (operation.equals("+")) {
                    int result = firstNumber + secondNumber;
                    dsplay.setText(String.valueOf(result));
                }
                else if (operation.equals("-")) {
                    int result = firstNumber - secondNumber;
                    dsplay.setText(String.valueOf(result));
                }
                else if (operation.equals("*")) {
                    int result = firstNumber * secondNumber;
                    dsplay.setText(String.valueOf((result)));
                }

                else if(operation.equals("/")) {
                    if (secondNumber != 0) {
                        double result = (double)firstNumber / secondNumber;
                        dsplay.setText(String.valueOf(result));
                    }
                    else {
                        dsplay.setText("Ошибка");
                    }
                }

        });

        minusButton.setOnClickListener(v -> {
            firstNumber = Integer.parseInt(dsplay.getText().toString());
            operation = "-";
            dsplay.setText("0");
        });

        multiplicationButton.setOnClickListener(v -> {
            firstNumber = Integer.parseInt(dsplay.getText().toString());
            operation = "*";
            dsplay.setText("0");
        });

        divisionButton.setOnClickListener(v ->{
            firstNumber = Integer.parseInt(dsplay.getText().toString());
            operation = "/";
            dsplay.setText("0");
        });

        // кнопка 1
        /*
        oneButton.setOnClickListener( v -> {String values = dsplay.getText().toString();

                    if (values.equals("0")) {
                        dsplay.setText("1");
                    }
                    else {
                        dsplay.setText(values + "1");

                    }
        });
        */


        // кнопка 2
        /*
        twoButton.setOnClickListener(v -> {String values = dsplay.getText().toString();

                    if (values.equals("0")) {
                        dsplay.setText("2");
                    }
                    else {
                        dsplay.setText(values + "2");
                    }




        });
        */

        // кнопка 3

        /*threeButton.setOnClickListener(v -> {String values = dsplay.getText().toString();
                        if (values.equals("0")) {
                            dsplay.setText("3");

                        }
                        else {
                            dsplay.setText(values + "3");

                        }


        });

         */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void enterValue (String number){
        String display_text;
        display_text = dsplay.getText().toString();
        if (display_text.equals("0")){
            dsplay.setText(number);
        }
        else {
            dsplay.setText(display_text + number);
        }
    }
}