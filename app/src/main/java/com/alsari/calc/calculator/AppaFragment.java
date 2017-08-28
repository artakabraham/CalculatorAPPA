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

public class AppaFragment extends Fragment {

    private Spinner CarType, CarUseType, CarPower, CarTrailer, Driver, BM, Time;
    private View CarUseTypeLabel, CarPowerLabel, CarTrailerLabel;
    private TextView Sum;

    public AppaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View appaView = inflater.inflate(R.layout.fragment_appa, container, false);

        getActivity().setTitle(R.string.title_activity_appa);

        // Find Views
        CarType = (Spinner) appaView.findViewById(R.id.carType_spinner);
        CarUseType = (Spinner) appaView.findViewById(R.id.CarUseType_spinner);
        CarPower = (Spinner) appaView.findViewById(R.id.CarPower_spinner);
        CarTrailer = (Spinner) appaView.findViewById(R.id.CarTrailer_spinner);
        Driver = (Spinner) appaView.findViewById(R.id.Driver_spinner);
        BM = (Spinner) appaView.findViewById(R.id.DriverBM_spinner);
        Time = (Spinner) appaView.findViewById(R.id.time);
        Sum = (TextView) appaView.findViewById(R.id.sum);

        CarUseTypeLabel = appaView.findViewById(R.id.CarUseType_textView);
        CarPowerLabel = appaView.findViewById(R.id.CarPower_textView);
        CarTrailerLabel = appaView.findViewById(R.id.CarTrailer_textView);

        // Set spinner default position
        BM.setSelection(9);

