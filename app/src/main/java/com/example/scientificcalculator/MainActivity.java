package com.example.scientificcalculator;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {


    private TextView previousCalculation;
    private EditText displayText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        displayText = findViewById(R.id.display_edit_text);

        displayText.setShowSoftInputOnFocus(false);
    }

    public void updateText(String strToAdd){
        String oldStr = displayText.getText().toString();
        int cursorPos = displayText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        displayText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        displayText.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view){ updateText(getResources().getString(R.string.button_zero));}
    public void oneBTNPush(View view){ updateText(getResources().getString(R.string.button_one)); }
    public void twoBTNPush(View view){ updateText(getResources().getString(R.string.button_two)); }
    public void threeBTNPush(View view){ updateText(getResources().getString(R.string.button_three));}
    public void fourBTNPush(View view){ updateText(getResources().getString(R.string.button_four));}
    public void fiveBTNPush(View view){ updateText(getResources().getString(R.string.button_five));}
    public void sixBTNPush(View view){ updateText(getResources().getString(R.string.button_six));}
    public void sevenBTNPush(View view){ updateText(getResources().getString(R.string.button_seven));}
    public void eightBTNPush(View view){ updateText(getResources().getString(R.string.button_eight));}
    public void nineBTNPush(View view){ updateText(getResources().getString(R.string.button_nine));}
    public void pointBTNPush(View view){ updateText(getResources().getString(R.string.button_point)); }


    public void plusBTNPush(View view){ updateText(getResources().getString(R.string.button_plus)); }
    public void minusBTNPush(View view){ updateText(getResources().getString(R.string.button_minus)); }
    public void multiplyBTNPush(View view){ updateText(getResources().getString(R.string.button_multiply)); }
    public void divideBTNPush(View view){ updateText(getResources().getString(R.string.button_divide)); }

    public void parenthesesCloseTextBTNPush(View view){ updateText(getResources().getString(R.string.parenthesesCloseText)); }
    public void parenthesesOpenTextBTNPush(View view){ updateText(getResources().getString(R.string.parenthesesOpenText)); }

    public void clearBTNPush(View view){
        displayText.setText("");
        previousCalculation.setText("");
    }

    public void equalsBTNPush(View view){
        String userExp = displayText.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.button_divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.button_multiply), "*");
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        
        displayText.setText(result);
        displayText.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = displayText.getSelectionStart();
        int textLen = displayText.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) displayText.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            displayText.setText(selection);
            displayText.setSelection(cursorPos-1);
        }
    }

    public void trigSinBTN(View view){updateText("sin(");}
    public void trigCosTextBTN(View view){updateText("cos(");}
    public void trigTanTextBTN(View view){updateText("tan(");}
    public void trigArcSinTextBTN(View view){updateText("arcsin(");}
    public void trigArcCosTextBTN(View view){updateText("arccos(");}
    public void trigArcTanTextBTN(View view){updateText("arctan(");}
    public void naturalLogTextBTN(View view){updateText("ln(");}
    public void LogTextBTN(View view){updateText("log(");}
    public void squareRootTextBTN(View view){updateText("sqrt(");}
    public void absoluteValueTextBTN(View view){updateText("abc(");}
    public void piTextBTN(View view){updateText("pi");}
    public void eTextBTN(View view){updateText("e");}
    public void xSquaredTextBTN(View view){updateText("^(2)");}
    public void xPowerYTextBTN(View view){updateText("^");}
    public void isPrimeFunctionTextBTN(View view){updateText("ispr(");}


}