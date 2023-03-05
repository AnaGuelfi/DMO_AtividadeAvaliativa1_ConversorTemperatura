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
import br.edu.ifsp.dmos5.model.KelvinStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorDigitadoEditText;
    private TextView valorConvertidoTextView;
    private Button converterCelsiusButton;
    private Button converterFahrenheitButton;
    private Button getConverterKelvinButton;

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
        getConverterKelvinButton = findViewById(R.id.button_converter_kelvin);
        getConverterKelvinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == converterCelsiusButton) {
            getCelsiusConvertion();
        }
        if(view == converterFahrenheitButton){
            getFahrenheitConvertion();
        }
        if(view == getConverterKelvinButton){
            getKelvinConvertion();
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

    private void getKelvinConvertion() {
        double valorCelsius = getValue();
        double valorKelvin;

        valorKelvin = KelvinStrategy.getInstance().getConversion(valorCelsius);
        valorConvertidoTextView.setText(String.format("%.2f K", valorKelvin));
    }

}