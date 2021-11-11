package com.example.tangoroute.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.tangoroute.R;
import com.example.tangoroute.models.User;
import com.example.tangoroute.view.MainActivity;

import java.util.Iterator;
import java.util.Map;

public class UserScoreDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.user_score)
                .setMessage(getUserMessage())
                .setPositiveButton(
                        getString(R.string.dialog_close),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do nothing but close the dialog
                            }
                        }
                );

        return builder.create();
    }

    private String getUserMessage() {
        String message = getString(R.string.user_detail);
        User user = User.getInstance();
        message = message.replace("$", user.getPoints() + "");
        Iterator iterator = user.getCompletedQuizes().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Boolean> entry = (Map.Entry<String, Boolean>) iterator.next();
            if (entry.getValue()) {
                message += entry.getKey() + "\n";
            }
        }
        return message;
    }
}
