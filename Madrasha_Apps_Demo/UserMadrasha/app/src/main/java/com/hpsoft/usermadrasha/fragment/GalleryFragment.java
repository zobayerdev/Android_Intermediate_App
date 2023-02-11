package com.hpsoft.usermadrasha.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hpsoft.usermadrasha.R;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView convoRecycler, examRecycler,readRecycler,mahfilRecycler;
    GalleryAdapter adapter;
    
    DatabaseReference reference;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        
        convoRecycler=view.findViewById(R.id.convoRecycler);
        examRecycler = view.findViewById(R.id.examRecycler);
/*        readRecycler = view.findViewById(R.id.readRecycler);
        mahfilRecycler = view.findViewById(R.id.mahfilRecycler);*/
        
        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");
        
        getConvoImage();
        
        getExamImage();

/*        getReadImage();
        
        getMahfilImage();*/
        

        return view;
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> images = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data1 = " "+snapshot.getValue();
                    images.add(data1);
                }

                adapter = new GalleryAdapter(getContext(),images);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getExamImage() {

        reference.child("Exam Time").addValueEventListener(new ValueEventListener() {

            List<String> images = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data2 = " "+snapshot.getValue();
                    images.add(data2);
                }

                adapter = new GalleryAdapter(getContext(),images);
                examRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                examRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

/*    private void getReadImage() {

        reference.child("Reading Time").addValueEventListener(new ValueEventListener() {

            List<String> images = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data3 = " "+ snapshot.getValue();
                    images.add(data3);
                }

                adapter = new GalleryAdapter(getContext(),images);
                readRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                readRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getMahfilImage() {

        reference.child("Mahfil").addValueEventListener(new ValueEventListener() {

            List<String> images = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String data4 = " "+ snapshot.getValue();
                    images.add(data4);
                }

                adapter = new GalleryAdapter(getContext(),images);
                mahfilRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                mahfilRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }*/


}