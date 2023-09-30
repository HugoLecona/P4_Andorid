package mx.edu.isc.tesoem.lpha.p4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import DatosParce.DatosParce;

public class Parce extends AppCompatActivity {

    TextView lblnombre, lblcorreo, lbledad;
    Button btnregresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parce);

        lblnombre = findViewById(R.id.p3lblnombre);
        lbledad = findViewById(R.id.p3lbledad);
        lblcorreo = findViewById(R.id.p3lblcorreo);

        btnregresa = findViewById(R.id.p3btnregresa);

        DatosParce datosParce = getIntent().getParcelableExtra("datosparcelables");
        assert datosParce != null;
        lblnombre.setText(datosParce.getNombre());
        lbledad.setText(String.valueOf(datosParce.getEdad()));
        lblcorreo.setText(datosParce.getCorreo());

        btnregresa.setOnClickListener(view -> {
            Intent lanza = new Intent(Parce.this, Principal.class);
            startActivity(lanza);
            finish();
        });

    }
}