package com.example.tangoroute.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.tangoroute.R;
import com.example.tangoroute.view.QuizActivity;

public class CompletedQuizDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final QuizActivity activity = (QuizActivity) getActivity();
        String pointsMessage = getString(R.string.total_points);
        assert activity != null;
        pointsMessage = pointsMessage.replace("$", activity.getPoints() + "");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.completed_quiz)
                .setMessage(pointsMessage)
                .setPositiveButton(
                        getString(R.string.dialog_close),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.close();
                            }
                        }
                );

        return builder.create();
    }
}
