package com.example.newquiz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newquiz.Model.Score;
import com.example.newquiz.R;

import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private LayoutInflater inflater;
    private List<Score> scores;

    public RecyclerAdapter(Context context, List<Score> scores) {
        this.inflater = LayoutInflater.from(context);
        this.scores = scores;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.activity_leader_board, parent, false);
          return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Score score = scores.get(position);
        holder.name.setText(score.getName());
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView score;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameUser);
            score = (TextView) view.findViewById(R.id.score);
        }

    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
