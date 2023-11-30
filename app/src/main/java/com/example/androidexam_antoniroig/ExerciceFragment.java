package com.example.androidexam_antoniroig;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class ExerciceFragment extends Fragment {

    private static final String ARG_EXERCISE = "selectedExercise";
    private Exercice selectedExercise;

    public ExerciceFragment() {

    }

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
        ImageView exerciseDetailImage = rootView.findViewById(R.id.image);

        if (selectedExercise != null) {
            String exerciseDetails = "Nombre: " + selectedExercise.getName() +"\n"+ selectedExercise.getDescription();
            exerciseDetailsTextView.setText(exerciseDetails);
            exerciseDetailImage.setImageResource(selectedExercise.getImageResource());
        }

        return rootView;
    }
}
