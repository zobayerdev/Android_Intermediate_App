package com.hpsoft.usermadrasha.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hpsoft.usermadrasha.BranchAdapter;
import com.hpsoft.usermadrasha.BranchModel;
import com.hpsoft.usermadrasha.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        list = new ArrayList<>();

        // eikhane madrasha r sob details likhe dite hobe department er jate sobai porte pare.
        list.add(new BranchModel(R.drawable.ic_cse, "Computer Science","Computer science is the study of computation, automation, and information.[1] Computer science spans theoretical disciplines, such as algorithms, theory of computation, and information theory, to practical disciplines including the design and implementation of hardware and software.[2][3] Computer science is generally considered an area of academic research and distinct from computer programming."));
        list.add(new BranchModel(R.drawable.ic_mechnical, "Mechanical Science","Mechanical engineering is an engineering branch that combines engineering physics and mathematics principles with materials science, to design, analyze, manufacture, and maintain mechanical systems.[1] It is one of the oldest and broadest of the engineering branches."));


        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);


        ImageView imageview = view.findViewById(R.id.collage_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image1.jpg?alt=media&token=584d6ea7-5ff3-4750-8105-accdc0efff0c")
                .into(imageview);


        return view;
    }


}