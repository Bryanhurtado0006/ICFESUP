package com.example.icfes_up.progreso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.icfes_up.R;

public class MiProgresoFragment extends Fragment {

    private ProgressBar progresoMatematicas, progresoLectura;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mi_progreso, container, false);

        // Asigna nombres a cada área
        setNombreArea(root, R.id.area_matematicas, "Matemáticas");
        setNombreArea(root, R.id.area_lectura, "Lectura Crítica");
        setNombreArea(root, R.id.area_sociales, "Ciencias Sociales");
        setNombreArea(root, R.id.area_ciencias, "Ciencias Naturales");
        setNombreArea(root, R.id.area_ingles, "Inglés");

        return root;
    }

    private void setNombreArea(View root, int includeId, String nombre) {
        View cardView = root.findViewById(includeId);
        TextView txtNombreArea = cardView.findViewById(R.id.txtNombreArea);
        txtNombreArea.setText(nombre);
    }
}
