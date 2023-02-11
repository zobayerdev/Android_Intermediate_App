package com.hpsoft.usermadrasha.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hpsoft.usermadrasha.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,eeDepartment,MechanicalDepartment,BiochemistryDepartment,ChemistryDepartment,PhysicsDepartment,MathmeticsDepartment;
    private LinearLayout csNodata,eeNoData,mechanicalNoData,biochemistryNoData,chemistryNoData,physicsNoData,mathematicsNoData;
    private List<TeacherData> list1,list2,list3,list4,list5,list6,list7;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);

        //recyclervie find
        csDepartment = view.findViewById(R.id.csDepartment);
        eeDepartment = view.findViewById(R.id.eeDepartment);
        MechanicalDepartment = view.findViewById(R.id.MechanicalDepartment);
        BiochemistryDepartment = view.findViewById(R.id.BiochemistryDepartment);
        ChemistryDepartment = view.findViewById(R.id.ChemistryDepartment);
        PhysicsDepartment = view.findViewById(R.id.PhysicsDepartment);
        MathmeticsDepartment = view.findViewById(R.id.MathmeticsDepartment);

        //find noData
        csNodata =  view.findViewById(R.id.csNoData);
        eeNoData =  view.findViewById(R.id.eeNoData);
        mechanicalNoData =  view.findViewById(R.id.mechanicalNoData);
        biochemistryNoData =  view.findViewById(R.id.biochemistryNoData);
        chemistryNoData = view.findViewById(R.id.chemistryNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        mathematicsNoData = view.findViewById(R.id.mathematicsNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");


        // creating method
        csDepartment();
        eeDepartment();
        MechanicalDepartment();
        BiochemistryDepartment();
        ChemistryDepartment();
        PhysicsDepartment();
        MathmeticsDepartment();


        return view;
    }



    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    csNodata.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }
                else
                {

                    csNodata.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void eeDepartment() {
        dbRef = reference.child("Electrical Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }
                else
                {

                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    eeDepartment.setHasFixedSize(true);
                    eeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext());
                    eeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void MechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    MechanicalDepartment.setVisibility(View.GONE);
                }
                else
                {

                    mechanicalNoData.setVisibility(View.GONE);
                    MechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    MechanicalDepartment.setHasFixedSize(true);
                    MechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext());
                    MechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void BiochemistryDepartment() {
        dbRef = reference.child("Biochemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    biochemistryNoData.setVisibility(View.VISIBLE);
                    BiochemistryDepartment.setVisibility(View.GONE);
                }
                else
                {

                    biochemistryNoData.setVisibility(View.GONE);
                    BiochemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    BiochemistryDepartment.setHasFixedSize(true);
                    BiochemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext());
                    BiochemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void ChemistryDepartment() {

        dbRef = reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    chemistryNoData.setVisibility(View.VISIBLE);
                    ChemistryDepartment.setVisibility(View.GONE);
                }
                else
                {

                    chemistryNoData.setVisibility(View.GONE);
                    ChemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    ChemistryDepartment.setHasFixedSize(true);
                    ChemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5,getContext());
                    ChemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void PhysicsDepartment() {
        dbRef = reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    physicsNoData.setVisibility(View.VISIBLE);
                    PhysicsDepartment.setVisibility(View.GONE);
                }
                else
                {

                    physicsNoData.setVisibility(View.GONE);
                    PhysicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    PhysicsDepartment.setHasFixedSize(true);
                    PhysicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6,getContext());
                    PhysicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    private void MathmeticsDepartment() {
        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    mathematicsNoData.setVisibility(View.VISIBLE);
                    MathmeticsDepartment.setVisibility(View.GONE);
                }
                else
                {

                    mathematicsNoData.setVisibility(View.GONE);
                    MathmeticsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    MathmeticsDepartment.setHasFixedSize(true);
                    MathmeticsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7,getContext());
                    MathmeticsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}