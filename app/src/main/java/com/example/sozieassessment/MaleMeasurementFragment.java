package com.example.sozieassessment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class MaleMeasurementFragment extends Fragment {


    RadioGroup measurementGroup;
    RadioButton inchRB,cmRB;
    EditText heightFeet, heightIn, waistET, hipsET, chest;
    TextView unitLabelFT, unitLabelIn, waistMeasureLabelIn, hipsMeasureLabelIn, chestLabelIn;
    View heightDividerView;

    String selectedMeasurement = "inch";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_male_measurement, container, false);
        measurementGroup = view.findViewById(R.id.scaleRG);
        inchRB = view.findViewById(R.id.inchRB);
        cmRB = view.findViewById(R.id.centiRB);

        heightDividerView = view.findViewById(R.id.heightDividerView);

        //Unit textView init
        unitLabelFT = view.findViewById(R.id.unitLabelFT);
        unitLabelIn = view.findViewById(R.id.unitLabelIn);
        waistMeasureLabelIn = view.findViewById(R.id.waistMeasureLabelIn);
        hipsMeasureLabelIn = view.findViewById(R.id.hipsMeasureLabelIn);
        chestLabelIn = view.findViewById(R.id.chestIn);

        //Edittext fields init
        heightFeet = view.findViewById(R.id.heightFeet);
        heightIn = view.findViewById(R.id.heightInch);
        waistET = view.findViewById(R.id.waist);
        hipsET = view.findViewById(R.id.hips);
        chest = view.findViewById(R.id.chest);

        measurementGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == R.id.inchRB){
                    measurementGroup.setBackgroundResource(R.drawable.inch_tab);
                    selectedMeasurement = "inch";
                    inchRB.setTextColor(Color.parseColor("#FFFFFF"));
                    cmRB.setTextColor(Color.parseColor("#000000"));
                    heightFeet.setVisibility(View.VISIBLE);
                    unitLabelFT.setVisibility(View.VISIBLE);
                    heightDividerView.setVisibility(View.VISIBLE);
                    unitLabelIn.setText("in");
                    waistMeasureLabelIn.setText("in");
                    hipsMeasureLabelIn.setText("in");
                    chestLabelIn.setText("in");
                }else{
                    measurementGroup.setBackgroundResource(R.drawable.centi_tab);
                    selectedMeasurement = "centi";
                    inchRB.setTextColor(Color.parseColor("#000000"));
                    cmRB.setTextColor(Color.parseColor("#FFFFFF"));
                    heightFeet.setVisibility(View.GONE);
                    unitLabelFT.setVisibility(View.GONE);
                    heightDividerView.setVisibility(View.GONE);
                    unitLabelIn.setText("cm");
                    waistMeasureLabelIn.setText("cm");
                    hipsMeasureLabelIn.setText("cm");
                    chestLabelIn.setText("cm");
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MaleMeasurementFragment.this)
                        .navigate(R.id.action_MaleFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.measurementGuideText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MaleMeasurementFragment.this)
                        .navigate(R.id.action_MaleFragment_to_MaleTipsFragment);
            }
        });
    }
}