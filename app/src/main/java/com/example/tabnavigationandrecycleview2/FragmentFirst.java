package com.example.tabnavigationandrecycleview2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class FragmentFirst extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private ArrayList<ItemData> itemValues;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private View addButton;
    //private Button addButton;


    public FragmentFirst() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_first, container,false);

        // mengacu pada UI recyleView
        recyclerView = view.findViewById(R.id.recycleView);

        // mengacu pada UI addButton
        addButton = view.findViewById(R.id.addButton);

        // Membuat data dummy
        // membuat array pada itemValues yang menyimpan semua itemdata
        itemValues = new ArrayList<>();

        // Membuat 10 data
        for (int i=1; i<=10; i++ ){
            // membuat item data
            ItemData item = new ItemData();

            // memasukan data ke item data pada title
            item.itemTitle = "Title Data - " + i;

            // memasukan data ke item data pada subtitle
            item.itemSubTitle = "Subtitle Data - " + i;

            //Menambah item data pada item value
            itemValues.add(item);
        }
        // membuat itemAdapter dari data item values
        itemAdapter = new ItemAdapter(getActivity(),itemValues);

        //menampilkan data
        // menampilkan list vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,   false);
        //LinearLayoutManager layoutManager1 = new Line

        // Menset Recycleview dengan layout manger yang dibuat (penampilan)
        recyclerView.setLayoutManager(layoutManager);

        // Menset Recycleview dengan item adapter yang dibuat (data)
        recyclerView.setAdapter(itemAdapter);

        // mebuat button add click
        addButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                addData();
            }
         });
        return view;
    }

    private void addData(){
        ItemData item = new ItemData();
        item.itemTitle = "Title Data yang Baru";
        item.itemSubTitle = "Subtitle Data yang Baru";
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }

}
