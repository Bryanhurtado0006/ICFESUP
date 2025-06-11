package com.example.icfes_up.simulacroANA;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.icfes_up.databinding.FragmentEstadisticaLecturaBinding;


import com.example.icfes_up.R;

public class Estadistica_Lectura extends Fragment {
    private FragmentEstadisticaLecturaBinding binding;

    public Estadistica_Lectura() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEstadisticaLecturaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnIrASimulacros.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_estadisticaLectura_to_fragmentCategorias);
        });

        binding.btnGoToMain1.setOnClickListener(v ->{
          Navigation.findNavController(v).navigate(R.id.action_estadisticaLectura_to_nav_home);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
