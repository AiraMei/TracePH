package com.juezanholdings.traceph.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.juezanholdings.traceph.MainActivity;
import com.juezanholdings.traceph.R;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final MainActivity mainActivity = (MainActivity) getActivity();
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button noSymptomsButton = root.findViewById(R.id.no_symptoms);
        noSymptomsButton.setFocusable(true);
        noSymptomsButton.setFocusableInTouchMode(true);
        noSymptomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setWithSymptoms(false);
            }
        });
        final Button withSymptomsButton = root.findViewById(R.id.with_symptoms);
        withSymptomsButton.setFocusable(true);
        withSymptomsButton.setFocusableInTouchMode(true);
        withSymptomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.setWithSymptoms(true);
            }
        });
        //final TextView textView = root.findViewById(R.id.text_home);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        final Button nearLabButton = root.findViewById(R.id.near_lab);
        /*nearLabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 0, 0);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                root.getContext().startActivity(intent);
            }
        });*/
        return root;
    }
}