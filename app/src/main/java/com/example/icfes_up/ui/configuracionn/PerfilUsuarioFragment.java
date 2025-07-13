package com.example.icfes_up.ui.configuracionn;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.icfes_up.R;
import com.example.icfes_up.databinding.FragmentPerfilUsuarioBinding;
import com.example.icfes_up.logueo.Inicio_Sesion;

public class PerfilUsuarioFragment extends Fragment {

    private FragmentPerfilUsuarioBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPerfilUsuarioBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Botón VER PERFIL (puede ir a un fragmento de vista más detallada si quieres)
        binding.btnVerPerfil.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Aquí mostrarías más detalles del perfil", Toast.LENGTH_SHORT).show();
        });

        // Opción Editar perfil
        binding.Perfill.setOnClickListener(v -> {
            // Navega al fragmento de editar perfil
            // Asegúrate de tener configurado correctamente el Navigation Component
            androidx.navigation.Navigation.findNavController(v)
                    .navigate(R.id.action_nav_configuracion_to_editarPerfilFragment);
        });

        // Cerrar sesión con confirmación
        binding.layoutCerrarSesion.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle("Cerrar sesión")
                    .setMessage("¿Estás seguro de que deseas cerrar sesión?\nTu progreso estará guardado.")
                    .setIcon(R.drawable.logout) // puedes usar un ícono personalizado
                    .setPositiveButton("Sí, cerrar sesión", (dialog, which) -> {
                        // Aquí se navega al inicio de sesión
                        Intent intent = new Intent(requireContext(), Inicio_Sesion.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Limpia el backstack
                        startActivity(intent);
                    })
                    .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                    .setCancelable(false)
                    .show();
        });


        // Sugerencias
        binding.Sugerencia.setOnClickListener(v ->
                Toast.makeText(getContext(), "Abrir sección de sugerencias", Toast.LENGTH_SHORT).show()
        );

        // Reporte
        binding.Reporte.setOnClickListener(v ->
                Toast.makeText(getContext(), "Abrir sección de reportes", Toast.LENGTH_SHORT).show()
        );

        // Política y privacidad
        binding.Politica.setOnClickListener(v ->
                Toast.makeText(getContext(), "Ver política de privacidad", Toast.LENGTH_SHORT).show()
        );

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


