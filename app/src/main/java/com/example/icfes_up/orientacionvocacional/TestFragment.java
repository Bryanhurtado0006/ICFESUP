package com.example.icfes_up.orientacionvocacional;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import com.example.icfes_up.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;


import com.example.icfes_up.databinding.FragmentTestBinding;

public class TestFragment extends Fragment {

    private FragmentTestBinding binding;
    private OrientacionViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(OrientacionViewModel.class);
        cargarSeccion();

        binding.btnSiguiente.setOnClickListener(v -> {
            int selectedId = binding.opcionesGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(getContext(), "Selecciona una opción", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton opcionSeleccionada = view.findViewById(selectedId);
            String respuesta = opcionSeleccionada.getText().toString();
            viewModel.guardarRespuesta(respuesta);

            if (viewModel.testCompletado()) {
                Navigation.findNavController(view).navigate(R.id.action_testFragment_to_finalFragment);
            } else {
                cargarSeccion();
            }
        });
    }

    private void cargarSeccion() {
        binding.opcionesGroup.clearCheck();
        binding.tvSeccion.setText("Sección: " + viewModel.getTituloActual());
        binding.tvPregunta.setText(viewModel.getPreguntaActual());

        String[] opciones = viewModel.getOpcionesActuales();
        binding.option1.setText(opciones[0]);
        binding.option2.setText(opciones[1]);
        binding.option3.setText(opciones[2]);
        binding.option4.setText(opciones[3]);
        binding.option5.setText(opciones[4]);

        String respuestaPrev = viewModel.getRespuestaActual();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
