package com.example.database;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTable3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTable3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTable3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTable3.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTable3 newInstance(String param1, String param2) {
        FragmentTable3 fragment = new FragmentTable3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        else {
            getAddresses();
        }
    }

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_table3, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list3);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
    private void getAddresses() {
        class GetAddresses extends AsyncTask<Void, Void, List<Addresses>> {

            @Override
            protected List<Addresses> doInBackground(Void... voids) {
                List<Addresses> taskList = DatabaseClient
                        .getInstance(getContext())
                        .getAppDatabase()
                        .CitizensDao()
                        .getAddresses();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Addresses> addresses) {
                super.onPostExecute(addresses);
                AddressesAdapter adapter = new AddressesAdapter(getContext(), addresses);
                recyclerView.setAdapter(adapter);
            }
        }

        GetAddresses gt = new GetAddresses();
        gt.execute();
    }
}