package com.example.celsiusfahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //Festsetzung der Attribute
    Button buttonC;
    EditText eingabe;
    Button buttonF;
    Double d;
    TextView ergebnis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eingabe =(EditText)findViewById(R.id.eingabe);
        ergebnis  = findViewById(R.id.ausgabe);
        buttonC =(Button)findViewById(R.id.button);
        buttonF =(Button)findViewById(R.id.button2);


        buttonF.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (eingabe.getText().toString().isEmpty()) {
                                               Toast.makeText(MainActivity.this, "Please enter the temperature", Toast.LENGTH_SHORT).show();
                                           } else if (buttonF.isPressed()) {
                                               d = Double.parseDouble(String.valueOf(eingabe.getText()));
                                               Double b = d * 9 / 5 + 32;
                                               ergebnis.setText(String.valueOf(Math.round(b * 1000) / 1000.0 + " °F"));
                                           }

                                       }
                                   });
            buttonC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (eingabe.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this, "Please enter the temperature", Toast.LENGTH_SHORT).show();
                        }
                        else if (buttonC.isPressed()) {

                        d = Double.parseDouble(String.valueOf(eingabe.getText()));
                        Double c = (d - 32) * 5 / 9;
                        ergebnis.setText(String.valueOf(Math.round(c * 1000) / 1000.0 + " °C"));

                }
            }
        });
    }
}