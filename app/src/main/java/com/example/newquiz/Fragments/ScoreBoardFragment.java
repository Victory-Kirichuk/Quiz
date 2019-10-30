package com.example.newquiz.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquiz.R;
import com.google.firebase.database.DatabaseReference;


public class ScoreBoardFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scoreboard, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.leaderboardRecycleView);
       //LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(getContext(), dataBaseHelper.pullScores());
        //recyclerView.setAdapter();

        return view;
    }
}
