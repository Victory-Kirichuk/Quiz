package com.example.newquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import static java.security.AccessController.getContext;

public class LeaderBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.leaderboardRecycleView);
        final DatabaseHelper dataBaseHelper = new DatabaseHelper(getContext());
        LeaderboardAdapter leaderboardAdapter = new LeaderboardAdapter(getContext(), dataBaseHelper.pullScores());
        recyclerView.setAdapter(leaderboardAdapter);

        return view;
    }
}
