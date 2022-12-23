package com.ades.tes1;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private String[] dataName;
    private TypedArray datapoto;
    private Hubung hubung;
    private ArrayList<Gambar> heroes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = view.findViewById(R.id.lv_list);
        hubung = new Hubung(getContext());
        listView.setAdapter(hubung);

        prepare();
        additem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), Ayambakar.class);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(view.getContext(), Buburayam.class);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(view.getContext(), Gadogado.class);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(view.getContext(), geprek.class);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(view.getContext(), martabak.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }


    private void additem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Gambar hero = new Gambar();
            hero.setPhoto(datapoto.getResourceId(i, -1));
            hero.setNama(dataName[i]);
            heroes.add(hero);
        }
        hubung.setHeroes(heroes);
    }
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datapoto = getResources().obtainTypedArray(R.array.datapoto);
    }

}