package com.alsari.calc.calculator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_main, container, false);

        getActivity().setTitle(R.string.calculators);

        Button btnAppa, btnPpt, btnTech, btnCo;
        btnAppa = (Button) mainView.findViewById(R.id.btnAppa);
        btnPpt = (Button) mainView.findViewById(R.id.btn_ppt);
        btnTech = (Button) mainView.findViewById(R.id.btn_tech);
        btnCo = (Button) mainView.findViewById(R.id.btn_co);

        View.OnClickListener myListener = new View.OnClickListener() {


            @Override
            public void onClick (View v) {
                switch (v.getId()){
                    case R.id.btnAppa:
                        AppaNewFragment appaNewFragment = new AppaNewFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,appaNewFragment)
                                .addToBackStack(null);
                                fragmentTransaction.commit();
                        break;

                    case R.id.btn_ppt:
                        PropertyFragment propertyFragment = new PropertyFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionProp = getFragmentManager().beginTransaction();
                        fragmentTransactionProp.replace(R.id.fragment_container,propertyFragment)
                                .addToBackStack(null);
                        fragmentTransactionProp.commit();
                        break;

                    case R.id.btn_tech:
                        TechFragment techFragment = new TechFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionTech = getFragmentManager().beginTransaction();
                        fragmentTransactionTech.replace(R.id.fragment_container,techFragment)
                                .addToBackStack(null);
                        fragmentTransactionTech.commit();
                        break;
                    case R.id.btn_co:
                        CoFragment coFragment = new CoFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransactionCo = getFragmentManager().beginTransaction();
                        fragmentTransactionCo.replace(R.id.fragment_container,coFragment)
                                .addToBackStack(null);
                        fragmentTransactionCo.commit();
                        break;
                }
            }
        };

        btnAppa.setOnClickListener(myListener);
        btnPpt.setOnClickListener(myListener);
        btnTech.setOnClickListener(myListener);
        btnCo.setOnClickListener(myListener);
        return mainView;
    }
}
