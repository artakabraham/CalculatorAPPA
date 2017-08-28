package com.alsari.calc.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoFragment extends Fragment {

    private Spinner coCarType, coCarEngine;
    private TextView CoSum;

    public CoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View coView =  inflater.inflate(R.layout.fragment_co, container, false);

        getActivity().setTitle(R.string.title_activity_co);

        CoSum = (TextView) coView.findViewById(R.id.sum);;
        coCarType = (Spinner) coView.findViewById(R.id.coCarType);
        coCarEngine = (Spinner) coView.findViewById(R.id.coCarEngine);

        ArrayAdapter carEngine = ArrayAdapter.createFromResource(getActivity(), R.array.coCarEngine, R.layout.spinner);
        coCarEngine.setAdapter(carEngine);

        ArrayAdapter carType = ArrayAdapter.createFromResource(getActivity(), R.array.coCarType, R.layout.spinner);
        coCarType.setAdapter(carType);

        AdapterView.OnItemSelectedListener coListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int CarTypeValues[] = {2500, 5000, 10000, 5000, 10000, 15000};
                int coCarType_selected = coCarType.getSelectedItemPosition();
                int CarTypеSum = CarTypeValues[coCarType_selected];

                double CarEngineValues[] = {0.3, 1.2, 1, 0.15, 1, 0.5, 0.35};
                int coCarEngine_selected = coCarEngine.getSelectedItemPosition();
                double CarEnginSum = CarEngineValues[coCarEngine_selected];

                double sum = CarTypеSum * CarEnginSum;

                DecimalFormat df = new DecimalFormat("###,###,###");

                String str = df.format(sum)+" "+getText(R.string.dram);

                CoSum.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        coCarType.setOnItemSelectedListener(coListener);
        coCarEngine.setOnItemSelectedListener(coListener);

        return coView;
    }

}
