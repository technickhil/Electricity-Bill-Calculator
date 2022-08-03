package com.example.electricitybillcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView7;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private EditText editTextNumber;
    private EditText editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView7 = findViewById(R.id.textView7);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);


        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editTextNumber.getText().toString();
                String s1 = editTextNumber2.getText().toString();
                int a = Integer.parseInt(s);
                int b = Integer.parseInt(s1);
                int unit = b-a;
                textView4.setText("The Units are : "+unit);

                int fixed = 112;
                if(unit>0 && unit<=100){
                    textView7.setText("Fixed Charges : "+fixed);
                    textView10.setText("Energy Charges : "+unit*3.44);
                    textView11.setText("Wheeling Charges : "+String.format("%.2f",(unit*1.38)));
                    textView12.setText("Electricity Duty : "+ String.format("%.2f", ((fixed+(unit*3.44)+(unit*1.38)))*0.16));
                    textView13.setText("Total Bill : "+String.format("%.2f", (fixed + (unit*3.44)+(unit*1.38)+((fixed+(unit*3.44)+(unit*1.38)))*0.16)));
                }

                else if(unit>101 && unit<=300){
                    textView7.setText("Fixed Charges : "+fixed);
                    textView10.setText("Energy Charges : "+((100*3.44)+(unit-100)*7.34));
                    textView11.setText("Wheeling Charges : "+String.format("%.2f",(unit*1.38)));
                    textView12.setText("Electricity Duty : "+ String.format("%.2f",((fixed+((100*3.44)+(unit-100)*7.34))+(unit*1.38))*0.16));
                    textView13.setText("Total Bill : "+ String.format("%.2f", (fixed + (((100*3.44)+(unit-100)*7.34))+(unit*1.38)+((fixed+((100*3.44)+(unit-100)*7.34))+(unit*1.38))*0.16)));
                }

                else if(unit>301 && unit<=500){
                    textView7.setText("Fixed Charges : "+fixed);
                    textView10.setText("Energy Charges : "+ ((100*3.44)+(200*7.34)+(unit-300)*10.36));
                    textView11.setText("Wheeling Charges : "+String.format("%.2f",(unit*1.38)));
                    textView12.setText("Electricity Duty : "+ String.format("%.2f",((fixed+((100*3.44)+(200*7.34)+(unit-300)*10.36))+(unit*1.38))*0.16));
                    textView13.setText("Total Bill : "+ String.format("%.2f", (fixed + (((100*3.44)+(200*7.34)+(unit-300)*10.36))+(unit*1.38)+((fixed+((100*3.44)+(200*7.34)+(unit-300)*10.36))+(unit*1.38))*0.16)));
                }

                else if(unit>501 && unit<=1000){
                    textView7.setText("Fixed Charges : "+fixed);
                    textView10.setText("Energy Charges : "+ ((100*3.44)+(200*7.34)+(200*10.36)+(unit-500)*11.82));
                    textView11.setText("Wheeling Charges : "+String.format("%.2f",(unit*1.38)));
                    textView12.setText("Electricity Duty : "+ String.format("%.2f",((fixed+(((100*3.44)+(200*7.34)+(200*10.36)+(unit-500)*11.82)))+(unit*1.38))*0.16));
                    textView13.setText("Total Bill : "+ String.format("%.2f", (fixed + (((100*3.44)+(200*7.34)+(200*10.36)+(unit-500)*11.82))+(unit*1.38)+((fixed+(((100*3.44)+(200*7.34)+(200*10.36)+(unit-500)*11.82)))+(unit*1.38))*0.16)));
                }

                textView14.setMovementMethod(LinkMovementMethod.getInstance());
            }
        });
    }
}