package com.e.database;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentOfRV extends Fragment {

    public FragmentOfRV() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_of_rv, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);


        return view;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView number;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            number = itemView.findViewById(R.id.number_from_rv);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Fragment_of_number NewNumber = new Fragment_of_number();
                    NewNumber.SetArguments(((TextView) v.findViewById(R.id.number_from_rv)).getText().toString()
                            ,((TextView) v.findViewById(R.id.number_from_rv)).getCurrentTextColor());
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container_of_fragments, NewNumber)
                            .addToBackStack(Fragment_of_number.class.getSimpleName()).commit();
                }
            });
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        DataSource.NumberModel element = Data.get(position);
        holder.number.setText(String.valueOf(element.getNumber()));
        holder.number.setTextColor(element.getColor());
    }

    @Override
    public int getItemCount() {return Data.size();}

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
    {

    }
}
