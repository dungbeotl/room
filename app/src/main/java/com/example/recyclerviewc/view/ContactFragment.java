package com.example.recyclerviewc.view;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewc.R;
import com.example.recyclerviewc.model.Contact;
import com.example.recyclerviewc.model.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    private static final String TAG = "FragmentContact";

    private RecyclerView recyclerView;
    private List<Contact> contactList;
    private View view;
    FloatingActionButton fab;


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_contact);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();

        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
        contactList.add(new Contact("Dung Beo","0968207775",R.drawable.usertwo));
    }


}
