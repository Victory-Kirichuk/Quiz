package com.example.newquiz.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.newquiz.R;
import com.google.firebase.database.DatabaseReference;


public class OneQuestionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment, container, false);
        Button b1, b2, b3, b4;
        TextView qT, clock;
        DatabaseReference databaseReference;
        int total = 0;
        int correct = 0;
        int wrong = 0;
        b1 = (Button) view.findViewById(R.id.var1);
        b2 = (Button) view.findViewById(R.id.var2);
        b3 = (Button) view.findViewById(R.id.var3);
        b4 = (Button) view.findViewById(R.id.var4);
        qT = (TextView) view.findViewById(R.id.qT);
        clock = (TextView) view.findViewById(R.id.clock);

        return view;
    }
}
