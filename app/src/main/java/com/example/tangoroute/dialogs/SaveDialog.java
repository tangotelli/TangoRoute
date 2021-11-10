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

public class SaveDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public AppCompatDialog onCreateDialog(Bundle savedInstanceState) {
        final MainActivity activity = (MainActivity) getActivity();
        String message = getString(R.string.dialog_save);
        int points = User.getInstance().getPoints();
        message = message.replace("$", points + "");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder
                .setTitle(R.string.menu_save)
                .setMessage(message)
                .setPositiveButton(
                        getString(R.string.dialog_yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.saveUserData();
                            }
                        }
                )
                .setNegativeButton(
                        getString(R.string.dialog_no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.saveCanceled();
                            }
                        }
                );

        return builder.create();
    }
}
