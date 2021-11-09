package com.example.tangoroute.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.tangoroute.R;
import com.example.tangoroute.view.QuizActivity;

public class IncorrectDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final QuizActivity activity = (QuizActivity) getActivity();
        String correctAnswer = getString(R.string.no_points);
        assert activity != null;
        correctAnswer = correctAnswer.replace("$", activity.getCurrentQuestionAnswer());
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.wrong_answer)
                .setMessage(correctAnswer)
                .setPositiveButton(
                        getString(R.string.dialog_close),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.nextQuestion();
                            }
                        }
                );

        return builder.create();
    }
}
