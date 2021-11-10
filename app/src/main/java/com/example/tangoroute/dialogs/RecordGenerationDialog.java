package com.example.tangoroute.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.tangoroute.R;
import com.example.tangoroute.models.Record;
import com.example.tangoroute.models.User;
import com.example.tangoroute.persistence.RecordRepository;
import com.example.tangoroute.utils.WonderGenerator;
import com.example.tangoroute.view.QuizActivity;

public class RecordGenerationDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final QuizActivity activity = (QuizActivity) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.congrats)
                .setMessage(R.string.all_quiz_completed)
                .setPositiveButton(
                        getString(R.string.dialog_close),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                saveRecord();
                                activity.finish();
                            }
                        }
                );

        return builder.create();
    }

    private void saveRecord() {
        User user = User.getInstance();
        RecordRepository repository = RecordRepository.getInstance();
        repository.saveRecord(new Record(user.getEmail(), user.getPoints()));
        user.setCompletedQuizes(WonderGenerator.emptyHashMap());
    }
}
