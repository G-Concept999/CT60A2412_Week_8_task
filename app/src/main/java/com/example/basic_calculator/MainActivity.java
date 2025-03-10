package com.example.basic_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // declaring UI components for user input, buttons, and result display
    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);

        textResult.setText("0");
    }

    // method to handle sum operation
    public void sum(View view) {
        if (areInputsEmpty()) {
            textResult.setText("Enter numbers");
        } else {
            double num1 = turnToDouble(inputFirstNumber);
            double num2 = turnToDouble(inputSecondNumber);

            double result = num1 + num2;
            displayResult(result);
        }
    }

    // method to handle subtract operation
    public void subtract(View view) {
        if (areInputsEmpty()) {
            textResult.setText("Enter numbers");
        } else {
            double num1 = turnToDouble(inputFirstNumber);
            double num2 = turnToDouble(inputSecondNumber);

            double result = num1 - num2;
            displayResult(result);
        }
    }

    // method to handle multiply operation
    public void multiply(View view) {
        if (areInputsEmpty()) {
            textResult.setText("Enter numbers");
        } else {
            double num1 = turnToDouble(inputFirstNumber);
            double num2 = turnToDouble(inputSecondNumber);
            double result = num1 * num2;

            displayResult(result);
        }
    }

    // method to handle divide operation
    public void divide(View view) {
        if (areInputsEmpty()) {
            textResult.setText("Enter numbers");
        } else {
            double num1 = turnToDouble(inputFirstNumber);
            double num2 = turnToDouble(inputSecondNumber);
            double result = 0;

            // prevent division by zero
            if (num2 != 0) {
                result = num1 / num2;
                double test = result;
                displayResult(result);
            } else {
                textResult.setText("ERROR");
            }
        }
    }

    // method to check if input fields are empty
    private boolean areInputsEmpty() {
        return inputFirstNumber.getText().toString().isEmpty() || inputSecondNumber.getText().toString().isEmpty();
    }

    // method to clear fields and reset result
    public void clearFields(View view) {
        inputFirstNumber.setText("");
        inputSecondNumber.setText("");
        textResult.setText("0");
    }

    // method to convert the input from EditText to double
    public double turnToDouble(EditText editText) {
        String numStr = editText.getText().toString();
        return Double.parseDouble(numStr);
    }

    public void displayResult(double result){
        String resultStr = String.valueOf(result);
        String[] resultArray = resultStr.split("\\.");
        String decimalPart = resultArray[1];
        String formattedResult = "";

        // if result is precise (no decimals digits) display it as an integer
        if(resultStr.endsWith(".0")){
            int resultInt = (int) result;
            formattedResult = String.valueOf(resultInt);
        } else if (decimalPart.length() > 8 ) {
            formattedResult = String.format("%.8f", result);
        } else{
            formattedResult = resultStr;
        }
        textResult.setText(formattedResult);
    }
}
