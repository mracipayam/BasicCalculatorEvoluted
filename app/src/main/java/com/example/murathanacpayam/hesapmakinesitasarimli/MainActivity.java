package com.example.murathanacpayam.hesapmakinesitasarimli;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView _screen;
    private String display ="";
    private String currentOperator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _screen = (TextView) findViewById(R.id.textView);
        _screen.setText(display);
    }
    private void updateScreen(){
        _screen.setText(display);
    }
    public void onClickNumber(View v){
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }
    public void onClickOperator(View v){
        Button b = (Button) v;
        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }
    private void clear(){
        display = "";
        currentOperator = "";

    }
    public void onClickClear(View v){
        clear();
        updateScreen();
    }
    private double operate(String a,String b,String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);

            case "-": return Double.valueOf(a) - Double.valueOf(b);

            case "x": return Double.valueOf(a) * Double.valueOf(b);

            case "/": try {
                return Double.valueOf(a) / Double.valueOf(b);
            }catch (Exception e){
                Log.d("Calc",e.getMessage());
            }

            default:return -1;


        }
    }
    public void onClickResult(View v){
        String[] operation = display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return;

        Double _result = operate(operation[0],operation[1],currentOperator);
        _screen.setText(display + "\n" +String.valueOf(_result));
    }


}
