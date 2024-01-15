package com.joincoded.quizappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, FalseAnswerTextView, trueAnswerTextView;
    private Button trueButton, falseButton, nextButton;
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Boolean> answers = new ArrayList<>();
    private static int currentQuestionIndex = 0;
    private static Boolean currentAnswerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setQuestionAndAnswers();
        displayQuestion();


        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }


        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayNextQuestion();
            }
        });


    }


    private void initializeViews() {
        questionTextView = findViewById(R.id.questionTextView);
        trueAnswerTextView = findViewById(R.id.trueAnswerTextView);
        FalseAnswerTextView = findViewById(R.id.FalseAnswerTextView);
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
        nextButton = findViewById(R.id.nextButton);

    }

    private void setQuestionAndAnswers() {
        questions.add("Do penguins Fly? ");
        answers.add(false);

        questions.add("Android phase is 3 weeks ? ");
        answers.add(false);

        questions.add("Android better than JAVA ? ");
        answers.add(false);

    }

    private void displayQuestion() {
        String currentQuestion = questions.get(currentQuestionIndex); //we took the question
        questionTextView.setText(currentQuestion); //display it in screen


    }

    private void checkAnswer(boolean currentAnswerIndex) {
        boolean currentAnswer = answers.get(currentQuestionIndex);
        if (currentAnswer == currentAnswerIndex) {
            showCorrectAnswerViews();

        } else {
            showWrongAnswerViews();
        }

    }

    private void showCorrectAnswerViews() {
        nextButton.setVisibility(View.VISIBLE);
        trueAnswerTextView.setVisibility(View.VISIBLE);

        trueButton.setVisibility(View.INVISIBLE);
        falseButton.setVisibility(View.INVISIBLE);
        FalseAnswerTextView.setVisibility(View.INVISIBLE);

    }

    private void showWrongAnswerViews() {
        nextButton.setVisibility(View.INVISIBLE);
        trueAnswerTextView.setVisibility(View.INVISIBLE);

        FalseAnswerTextView.setVisibility(View.VISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);

    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size())
            currentQuestionIndex++;
        else
            currentQuestionIndex = 0;

        displayQuestion();


        trueAnswerTextView.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);

        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);

    }


}