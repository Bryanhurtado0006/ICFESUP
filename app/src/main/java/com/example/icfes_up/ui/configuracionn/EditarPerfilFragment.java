package com.example.icfes_up.ui.configuracionn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.icfes_up.databinding.FragmentEditarPerfilBinding;

public class EditarPerfilFragment extends Fragment {

    private FragmentEditarPerfilBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEditarPerfilBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Simular cambio de foto con un mensaje
        binding.cambio.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Funcionalidad para cambiar foto aún no disponible", Toast.LENGTH_SHORT).show();
        });

        // Simular guardado de datos (solo muestra mensaje)
        binding.profile.setOnClickListener(v -> {
            String nombre = binding.EdNombre.getText().toString();
            String usuario = binding.EdUsuario.getText().toString();
            String correo = binding.EdCorreo.getText().toString();

            if (nombre.isEmpty() || usuario.isEmpty() || correo.isEmpty()) {
                Toast.makeText(getContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí podrías guardar con SharedPreferences o enviar a un backend
                Toast.makeText(getContext(), "Perfil actualizado", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}