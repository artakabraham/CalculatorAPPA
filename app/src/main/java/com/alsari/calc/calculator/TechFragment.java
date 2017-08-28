package com.alsari.calc.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;

public class TechFragment extends Fragment {

    private TextView Sum;

    public TechFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View techView =  inflater.inflate(R.layout.fragment_tech, container, false);

        getActivity().setTitle(R.string.title_activity_tech);

        RadioGroup radioGroup = (RadioGroup) techView.findViewById(R.id.rGroup);
        Sum = (TextView) techView.findViewById(R.id.Sum);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            double price = 1;

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.CarRB:
                        price = 8000;
                        break;
                    case R.id.MinubusRB:
                        price = 10000;
                        break;
                    case R.id.BusRB:
                        price = 13000;
                        break;
                    case R.id.TrkTo35RB:
                        price = 10000;
                        break;
                    case R.id.TrkFrom35:
                        price = 13000;
                        break;
                    case R.id.TrailerRB:
                        price = 6000;
                        break;
                    case R.id.MotoRB:
                        price = 6000;
                        break;
                    default:
                        break;
                }

                DecimalFormat df = new DecimalFormat("###,###,###");

                String str = df.format(price)+" "+getText(R.string.dram);

                Sum.setText(str);
            }
        });

        return techView;
    }
}
