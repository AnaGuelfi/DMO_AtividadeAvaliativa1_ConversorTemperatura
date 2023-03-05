package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.dmos5.model.CelsiusStrategy;
import br.edu.ifsp.dmos5.model.FahrenheitStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorDigitadoEditText;
    private TextView valorConvertidoTextView;
    private Button converterCelsiusButton;
    private Button converterFahrenheitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorDigitadoEditText = findViewById(R.id.edittext_value);
        valorConvertidoTextView = findViewById(R.id.textview_valor_convertido);
        converterCelsiusButton = findViewById(R.id.button_converter_celsius);
        converterCelsiusButton.setOnClickListener(this);
        converterFahrenheitButton = findViewById(R.id.button_converter_fahrenheit);
        converterFahrenheitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == converterCelsiusButton) {
            getCelsiusConvertion();
        }
        if(view == converterFahrenheitButton){
            getFahrenheitConvertion();
        }
    }

    private double getValue() {
        double valorDigitado;
        String valorString;

        valorString = valorDigitadoEditText.getText().toString();

        try{
            valorDigitado = Double.valueOf(valorString);
        }catch(NumberFormatException e){
            Toast.makeText(this, "Informe um valor válido.", Toast.LENGTH_SHORT).show();
            valorDigitado = 0;
        }
        return valorDigitado;
    }

    private void getCelsiusConvertion() {
        double valorFahrenheit = getValue();
        double valorCelsius;
        valorCelsius = CelsiusStrategy.getInstance().getConversion(valorFahrenheit);
        valorConvertidoTextView.setText(String.format("%.2f °C", valorCelsius));
    }

    private void getFahrenheitConvertion() {
        double valorCelsius = getValue();
        double valorFahrenheit;

        valorFahrenheit = FahrenheitStrategy.getInstance().getConversion(valorCelsius);
        valorConvertidoTextView.setText(String.format("%.2f °F", valorFahrenheit));
    }

}