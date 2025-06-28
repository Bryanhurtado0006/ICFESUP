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
import com.example.icfes_up.databinding.FragmentSimulacroLectura1Binding;

import com.example.icfes_up.databinding.FragmentSimulacroLectura1Binding;

import com.example.icfes_up.R;


public class Simulacro_Lectura_1 extends Fragment {
    private FragmentSimulacroLectura1Binding binding;

    public Simulacro_Lectura_1() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSimulacroLectura1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSiguiente1.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_simulacro_Lectura_1_to_simulacro_Lectura_2);

            Navigation.findNavController(v).navigate(R.id.action_simulacroLectura1_to_lectura_Simulacro_2);

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
