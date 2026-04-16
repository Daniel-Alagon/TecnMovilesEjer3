package com.example.actividad3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spTipo, spPrioridad;
    Button btnReportar, btnVer;

    public static ArrayList<Reporte> listaReportes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTipo = findViewById(R.id.spTipo);
        spPrioridad = findViewById(R.id.spPrioridad);
        btnReportar = findViewById(R.id.btnReportar);
        btnVer = findViewById(R.id.btnVer);

        ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(
                this, R.array.tipos_emergencia, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapterPrioridad = ArrayAdapter.createFromResource(
                this, R.array.prioridades, android.R.layout.simple_spinner_item);

        spTipo.setAdapter(adapterTipo);
        spPrioridad.setAdapter(adapterPrioridad);

        btnReportar.setOnClickListener(v -> {
            String tipo = spTipo.getSelectedItem().toString();
            String prioridad = spPrioridad.getSelectedItem().toString();

            listaReportes.add(new Reporte(tipo, prioridad));

            Toast.makeText(this, "Emergencia reportada", Toast.LENGTH_SHORT).show();
        });

        btnVer.setOnClickListener(v -> {
            Intent intent = new Intent(this, SegundaActividad.class);
            startActivity(intent);
        });
    }
}
