package com.example.androidexam_antoniroig;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private Exercice[] exercices = new Exercice[]
    {new Exercice("Exercice 1"), new Exercice("Exercice 2"),
    new Exercice("Exercice 3"), new Exercice("Exercice 4")};
    private ListView exerciceList;
    private Adapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        exerciceList = rootView.findViewById(R.id.listView);
        adapter = new Adapter(this.getActivity(), exercices);

        exerciceList.setAdapter(adapter);
        // Manejar clics en elementos del ListView
        exerciceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Exercice selectedExercise = exercices[position];

                // Crear un nuevo fragmento para mostrar información específica del ejercicio seleccionado
                ExerciceFragment detailsFragment = ExerciceFragment.newInstance(selectedExercise);

                // Iniciar la transacción para reemplazar el fragmento actual con el fragmento de detalles
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, detailsFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return rootView;
    }
}
