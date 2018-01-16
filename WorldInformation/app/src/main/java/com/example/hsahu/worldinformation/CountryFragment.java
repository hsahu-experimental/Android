package com.example.hsahu.worldinformation;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hsahu.worldinformation.adapter.CardAdapter;
import com.example.hsahu.worldinformation.dto.Country;
import com.example.hsahu.worldinformation.dto.CountryListDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = getActivity().getAssets().open("all.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            CountryListDTO countryListDTO = new Gson().fromJson(br, CountryListDTO.class);
            countries = countryListDTO.getCountries();
            System.out.println(countries.toString());
        } catch (IOException e) {

        }
        mAdapter = new CardAdapter(countries, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
