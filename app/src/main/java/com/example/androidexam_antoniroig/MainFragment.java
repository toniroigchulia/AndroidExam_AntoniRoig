package com.example.androidexam_antoniroig;
// MainFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private Exercice[] exercices = new Exercice[]{new Exercice("Exercice 1"), new Exercice("Exercice 2"),
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
        // Inflate the layout for this fragment
        return rootView;
    }
}
