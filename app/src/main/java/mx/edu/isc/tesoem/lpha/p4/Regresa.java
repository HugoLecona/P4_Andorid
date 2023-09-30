package mx.edu.isc.tesoem.lpha.p4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Regresa extends AppCompatActivity {

    Button btncancel, btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regresa);

        btnok = findViewById(R.id.p4btnok);
        btncancel = findViewById(R.id.p4btncance);

        btnok.setOnClickListener(view -> {
            setResult(RESULT_OK);
            finish();
        });

        btncancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });

    }
}