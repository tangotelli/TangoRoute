package com.example.tangoroute.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tangoroute.R;
import com.example.tangoroute.dialogs.CompletedQuizDialog;
import com.example.tangoroute.dialogs.CorrectDialog;
import com.example.tangoroute.dialogs.IncorrectDialog;
import com.example.tangoroute.dialogs.RecordGenerationDialog;
import com.example.tangoroute.models.Question;
import com.example.tangoroute.models.User;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.persistence.QuestionRepository;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private Wonder wonder;
    private QuestionRepository questionRepository;
    private List<Question> questions;
    private int currentQuestion;
    private int selectedOption = -1;
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.wonder = (Wonder) getIntent().getSerializableExtra(MainActivity.WONDER_BUNDLE_CODE);
        this.questionRepository = QuestionRepository.getInstance(getApplication());
        this.questions = this.questionRepository.findByWonderName(this.wonder.getName());
        this.currentQuestion = 0;
        this.selectedOption = -1;
        this.setUpLayout();
    }

    private void setUpLayout() {
        TextView tvWonderTitle = findViewById(R.id.tvWonderTitle);
        tvWonderTitle.setText(this.wonder.getName());
        TextView tvQuestionStatement = findViewById(R.id.tvQuestionStatement);
        tvQuestionStatement.setText(this.questions.get(this.currentQuestion).getStatement());
        RadioButton rbOption0 = findViewById(R.id.rbOption0);
        rbOption0.setText(this.questions.get(this.currentQuestion).getAnswerOptions()[0]);
        RadioButton rbOption1 = findViewById(R.id.rbOption1);
        rbOption1.setText(this.questions.get(this.currentQuestion).getAnswerOptions()[1]);
        RadioButton rbOption2 = findViewById(R.id.rbOption2);
        rbOption2.setText(this.questions.get(this.currentQuestion).getAnswerOptions()[2]);
        RadioGroup radioGroup = findViewById(R.id.rbGroup);
        radioGroup.clearCheck();
    }

    public void onRadioButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.rbOption0:
                this.selectedOption = 0;
                break;
            case R.id.rbOption1:
                this.selectedOption = 1;
                break;
            case R.id.rbOption2:
                this.selectedOption = 2;
                break;
            default:
                this.selectedOption = -1;
                break;
        }
    }

    public void answer(View view) {
        if (this.selectedOption == -1) {
            Snackbar.make(
                    findViewById(android.R.id.content),
                    R.string.answer_invalid,
                    Snackbar.LENGTH_LONG
            )
                    .show();
        } else {
            if (this.selectedOption == this.questions.get(this.currentQuestion).getCorrectAnswer()) {
                new CorrectDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
            } else {
                new IncorrectDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
            }
        }
    }

    public void nextQuestion() {
        this.currentQuestion++;
        if (this.currentQuestion == this.questions.size()) {
            new CompletedQuizDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
        } else {
            this.selectedOption = -1;
            setUpLayout();
        }
    }

    public int getCurrentQuestionPoints() {
        return this.questions.get(this.currentQuestion).getPoints();
    }

    public String getCurrentQuestionAnswer() {
        return this.questions.get(this.currentQuestion)
                .getAnswerOptions()[this.questions.get(this.currentQuestion).getCorrectAnswer()];
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints() {
        this.points += this.questions.get(this.currentQuestion).getPoints();
    }

    public void close() {
        User user = User.getInstance();
        if (user.getCompletedQuizes().get(this.wonder.getName()) == false) {
            user.getCompletedQuizes().replace(this.wonder.getName(), false, true);
            user.setPoints(user.getPoints() + this.getPoints());
            if (user.hasCompletedQuizes()) {
                new RecordGenerationDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
            } else {
                this.finish();
            }
        } else {
            this.finish();
        }
    }
}