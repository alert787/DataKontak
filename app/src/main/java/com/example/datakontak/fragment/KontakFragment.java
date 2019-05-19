//15-05-2019
//Muhammad Ilyas
//10116339
//IF -8

package com.example.datakontak.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datakontak.model.ContactModel;
import com.example.datakontak.R;
import com.example.datakontak.activity.TambahActivity;
import com.example.datakontak.adapter.RecyclerViewAdapter;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KontakFragment extends Fragment {

    View v;
    private RecyclerView myrecycleview;
    private static ArrayList<ContactModel> listkontak;
    private FloatingActionButton fab;
    public RecyclerViewAdapter adapter;


    public KontakFragment() {
        // Required empty public constructor
    }

    public static KontakFragment newInstance() {
        return new KontakFragment();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_kontak, container, false);
        myrecycleview = (RecyclerView) v.findViewById(R.id.rview);
        RecyclerViewAdapter recycleadapter = new RecyclerViewAdapter(getContext(),listkontak);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recycleadapter);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TambahActivity.class);
                startActivityForResult(i, 1);
            }

        });

        return v;
        // Inflate the layout for this fragment
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listkontak = new ArrayList<>();
        listkontak.add(new ContactModel("Beruang","10116111","IF-1","08925763257","beruang@bonbin.com","facebook.com/beruang",R.drawable.bear));
        listkontak.add(new ContactModel("Kucing","10116112","IF-2","08925763534","kucing@bonbin.com","facebook.com/kucing",R.drawable.cat));
        listkontak.add(new ContactModel("Anjing","10116113","IF-3","08925763957","anjing@bonbin.com","facebook.com/anjing",R.drawable.dog));
        listkontak.add(new ContactModel("Gajah","10116114","IF-4","08957963257","gajah@bonbin.com","facebook.com/gajah",R.drawable.elephant));
        listkontak.add(new ContactModel("Gorila","10116115","IF-5","08925571257","gorila@bonbin.com","facebook.com/gorila",R.drawable.gorilla));
        listkontak.add(new ContactModel("Macan","10116116","IF-6","08928643257","macan@bonbin.com","facebook.com/macan",R.drawable.tiger));

    }



    public static void tambah(ContactModel c){
        listkontak.add(new ContactModel(c));

        //adapter.setData(listkontak);

    }
}
