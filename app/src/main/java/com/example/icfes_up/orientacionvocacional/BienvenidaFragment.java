package com.example.icfes_up.orientacionvocacional;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.icfes_up.R;
import com.example.icfes_up.databinding.FragmentBienvenidaBinding;

public class BienvenidaFragment extends Fragment {

    private FragmentBienvenidaBinding binding;

    public BienvenidaFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBienvenidaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnComenzarTest.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_bienvenidaFragment_to_testFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
