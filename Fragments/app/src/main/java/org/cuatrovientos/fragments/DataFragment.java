package org.cuatrovientos.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DataFragment extends Fragment {
    private DataListener callback;
    Button button;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " debe implementar la interfaz sendData");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        button = view.findViewById(R.id.btnSendData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendData("Hola");
            }
        });

        return view;
    }

    public interface DataListener {
        public void sendData(String data);
    }
}