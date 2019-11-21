package com.example.newquiz;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newquiz.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView qT, clock;
    DatabaseReference databaseReference;
    int total = 0;
    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.var1);
        b2 = (Button) findViewById(R.id.var2);
        b3 = (Button) findViewById(R.id.var3);
        b4 = (Button) findViewById(R.id.var4);
        qT = (TextView) findViewById(R.id.qT);
        clock = (TextView) findViewById(R.id.clock);
     //   reverseTimer(40, clock);
        total = total + 1;
        updateQuestion();

    }

    private void updateQuestion() {


        if (total > 10) {

            Intent i = new Intent(MainActivity.this, ResultActivity.class);
            i.putExtra("total", String.valueOf(correct+wrong));
            i.putExtra("correct", String.valueOf(correct));
            i.putExtra("incorrect", String.valueOf(wrong));
            startActivity(i);
            finish()
;        } else {

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Question").child(String.valueOf(total));
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Question question = dataSnapshot.getValue(Question.class);

                    qT.setText(question.getQuestion());
                    b1.setText(question.getVar1());
                    b2.setText(question.getVar2());
                    b3.setText(question.getVar3());
                    b4.setText(question.getVar4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b4.setEnabled(false);
                            b3.setEnabled(false);
                            b2.setEnabled(false);
                            b1.setEnabled(false);
                            if (b1.getText().toString().equals(question.getAnswer())) {
                                b1.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();

                                    }
                                }, 1200);
                            } else {
                                wrong++;
                                b1.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();

                                    }
                                }, 1200);
                            }
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b4.setEnabled(false);
                            b3.setEnabled(false);
                            b2.setEnabled(false);
                            b1.setEnabled(false);
                            if (b2.getText().toString().equals(question.getAnswer())) {
                                b2.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();
                                    }
                                }, 1200);
                            } else {
                                wrong++;
                                b2.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                                if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();
                                    }
                                }, 1200);
                            }
                        }
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b4.setEnabled(false);
                            b3.setEnabled(false);
                            b2.setEnabled(false);
                            b1.setEnabled(false);
                            if (b3.getText().toString().equals(question.getAnswer())) {
                                b3.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();
                                    }
                                }, 1200);
                            } else {
                                wrong++;
                                b3.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b4.getText().toString().equals(question.getAnswer())) {
                                    b4.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();

                                    }
                                }, 1200);
                            }
                        }
                    });


                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            b4.setEnabled(false);
                            b3.setEnabled(false);
                            b2.setEnabled(false);
                            b1.setEnabled(false);
                            if (b4.getText().toString().equals(question.getAnswer())) {
                                b4.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();
                                    }
                                }, 1200);
                            } else {
                                wrong++;
                                b4.setBackgroundColor(getResources().getColor(R.color.colorWrong));
                                if (b2.getText().toString().equals(question.getAnswer())) {
                                    b2.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b3.getText().toString().equals(question.getAnswer())) {
                                    b3.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                } else if (b1.getText().toString().equals(question.getAnswer())) {
                                    b1.setBackgroundColor(getResources().getColor(R.color.colorRight));
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                                        b4.setEnabled(true);
                                        b3.setEnabled(true);
                                        b2.setEnabled(true);
                                        b1.setEnabled(true);
                                        updateQuestion();

                                    }
                                }, 1200);
                            }
                        }
                    });

                    total++;
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

   /* public void reverseTimer(int seconds, final TextView clock) {
        new CountDownTimer(seconds * 1000 + 1000, 1000) {


            @Override
            public void onTick(long millisUtilFinished) {
                int seconds = (int) (millisUtilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                clock.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }


            @Override
            public void onFinish() {
                //  if (total)
                clock.setText("Completed");
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
             //   intent.putExtra("correct", String.valueOf(correct+wrong));
                intent.putExtra("correct", String.valueOf(correct));
                intent.putExtra("incorrect", String.valueOf(wrong));
                startActivity(intent);
            }

        }.start();


    }*/

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)

                .setTitle("Exit")
                .setMessage("Do you really wanna close quiz?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //SomeActivity - имя класса Activity для которой переопределяем onBackPressed();
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}
