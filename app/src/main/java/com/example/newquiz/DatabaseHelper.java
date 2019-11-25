package com.example.newquiz;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.newquiz.Model.Score;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "Leaderboard";
    private static final int DB_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db, oldVersion, newVersion);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion > 0) {
            db.execSQL("DROP TABLE SCORE");
        }
        db.execSQL("CREATE TABLE SCORE (NAME TEXT, RESULT INTEGER)");

    }

    public void insertLeaderboard(Score score){
        Score oldScore = oldScore(score);
        if (oldScore != null) {
            if (oldScore.compareTo(score) != 1) {
                return;
            }
            deleteScore(oldScore);
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", score.getName());
        values.put("SCORE", score.getScore().toString());

        db.insert("LEADERBOARD", null, values);
    }
    public List<Score> pullScores(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Score> scores = new ArrayList<>();
        Cursor cursor = db.query("LEADERBOARD", new String[] {"NAME", "SCORE"}, null,null,null,null, null);

        while (cursor.moveToNext()){
            Score score = new Score();
            score.setName(cursor.getString(0));
            score.setScore(cursor.getInt(1));

            scores.add(score);
        }
        Collections.sort(scores);
        return scores;
    }

    public Score oldScore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();
        Score oldScore = new Score();
        Cursor cursor = db.query("LEADERBOARD", new String[]{"NAME", "SCORE"}, "NAME = ?", new String[]{score.getName()}, null, null, null);
        if (cursor.moveToNext()){
            oldScore.setName(cursor.getString(0));
            oldScore.setScore(cursor.getInt(1));

            return oldScore;
        }

        return null;
    }
    public void deleteScore(Score score){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM LEADERBOARD WHERE NAME = '" + score.getName() + "';");
    }
}