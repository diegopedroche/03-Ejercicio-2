package com.example.a03_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MotoActivity extends AppCompatActivity {

    private EditText txtMarcaMoto;
    private EditText txtModeloMoto;
    private EditText txtCCMoto;
    private Button btnCancelar;
    private Button btnCrearMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);

        inicializaVistas();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializaVistas() {
        txtMarcaMoto = findViewById(R.id.txtMarcaMoto);
        txtModeloMoto = findViewById(R.id.txtModeloMoto);
        txtCCMoto = findViewById(R.id.txtCCMoto);
        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrearMoto = findViewById(R.id.btnCrearMoto);
    }
}