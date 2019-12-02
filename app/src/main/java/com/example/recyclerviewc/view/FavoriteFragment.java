package com.example.recyclerviewc.view;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewc.R;
import com.example.recyclerviewc.model.Contact;
import com.example.recyclerviewc.model.FavoriteAdapter;
import com.example.recyclerviewc.viewmodel.FContactViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    public static final int NEW_ACTIVITY_REQUEST_CODE = 1;
    public FloatingActionButton fabAdd;
    private FavoriteAdapter favoriteAdapter;
    private RecyclerView recyclerView;
    // private FavoriteAdapter favoriteAdapter;
    private FContactViewModel mViewModel;


    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.favoRecyclerView_contact);
        fabAdd = view.findViewById(R.id.fabAddFavorite);

        favoriteAdapter = new FavoriteAdapter(getContext());
        recyclerView.setAdapter(favoriteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mViewModel = ViewModelProviders.of(this).get(FContactViewModel.class);
        // Add an observer on the LiveData returned by getmAllFContacts.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.

        fabAdd.setOnClickListener(v -> {
            //      Toast.makeText(getContext(),"ddddd",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(), AddContactActivity.class);
            //  intent.putExtra("Name_key",20);
            startActivityForResult(intent, NEW_ACTIVITY_REQUEST_CODE);
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.getmAllFContacts().observe(this, contacts -> {
            // Update the cached copy of the contact in the adapter.
            favoriteAdapter.setFContact(contacts);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case NEW_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    //String result = data.getStringExtra(AddContactActivity.EXTRA_DATA);
                    Bundle bundle = data.getExtras();

                    String name = bundle.getString("NAME_KEY");
                    String phone = bundle.getString("PHONE_KEY");
                    if (!name.equals("") && !phone.equals("")) {
                        Contact fcontact = new Contact(name, phone, R.drawable.usertwo);
                        mViewModel.insert(fcontact);
                        Toast.makeText(getActivity(), "Result: " + name + phone, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(), "Result null ", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
