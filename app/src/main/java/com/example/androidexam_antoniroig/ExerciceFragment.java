package com.example.androidexam_antoniroig;
// DetailsFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class ExerciceFragment extends Fragment {

    private static final String ARG_EXERCISE = "selectedExercise";
    private Exercice selectedExercise;

    public ExerciceFragment() {
        // Required empty public constructor
    }

    // Método estático para crear una instancia de DetailsFragment con un ejercicio seleccionado
    public static ExerciceFragment newInstance(Exercice exercice) {
        ExerciceFragment fragment = new ExerciceFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_EXERCISE, exercice);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedExercise = (Exercice) getArguments().getSerializable(ARG_EXERCISE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercice, container, false);

        TextView exerciseDetailsTextView = rootView.findViewById(R.id.exerciseDetailsTextView);

        if (selectedExercise != null) {
            // Obtener los detalles del ejercicio seleccionado y mostrarlos en el TextView
            String exerciseDetails = "Nombre: " + selectedExercise.getName();
            exerciseDetailsTextView.setText(exerciseDetails);
        }

        return rootView;
    }
}
