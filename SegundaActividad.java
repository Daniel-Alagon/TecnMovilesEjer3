package com.example.actividad3;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SegundaActividad extends AppCompatActivity {

    ListView lista;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        lista = findViewById(R.id.lista);
        btnVolver = findViewById(R.id.btnVolver);

        ArrayList<Reporte> reportes = MainActivity.listaReportes;

        Collections.sort(reportes, new Comparator<Reporte>() {
            @Override
            public int compare(Reporte r1, Reporte r2) {
                return prioridadValor(r1.getPrioridad()) - prioridadValor(r2.getPrioridad());
            }
        });

        ArrayList<String> datos = new ArrayList<>();
        for (Reporte r : reportes) {
            datos.add(r.getTipo() + " - " + r.getPrioridad());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, datos);

        lista.setAdapter(adapter);

        btnVolver.setOnClickListener(v -> finish());
    }

    private int prioridadValor(String p) {
        switch (p) {
            case "Alta": return 1;
            case "Media": return 2;
            case "Baja": return 3;
        }
        return 4;
    }
}
