package com.hpsoft.usermadrasha.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hpsoft.usermadrasha.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout= view.findViewById(R.id.slider);
        map = view.findViewById(R.id.map);


        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3); // koto second cholbe ei sliding ta

        setSliderViews();


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });





        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Bungladesh University Of Business and Technology");
        Intent map = new Intent(Intent.ACTION_VIEW,uri);
        map.setPackage("com.google.android.apps.maps");
        startActivity(map);
    }


    // animation image er code eita

    private void setSliderViews() {
        for(int i=0; i<5; i++)
        {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image1.jpg?alt=media&token=584d6ea7-5ff3-4750-8105-accdc0efff0c");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image2.jpg?alt=media&token=69e97141-e692-4263-a87b-e90edb21e8c5");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image3.jpg?alt=media&token=81ae50db-fedb-41b0-ae4f-d6aceffb94e3");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image4.jpg?alt=media&token=bb8a078c-f5a6-449e-8bcc-f2b2dbf5cb8d\n");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/madrasha-app.appspot.com/o/image5.jpg?alt=media&token=f7937f13-1046-4c6c-8416-ba202954507c");
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER);

            sliderLayout.addSliderView(sliderView);
        }
    }
}