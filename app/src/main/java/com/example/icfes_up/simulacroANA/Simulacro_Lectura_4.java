package com.example.icfes_up.simulacroANA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.icfes_up.R;
import com.example.icfes_up.databinding.FragmentSimulacroLectura4Binding;

public class Simulacro_Lectura_4 extends Fragment {
    private FragmentSimulacroLectura4Binding binding;

    public Simulacro_Lectura_4() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSimulacroLectura4Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.VerEstadistica1.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_simulacro_Lectura_4_to_estadistica_Lectura);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
