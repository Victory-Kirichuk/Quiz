package com.example.newquiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView t, c, w;
    Button savescore, retry;
    private TextView final_text;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t = (TextView) findViewById(R.id.total);
        c = (TextView) findViewById(R.id.correct);
        w = (TextView) findViewById(R.id.wrong);
        savescore=(Button) findViewById(R.id.savescore);
        retry=(Button) findViewById(R.id.retry);

        Intent i = getIntent();
        String questions = i.getStringExtra("total");
        String correct= i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");
        t.setText(questions);
        c.setText(correct);
        w.setText(wrong);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
      savescore.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              LayoutInflater li = LayoutInflater.from(context);
              View promptsView = li.inflate(R.layout.name, null);
              AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
              mDialogBuilder.setView(promptsView);
              final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);

              mDialogBuilder
                      .setCancelable(false)
                      .setPositiveButton("Save",
                              new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog,int id) {
                                      //Вводим текст и отображаем в строке ввода на основном экране:
                                      final_text.setText(userInput.getText());
                                  }
                              })
                      .setNegativeButton("Cancel",
                              new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog,int id) {
                                      dialog.cancel();
                                  }
                              });

              //Создаем AlertDialog:
              AlertDialog alertDialog = mDialogBuilder.create();

              //и отображаем его:
              alertDialog.show();

          }
      });
    }





    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Do you really wanna close quiz?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        ResultActivity.super.onBackPressed();
                    }
                }).create().show();
    }





}
