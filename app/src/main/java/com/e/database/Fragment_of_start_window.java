package com.e.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_of_start_window extends Fragment {
    public Fragment_of_start_window() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_of_start_window, container, false);

        EditText editTextMail = view.findViewById(R.id.mail);

        EditText editTextPassword  = view.findViewById(R.id.password);

        Button addButton = view.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_for_fragments, new FragmentOfRV())
                        .addToBackStack(FragmentOfRV.class.getSimpleName())
                        .commit();
            }
        }
        );

        return view;
    }
}
