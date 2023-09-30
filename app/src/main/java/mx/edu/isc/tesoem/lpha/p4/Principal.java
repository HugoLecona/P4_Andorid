package mx.edu.isc.tesoem.lpha.p4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import DatosParce.DatosParce;

public class Principal extends AppCompatActivity{

    Button btnab, btnap, btnar;
    EditText txtnombre, txtedad, txtcorreo;


    ActivityResultLauncher<Intent> activityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK){
            Toast.makeText(Principal.this, "Regresaste con exito, amor", Toast.LENGTH_SHORT).show();
        }else if(result.getResultCode() == RESULT_CANCELED){
            Toast.makeText(Principal.this, "Cancelao por el usuario pa", Toast.LENGTH_SHORT).show();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtnombre = findViewById(R.id.p1txtnombre);
        txtcorreo = findViewById(R.id.p1txtcorreo);
        txtedad = findViewById(R.id.p1txtedad);

        btnab = findViewById(R.id.p1btnab);
        btnap = findViewById(R.id.p1btnap);
        btnar = findViewById(R.id.p1btnar);

        btnab.setOnClickListener(view -> {
            Intent lanza = new Intent(Principal.this, Basica.class);
            lanza.putExtra( "nombre", txtnombre.getText().toString());
            startActivity(lanza);
        });

       btnap.setOnClickListener(view -> {
           DatosParce datosParce = new DatosParce(txtnombre.getText().toString(), txtcorreo.getText().toString(), Integer.parseInt(txtedad.getText().toString()));
           Intent lanza = new Intent(Principal.this, Parce.class);
           lanza.putExtra("datosparcelables", datosParce);
           startActivity(lanza);
       });

       btnar.setOnClickListener(view -> {
           Intent lanza = new Intent(Principal.this, Regresa.class);
           activityResult.launch(lanza);
       });
    }


    }