        AdapterView.OnItemSelectedListener myListner = new AdapterView.OnItemSelectedListener() {

            double r1 = 1; //ԱՄ Տեսակ
            double r2 = 1; // Շահագործման նպատակ
            double r3 = 1; // Շարժիչի հզորություն
            double r4 = 1; // Կցորդի առկայություն
            double r5 = 1; // Վարորդի տարիք / ստաժ
            double r6 = 1; //Բոնուս-Մալուս դաս
            double r7 = 1; // Գործողության ժամկետ

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int CarType_selected = CarType.getSelectedItemPosition();
                int CarUseType_selected = CarUseType.getSelectedItemPosition();
                int CarPower_selected = CarPower.getSelectedItemPosition();
                int CarTrailer_selected = CarTrailer.getSelectedItemPosition();
                int Driver_selected = Driver.getSelectedItemPosition();
                int BM_selected = BM.getSelectedItemPosition();
                int Time_selected = Time.getSelectedItemPosition();

                if (CarType_selected == 1) {
                    CarUseType.setVisibility(View.GONE);
                    CarUseTypeLabel.setVisibility(View.GONE);
                    CarPower.setVisibility(View.VISIBLE);
                    CarPowerLabel.setVisibility(View.VISIBLE);
                    CarTrailer.setVisibility(View.VISIBLE);
                    CarTrailerLabel.setVisibility(View.VISIBLE);
                } else if (CarType_selected == 2) {
                    CarPower.setVisibility(View.GONE);
                    CarPowerLabel.setVisibility(View.GONE);
                    CarTrailer.setVisibility(View.GONE);
                    CarTrailerLabel.setVisibility(View.GONE);
                    CarUseType.setVisibility(View.VISIBLE);
                    CarUseTypeLabel.setVisibility(View.VISIBLE);
                } else if (CarType_selected == 3) {
                    CarUseType.setVisibility(View.GONE);
                    CarUseTypeLabel.setVisibility(View.GONE);
                    CarPower.setVisibility(View.GONE);
                    CarPowerLabel.setVisibility(View.GONE);
                    CarTrailer.setVisibility(View.GONE);
                    CarTrailerLabel.setVisibility(View.GONE);
                } else if (CarType_selected == 4) {
                    CarPower.setVisibility(View.GONE);
                    CarPowerLabel.setVisibility(View.GONE);
                    CarUseType.setVisibility(View.VISIBLE);
                    CarUseTypeLabel.setVisibility(View.VISIBLE);
                    CarTrailer.setVisibility(View.VISIBLE);
                    CarTrailerLabel.setVisibility(View.VISIBLE);
                } else {
                    CarUseType.setVisibility(View.VISIBLE);
                    CarUseTypeLabel.setVisibility(View.VISIBLE);
                    CarPower.setVisibility(View.VISIBLE);
                    CarPowerLabel.setVisibility(View.VISIBLE);
                    CarTrailer.setVisibility(View.VISIBLE);
                    CarTrailerLabel.setVisibility(View.VISIBLE);
                }

                //ԱՄ Տեսակ

                if (CarType_selected == 0) {
                    r1 = 1;
                } else if (CarType_selected == 1) {
                    r1 = 1.12;
                } else if (CarType_selected == 2) {
                    r1 = 0.585095549260147;
                } else if (CarType_selected == 3) {
                    r1 = 1.1;
                } else if (CarType_selected == 4) {
                    r1 = 0.593091351307001;
                }


                // Շահագործման նպատակ

                if (CarUseType_selected == 0) {
                    r2 = 1;
                } else if (CarUseType_selected == 1) {
                    r2 = 1.03029202701789;
                } else if (CarUseType_selected == 2) {
                    r2 = 1.43556531031785;
                } else if (CarUseType_selected == 3) {
                    r2 = 1.43556531031785;
                } else if (CarUseType_selected == 4) {
                    r2 = 1.03029202701789;
                }


                // Շարժիչի հզորություն

                if (CarPower_selected == 0) {
                    r3 = 0.8;
                } else if (CarPower_selected == 1) {
                    r3 = 1;
                } else if (CarPower_selected == 2) {
                    r3 = 1.27272727272727;
                } else if (CarPower_selected == 3) {
                    r3 = 1.45;
                }

// Գործակիցների սահմանում

                //Մոտոտրանսպորտ, այլ ձիաուժ
                if (r1 == 0.585095549260147 || r1 == 0.593091351307001) {
                    r3 = 1;
                }

                //Ավտոբուսի ձիաուժ
                if (r1 == 1.1) {
                    r2 = 1.03029202701789;
                    r3 = 1;
                }

                //Բեռնատարի ձիաուժ
                if (r1 == 1.12 & r3 == 0.8) {
                    r3 = 0.71428571428571;
                    r2 = 1.03029202701789;
                } else if (r1 == 1.12 & (r3 == 1 || r3 == 1.27272727272727 || r3 == 1.45)) {
                    r3 = 1;
                    r2 = 1.03029202701789;
                }


                //Կցորդի առկայություն

                if (CarTrailer_selected == 1) {

                    if (r1 == 0.593091351307001) {
                        r4 = 1.2;
                    } else  // Այլ կցորդով

                        if (r1 == 1.12 & r3 == 0.71428571428571) {
                            r4 = 1.11;
                        } else // Բեռնատար կցորդով

                            if (r1 == 1.12 & (r3 == 1 || r3 == 1.27272727272727 || r3 == 1.45)) {
                                r4 = 1.19;
                            } else // Ոչ բեռնատար կցորդով

                                if (r1 == 1 & (r2 == 1 || r2 == 1.03029202701789)) {
                                    r4 = 1.11;
                                } else if (r1 == 1 & r2 == 1.43556531031785) {
                                    r4 = 1.08;
                                }

                } else {
                    r4 = 1;
                }

                // Վարորդի տարիք / ստաժ

                if (Driver_selected == 0) {
                    r5 = 1;
                } else if (Driver_selected == 1) {
                    r5 = 1.09;
                } else if (Driver_selected == 2) {
                    r5 = 1.35751882988766;
                } else if (Driver_selected == 3) {
                    r5 = 1.47;
                } else if (Driver_selected == 4) {
                    r5 = 1.6;
                }


                //Բոնուս-Մալուս դաս

                if (BM_selected == 0) {
                    r6 = 0.5;
                } else if (BM_selected == 1) {
                    r6 = 0.65;
                } else if (BM_selected == 2) {
                    r6 = 0.75;
                } else if (BM_selected == 3) {
                    r6 = 0.82;
                } else if (BM_selected == 4) {
                    r6 = 0.85;
                } else if (BM_selected == 5) {
                    r6 = 0.88;
                } else if (BM_selected == 6) {
                    r6 = 0.91;
                } else if (BM_selected == 7) {
                    r6 = 0.94;
                } else if (BM_selected == 8) {
                    r6 = 0.97;
                } else if (BM_selected == 9) {
                    r6 = 1;
                } else if (BM_selected == 10) {
                    r6 = 1.04;
                } else if (BM_selected == 11) {
                    r6 = 1.08;
                } else if (BM_selected == 12) {
                    r6 = 1.12;
                } else if (BM_selected == 13) {
                    r6 = 1.16;
                } else if (BM_selected == 14) {
                    r6 = 1.2;
                } else if (BM_selected == 15) {
                    r6 = 1.28;
                } else if (BM_selected == 16) {
                    r6 = 1.36;
                } else if (BM_selected == 17) {
                    r6 = 1.44;
                } else if (BM_selected == 18) {
                    r6 = 1.52;
                } else if (BM_selected == 19) {
                    r6 = 1.6;
                } else if (BM_selected == 20) {
                    r6 = 1.8;
                } else if (BM_selected == 21) {
                    r6 = 2;
                }


                // Գործողության ժամկետ

                if (Time_selected == 0) {
                    r7 = 1;
                } else if (Time_selected == 1) {
                    r7 = 0.95;
                } else if (Time_selected == 2) {
                    r7 = 0.85;
                } else if (Time_selected == 3) {
                    r7 = 0.77;
                } else if (Time_selected == 4) {
                    r7 = 0.7;
                } else if (Time_selected == 5) {
                    r7 = 0.65;
                } else if (Time_selected == 6) {
                    r7 = 0.6;
                } else if (Time_selected == 7) {
                    r7 = 0.5;
                } else if (Time_selected == 8) {
                    r7 = 0.4;
                } else if (Time_selected == 9) {
                    r7 = 0.33;
                } else if (Time_selected == 10) {
                    r7 = 0.25;
                } else if (Time_selected == 11) {
                    r7 = 0.2;
                } else if (Time_selected == 12) {
                    r7 = 0.15;
                } else if (Time_selected == 13) {
                    r7 = 0.1;
                }

                double total = 33122 * r1 * r2 * r3 * r4 * r5;

                double total_round = Math.round(total / 1000) * 1000;

                double premium = total_round * r6 * r7;

                DecimalFormat df = new DecimalFormat("###,###,###");

                String str = df.format(premium)+" "+getText(R.string.dram);

                Sum.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        }; //OnItemSelectedListener

        CarType.setOnItemSelectedListener(myListner);
        CarUseType.setOnItemSelectedListener(myListner);
        CarPower.setOnItemSelectedListener(myListner);
        CarTrailer.setOnItemSelectedListener(myListner);
        Driver.setOnItemSelectedListener(myListner);
        BM.setOnItemSelectedListener(myListner);
        Time.setOnItemSelectedListener(myListner);

        return appaView;
    }
}
