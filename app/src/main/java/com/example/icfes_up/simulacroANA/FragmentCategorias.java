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
import com.example.icfes_up.databinding.FragmentCategoriasBinding;

public class FragmentCategorias extends Fragment {
    private FragmentCategoriasBinding binding;

    public FragmentCategorias() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCategoriasBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.itemLectura.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_fragmentCategorias_to_simulacroLectura1)
        );
    }
}