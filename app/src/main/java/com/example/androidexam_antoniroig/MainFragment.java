package com.example.androidexam_antoniroig;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private Exercice[] exercices = new Exercice[]
    {new Exercice("Exercice 1", R.drawable.running, "\n-Correr 10min\n-Descanso 5min\n-Correr 10min" ),
    new Exercice("Exercice 2", R.drawable.baile, "\nDescripcion"),
    new Exercice("Exercice 3", R.drawable.futbol, "\nDescripcion"),
    new Exercice("Exercice 4", R.drawable.pesas, "\nDescripcion")};
    private ListView exerciceList;
    private Adapter adapter;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        exerciceList = rootView.findViewById(R.id.listView);
        adapter = new Adapter(this.getActivity(), exercices);

        exerciceList.setAdapter(adapter);
        exerciceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Exercice selectedExercise = exercices[position];

                ExerciceFragment detailsFragment = ExerciceFragment.newInstance(selectedExercise);

                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.exerciceDetails, detailsFragment)
                            .addToBackStack(null)
                            .commit();
                } else {
                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, detailsFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        return rootView;
    }
}
