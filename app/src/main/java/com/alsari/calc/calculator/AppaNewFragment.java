package com.alsari.calc.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class AppaNewFragment extends Fragment {

    private Spinner CarType, CarUseType, CarPower, carSeatSpinner, BM, period;
    private View carSeatsLabel, CarUseTypeLabel, CarPowerLabel;
    private TextView premiumView;

    public AppaNewFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View appaNewFragment = inflater.inflate(R.layout.fragment_appa_new, container, false);

        getActivity().setTitle(R.string.title_activity_appa);

        premiumView = (TextView) appaNewFragment.findViewById(R.id.premium);
        CarType = (Spinner) appaNewFragment.findViewById(R.id.carType_spinner);
        CarUseType = (Spinner) appaNewFragment.findViewById(R.id.CarUseType_spinner);
        CarPower = (Spinner) appaNewFragment.findViewById(R.id.CarPower_spinner);
        carSeatSpinner = (Spinner) appaNewFragment.findViewById(R.id.carSeatSpinner);
        BM = (Spinner) appaNewFragment.findViewById(R.id.DriverBM_spinner);
        period = (Spinner) appaNewFragment.findViewById(R.id.period);

        carSeatsLabel = appaNewFragment.findViewById(R.id.carSeatsView);
        CarUseTypeLabel = appaNewFragment.findViewById(R.id.CarUseType_textView);
        CarPowerLabel = appaNewFragment.findViewById(R.id.CarPower_textView);

        AdapterView.OnItemSelectedListener myListner = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int carTypePosition = CarType.getSelectedItemPosition();
                int carUseTypePosition = CarUseType.getSelectedItemPosition();
                int carPowerPosition = CarPower.getSelectedItemPosition();
                int BM_selected = BM.getSelectedItemPosition();
                int periodPosition = period.getSelectedItemPosition();
                int carSeatPosition = carSeatSpinner.getSelectedItemPosition();

                if (carTypePosition != 2) {
                    carSeatsLabel.setVisibility(View.GONE);
                    carSeatSpinner.setVisibility(View.GONE);
                } else {
                    carSeatsLabel.setVisibility(View.VISIBLE);
                    carSeatSpinner.setVisibility(View.VISIBLE);
                }

                if (carTypePosition != 0) {
                    CarUseTypeLabel.setVisibility(View.GONE);
                    CarUseType.setVisibility(View.GONE);
                } else {
                    CarUseTypeLabel.setVisibility(View.VISIBLE);
                    CarUseType.setVisibility(View.VISIBLE);
                }
                if (carTypePosition == 0 || carTypePosition == 1) {
                    CarPowerLabel.setVisibility(View.VISIBLE);
                    CarPower.setVisibility(View.VISIBLE);
                } else {
                    CarPowerLabel.setVisibility(View.GONE);
                    CarPower.setVisibility(View.GONE);
                }

                int basePremium = 33122;

                double carTypeArray[] = {1, 1.185, 0, 0.59, 0.59};
                double carTypeR = carTypeArray[carTypePosition];

                double carSeatsArray[] = {1.44, 1.133};
                double carSeatsR = carSeatsArray[carSeatPosition];

                double carPowerArray[] = {0.8, 1, 1.38, 1.64};
                double carPowerR = carPowerArray[carPowerPosition];

                double carUseType[] = {1, 1.03, 1.8, 1};
                double carUseTypeR = carUseType[carUseTypePosition];

                double bmArray[] = {1,0.5,0.65,0.75,0.82,0.85,0.88,0.91,0.94,0.97,1,1.04,1.08,1.12,1.16,1.24,1.32,1.4,1.44,2,2.5,2.5,2.5};
                double bmR = bmArray[BM_selected];

                double period[] = {1, 0.95, 0.85, 0.77, 0.7, 0.65, 0.6, 0.5, 0.4, 0.33, 0.25, 0.2, 0.15, 0.1};
                double periodR = period[periodPosition];

                if (carTypeR != 0)
                    carSeatsR = 1;

                if (carTypeR == 0) {
                    carTypeR = 1;
                    carPowerR = 1;
                    carUseTypeR = 1;
                }
                if(carTypeR == 0.59){
                    carSeatsR = 1;
                    carPowerR = 1;
                    carUseTypeR = 1;
                }
                if(carTypeR == 1.185)
                    carUseTypeR = 1;

                if(carTypeR == 1.185 && carPowerR == 1.38)
                    carPowerR = 1.09;

                if(carTypeR == 1.185 && carPowerR == 1.64)
                    carPowerR = 1.1;

                double premium = basePremium * carTypeR * carSeatsR * carPowerR * carUseTypeR * bmR * periodR;

                premium = Math.round(premium / 1000) * 1000;

                DecimalFormat df = new DecimalFormat("###,###,###");

                String str = df.format(premium)+" "+getText(R.string.dram);

                premiumView.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };//OnItemSelectedListener

        CarType.setOnItemSelectedListener(myListner);
        CarUseType.setOnItemSelectedListener(myListner);
        CarPower.setOnItemSelectedListener(myListner);
        carSeatSpinner.setOnItemSelectedListener(myListner);
        BM.setOnItemSelectedListener(myListner);
        period.setOnItemSelectedListener(myListner);

        return appaNewFragment;
    }

}
