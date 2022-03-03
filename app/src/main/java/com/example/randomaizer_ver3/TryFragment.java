package com.example.randomaizer_ver3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TryFragment extends Fragment {

    /**
     * A simple {@link Fragment} subclass.
     * Use the {@link TryFragment#} factory method to
     * create an instance of this fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_try, container, false);
    }
}