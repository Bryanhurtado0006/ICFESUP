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

import com.example.icfes_up.databinding.FragmentFinalBinding;

public class FinalFragment extends Fragment {
    public FinalFragment(){}

    private FragmentFinalBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFinalBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.tvGracias.setText("¡Gracias por completar el test vocacional!");

        binding.btnVolverInicio.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_finalFragment_to_bienvenidaFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
