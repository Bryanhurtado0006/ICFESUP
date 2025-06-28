package com.example.icfes_up.ui.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.icfes_up.Gamificacion_LUIS.Ruleta_LUIS;
import com.example.icfes_up.Mundos.Mundos_activity;
import com.example.icfes_up.R;
import com.example.icfes_up.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout usando ViewBinding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Mostrar toast de carga
        Toast.makeText(getContext(), "HomeFragment cargado", Toast.LENGTH_SHORT).show();

        // Inicializar ViewModel
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Configurar el texto observado
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Configurar botón de simulacro
        FloatingActionButton fabSimulacro = binding.irAlSimulacro;
        fabSimulacro.setOnClickListener(v -> {
            AlertDialog dialog = new AlertDialog.Builder(requireContext())
                    .setTitle("Simulacro obligatorio")
                    .setMessage("Este test es esencial para medir tu preparación para las pruebas ICFES. No puede ser cancelado ni omitido.")
                    .setPositiveButton("Entendido", (dialogInterface, which) -> {
                        Navigation.findNavController(v).navigate(R.id.action_nav_home_to_fragmentCategorias);
                    })
                    .create();

            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        });

        // Configurar click listeners
        binding.OrientacionV.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_bienvenidaFragment);
        });

        binding.ImgMundosgami.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Mundos_activity.class);
            startActivity(intent);
            requireActivity().overridePendingTransition(R.anim.slide_in_right_testv, R.anim.slide_out_left_testv);
        });

        binding.ImgGamificacionsemanal.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Ruleta_LUIS.class);
            startActivity(intent);
            requireActivity().overridePendingTransition(R.anim.slide_in_right_testv, R.anim.slide_out_left_testv);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}