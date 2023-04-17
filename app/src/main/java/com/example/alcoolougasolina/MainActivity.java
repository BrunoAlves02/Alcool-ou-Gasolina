package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtPrecoAlcool, edtPrecoGasolina;
    private TextView textResultado;
    private Button buttonCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrecoAlcool = findViewById(R.id.inputAlcool);
        edtPrecoGasolina = findViewById(R.id.inputGasolina);
        textResultado = findViewById(R.id.textResultado);

        }

        public void calcularPreco(View view){
            //pega valores
            String precoAlcool = edtPrecoAlcool.getText().toString();
            String precoGasolina = edtPrecoGasolina.getText().toString();

            Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
            if(camposValidados){
                Double valorAlcool = Double.parseDouble(precoAlcool);
                Double valorGasolina = Double.parseDouble(precoGasolina);
                Double resultado;

                resultado = valorAlcool / valorGasolina;

                if(resultado >= 0.7){
                    textResultado.setText("Melhor utilizar Gasolina!");
                }else{
                    textResultado.setText("Melhor utilizar Álcool!");
                }

            }else {
                textResultado.setText("Digite os valores primeiro!");
            }

        }

        public boolean validarCampos (String pAlcool, String pGasolina){
            boolean camposValidados = true;

            if(pAlcool == null || pAlcool.equals("")){
                camposValidados = false;
            }else if( pGasolina == null || pGasolina.equals("") ){
                camposValidados = false;
            }

            return camposValidados;
        }

}