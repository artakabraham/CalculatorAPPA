package com.alsari.calc.calculator;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class PropertyFragment extends Fragment {

    private Spinner CarType, ProdDate, taxBase;
    private TextView Sum, Power;
    private Button Calc;

    public PropertyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View propertyView =  inflater.inflate(R.layout.fragment_property, container, false);

        getActivity().setTitle(R.string.title_activity_property);

        //Hide SoftKeyboard on startUp
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        CarType = (Spinner) propertyView.findViewById(R.id.carType_spinner);
        ProdDate = (Spinner) propertyView.findViewById(R.id.ProdDate);
        taxBase = (Spinner) propertyView.findViewById(R.id.taxBase);
        Power = (TextView) propertyView.findViewById(R.id.Power);
        Calc  = (Button) propertyView.findViewById(R.id.calc);
        Sum = (TextView) propertyView.findViewById(R.id.sum);

        AdapterView.OnItemSelectedListener myListener = new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int taxBase_selected = taxBase.getSelectedItemPosition();
                if(taxBase_selected == 0) {
                    Power.setHint(R.string.hp);
                } else if (taxBase_selected == 1) {
                    Power.setHint(R.string.kw);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        // Calculate
        View.OnClickListener myClick = new View.OnClickListener(){
            double price = 1;
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(Power.getText().toString())){
                    Toast.makeText(getActivity(), R.string.alert,
                            Toast.LENGTH_LONG).show();
                    return;
                }

                int CarType_selected = CarType.getSelectedItemPosition();
                int taxBase_selected = taxBase.getSelectedItemPosition();
                int ProdDate_selected = ProdDate.getSelectedItemPosition();
                Double CarPower = Double.valueOf(Power.getText().toString());

                //Դարտարկ արժեքի ստուգում

                // Հարկման բազա
                if (taxBase_selected == 1) {
                    CarPower = CarPower * 1.36;
                }

                //Եթե ԱՄ տեսակը մինչև 10 նստատեղով մարդատար է
                if(CarType_selected == 0){
                    if(CarPower <= 120){
                        price = CarPower * 200;} else
                    if(CarPower >= 121 & CarPower <= 150){
                        price = CarPower * 300;} else
                    if(CarPower >= 151 & CarPower <= 250){
                        price = CarPower * 300 + (CarPower - 150) * 1000;} else
                    if(CarPower >= 251) {
                        price = CarPower * 500 + (CarPower - 150) * 1000 ;
                    }
                    //Եթե ԱՄ տեսակը 10 ավելի մարդատար կամ բեռնատար է
                } else if (CarType_selected == 1 || CarType_selected == 2){
                    if(CarPower <= 200) {
                        price = CarPower * 100;} else
                    if(CarPower >= 201) {
                        price = CarPower * 200;}
                }
                //Եթե ԱՄ տեսակը մոտոցիկլ է
                else if (CarType_selected == 3){
                    price = CarPower * 40;}
                //Եթե ԱՄ տեսակը 20 տարուց ավելի բեռնատար է
                else if (CarType_selected == 7){
                    price = 0;}
                //Եթե ԱՄ տեսակը ջրային փոխադրամիջոց, ձյունագնաց կամ մոտոամենագնաց է
                else {
                    price = CarPower * 150;
                }

                //Ժամանակ
                if(ProdDate_selected == 0 || ProdDate_selected == 1 || ProdDate_selected == 2 || ProdDate_selected == 3) {
                    price = price * 1;} else
                if(ProdDate_selected == 4){
                    price = price * 0.9;} else
                if (ProdDate_selected == 5){
                    price = price * 0.8;} else
                if (ProdDate_selected == 6){
                    price = price * 0.7;} else
                if (ProdDate_selected == 7){
                    price = price * 0.6;}
                else {
                    price = price * 0.5;}

                DecimalFormat df = new DecimalFormat("###,###,###");

                String str = df.format(price)+" "+getText(R.string.dram);

                Sum.setText(str);

                //Close SoftKeyboard
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(Calc.getWindowToken(), 0);
            }
        };
        taxBase.setOnItemSelectedListener(myListener);
        Calc.setOnClickListener(myClick);
        return propertyView;
    }
}
