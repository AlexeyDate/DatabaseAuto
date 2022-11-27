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
 * Use the {@link FragmentTable2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTable2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTable2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTable2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTable2 newInstance(String param1, String param2) {
        FragmentTable2 fragment = new FragmentTable2();
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
               getCars();
        }
    }

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_table2, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list2);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    private void getCars() {
        class GetCars extends AsyncTask<Void, Void, List<Cars>> {

            @Override
            protected List<Cars> doInBackground(Void... voids) {
                List<Cars> taskList = DatabaseClient
                        .getInstance(getContext())
                        .getAppDatabase()
                        .CitizensDao()
                        .getCars();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Cars> cars) {
                super.onPostExecute(cars);
                CarsAdapter adapter = new CarsAdapter(getContext(), cars);
                recyclerView.setAdapter(adapter);
            }
        }

        GetCars gt = new GetCars();
        gt.execute();
    }
}