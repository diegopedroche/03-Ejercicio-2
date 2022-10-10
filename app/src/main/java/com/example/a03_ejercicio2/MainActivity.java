package com.example.a03_ejercicio2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a03_ejercicio2.modelos.BiciModel;
import com.example.a03_ejercicio2.modelos.CocheModel;
import com.example.a03_ejercicio2.modelos.MotoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS PARA LA VISTA
    private TextView txtCoche;
    private TextView txtMoto;
    private TextView txtBici;
    private Button btnAddCoche;
    private Button btnAddMoto;
    private Button btnAddBici;

    //ATRIBUTOS PARA EVENTOS
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    //ATRIBUTOS PARA LOGICA
    private ArrayList<CocheModel> coches;
    private ArrayList<MotoModel> motos;
    private ArrayList<BiciModel> bicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVistas();
        inicializaLaunchers();

        btnAddCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CocheActivity.class);
                launcherCoches.launch(intent);
            }
        });

        btnAddMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MotoActivity.class);
                launcherMotos.launch(intent);
            }
        });

        btnAddBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BiciActivity.class);
                launcherBicis.launch(intent);
            }
        });
    }

    private void inicializaLaunchers() {
        launcherCoches = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    if(result.getData() != null){
                        Bundle bundle = result.getData().getExtras();
                        CocheModel coche = (CocheModel) bundle.getSerializable("COCHE");
                        if(coche != null){
                            coches.add(coche);
                            txtCoche.setText("Coches: "+coches.size());
                        }else{
                            Toast.makeText(MainActivity.this,"NO ESTAN LOS DATOS",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this,"VENTANA CANCELADA",Toast.LENGTH_SHORT).show();
                }
            }
        });

        launcherMotos = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    if (result.getData() != null){
                        Bundle bundle = result.getData().getExtras();
                        MotoModel moto = (MotoModel) bundle.getSerializable("MOTO");
                        if(moto != null){
                            motos.add(moto);
                            txtMoto.setText("Motos: " + motos.size());
                        }else{
                            Toast.makeText(MainActivity.this,"NO ESTAN LOS DATOS",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this,"VENTANA CANCELADA",Toast.LENGTH_SHORT).show();
                }
            }
        });

        launcherBicis = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    if(result.getData() != null){
                        Bundle bundle = result.getData().getExtras();
                        BiciModel bici = (BiciModel) bundle.getSerializable("BICI");
                        if(bici != null){
                            bicis.add(bici);
                            txtBici.setText("Bicis: " + bicis.size());
                        }else{
                            Toast.makeText(MainActivity.this,"NO ESTAN LOS DATOS",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this,"VENTANA CANCELADA",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializaVistas() {
        txtCoche = findViewById(R.id.lbCocheMain);
        txtMoto = findViewById(R.id.lbMotoMain);
        txtBici = findViewById(R.id.lbBiciMain);
        btnAddCoche = findViewById(R.id.btnAddCocheMain);
        btnAddMoto = findViewById(R.id.btnAddMotoMain);
        btnAddBici = findViewById(R.id.btnAddBiciMain);

        coches = new ArrayList<>();
        motos = new ArrayList<>();
        bicis = new ArrayList<>();
    }
}