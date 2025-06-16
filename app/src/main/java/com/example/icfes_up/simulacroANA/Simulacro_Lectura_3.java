package com.example.icfes_up.simulacroANA;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.icfes_up.databinding.FragmentSimulacroLectura3Binding;

import com.example.icfes_up.R;

public class Simulacro_Lectura_3 extends Fragment {
    private FragmentSimulacroLectura3Binding binding;

    public Simulacro_Lectura_3() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSimulacroLectura3Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSiguiente3.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_lectura_Simulacro_3_to_lectura_Simulacro_4);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
