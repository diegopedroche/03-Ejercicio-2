package com.example.a03_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03_ejercicio2.modelos.CocheModel;

public class CocheActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        inicializaVistas();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if(!marca.isEmpty() && !modelo.isEmpty() && !color.isEmpty()){
                    CocheModel coche = new CocheModel(marca, modelo, color);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE",coche);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();

                }else{
                    Toast.makeText(CocheActivity.this,"FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void inicializaVistas() {
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);
        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}