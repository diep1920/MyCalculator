package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView display;
    Button btn_1, btn_2, btn_3,
            btn_4, btn_5, btn_6,
            btn_7, btn_8, btn_9, btn_0,
            btn_bs, btn_c, btn_ce,
            btn_enter, btn_sign, btn_point,
            btn_divide, btn_multiply, btn_plus, btn_minus;


    // -----------------------------------------------------------------------
    // operator stores operator's flag
    // operator'flag is true if operator's button is clicked
    Boolean[] operatorButtonClicked = new Boolean[4];
    Boolean[] operatorToPerform = new Boolean[4];
    // -----------------------------------------------------------------------
    // operandFocus stores operand's focus flag. Only one is focused at a time
    int storedValue;
    int numberOnDisplay;

    static final int PLUS = 0;
    static final int MINUS = 1;
    static final  int MULTIPLY = 2;
    static final int DIVIDE = 3;


    // -----------------------------------------------------------------------
    // Cac truong hop: nhan 2 lan nut operator
    // nhan nut ce roi nhan operator
    // nhan operator roi nhan ce
    // nhan nhan operator roi nhan bs
    // nhan bang ngay tu dau
    // nhan
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        operatorToPerform[PLUS] = false;
        operatorToPerform[MINUS] = false;
        operatorToPerform[MULTIPLY] = false;
        operatorToPerform[DIVIDE] = false;

        operatorButtonClicked[PLUS] = false;
        operatorButtonClicked[MINUS] = false;
        operatorButtonClicked[MULTIPLY] = false;
        operatorButtonClicked[DIVIDE] = false;

        storedValue = 0;
        numberOnDisplay = 0;

        display = findViewById(R.id.display);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_c = findViewById(R.id.btn_c);
        btn_ce = findViewById(R.id.btn_ce);
        btn_bs = findViewById(R.id.btn_bs);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_sign = findViewById(R.id.btn_sign);
        btn_enter = findViewById(R.id.btn_enter);
        btn_point = findViewById(R.id.btn_point);

        display.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_ce.setOnClickListener(this);
        btn_bs.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_sign.setOnClickListener(this);
        btn_enter.setOnClickListener(this);
        btn_point.setOnClickListener(this);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.ds_digi);
        display.setTypeface(typeface);



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btn_0){
            numberButtonHandling(0);
        }
        if(id == R.id.btn_1){
            numberButtonHandling(1);
        }
        if(id == R.id.btn_2){
            numberButtonHandling(2);
        }
        if(id == R.id.btn_3){
            numberButtonHandling(3);
        }
        if(id == R.id.btn_4){
            numberButtonHandling(4);
        }
        if(id == R.id.btn_5){
            numberButtonHandling(5);
        }
        if(id == R.id.btn_6){
            numberButtonHandling(6);
        }
        if(id == R.id.btn_7){
            numberButtonHandling(7);
        }
        if(id == R.id.btn_8){
            numberButtonHandling(8);
        }
        if(id == R.id.btn_9){
            numberButtonHandling(9);
        }


        if(id == R.id.btn_plus){
            operatorButtonHandling(PLUS);
        }

        if(id == R.id.btn_minus){
            operatorButtonHandling(MINUS);
        }

        if(id == R.id.btn_multiply){
            operatorButtonHandling(MULTIPLY);
        }

        if(id == R.id.btn_divide){
            operatorButtonHandling(DIVIDE);
        }


        if(id == R.id.btn_bs){
            bsButtonHandling();
        }

        if(id == R.id.btn_c){
            cButtonHandling();
        }

        if(id == R.id.btn_ce){
            ceButtonHandling();
        }


        if(id == R.id.btn_enter){
            enterButtonHandling();
        }
    }


    void numberButtonHandling(int arg){
        numberOnDisplay = Integer.parseInt(display.getText().toString());
        for(int i = 0; i < 4; ++i){
            if(operatorButtonClicked[i] == true){
                numberOnDisplay = 0;
                break;
            };
        }

        numberOnDisplay = numberOnDisplay*10 + arg;
        updateDisplay(numberOnDisplay);
        numberOnDisplay = 0;
        for(int i = 0; i < 4; ++i){
            operatorButtonClicked[i] = false;
        }
    }

    void enterButtonHandling() {
        for (int i = 0; i < 4; ++i) {
            if (operatorToPerform[i]) {
                switch (i) {

                    case PLUS:
                        storedValue += Integer.parseInt(display.getText().toString());
                        break;

                    case MINUS:
                        storedValue -= Integer.parseInt(display.getText().toString());
                        break;

                    case MULTIPLY:
                        storedValue *= Integer.parseInt(display.getText().toString());
                        break;

                    case DIVIDE:
                        if (Integer.parseInt(display.getText().toString()) == 0) {
                            display.setText("Cannot divide by zero");
                        } else {
                            storedValue /= Integer.parseInt(display.getText().toString());
                        }

                        break;
                }
                updateDisplay(storedValue);
                break;
            }
        }
        for (int i = 0; i < 4; ++i) {
            operatorToPerform[i] = false;
            operatorButtonClicked[i] = false;
        }
    }

    void operatorButtonHandling(int arg){
        storedValue = Integer.parseInt(display.getText().toString());
        for( int i = 0; i < 4; i++){
            operatorButtonClicked[i] = false;
            operatorToPerform[i] = false;
        }
        operatorButtonClicked[arg] = true;
        operatorToPerform[arg] = true;}

    void bsButtonHandling(){
        // ---------------------------------------------------------------
        // checkFlag is true if any operator button was clicked before BS

        Boolean checkFlag = false;
        for(int i = 0; i < 4; ++i){
            if(operatorButtonClicked[i]){
                checkFlag = true;
                break;
            }
        }

        // -----------------------------------------------------
        // if an operator button was clicked then ignore BS
        if(checkFlag == false){
            numberOnDisplay = Integer.parseInt(display.getText().toString());
            numberOnDisplay = numberOnDisplay/10;
            display.setText(Integer.toString(numberOnDisplay));
            numberOnDisplay = 0;
        }
    }

    void ceButtonHandling(){
        display.setText("0");
    }

    void cButtonHandling(){
        storedValue = 0;
        for(int i = 0; i < 4; ++i){
            operatorToPerform[i] = false;
            operatorButtonClicked[i] = false;
        }
        updateDisplay(0);
    }

    void updateDisplay(int arg){
        display.setText(Integer.toString(arg));
    }
}
