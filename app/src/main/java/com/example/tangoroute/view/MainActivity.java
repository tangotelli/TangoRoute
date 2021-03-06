package com.example.tangoroute.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.tangoroute.R;
import com.example.tangoroute.dialogs.HelpDialog;
import com.example.tangoroute.dialogs.LoadDialog;
import com.example.tangoroute.dialogs.SaveDialog;
import com.example.tangoroute.dialogs.UserScoreDialog;
import com.example.tangoroute.models.User;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.persistence.WonderRepository;
import com.example.tangoroute.utils.FileManager;
import com.example.tangoroute.utils.QuestionGenerator;
import com.example.tangoroute.utils.WonderGenerator;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WonderRepository wonderRepository;
    private List<Wonder> wonders;
    private ListView listView;
    private ListAdapter listAdapter;

    protected static final String WONDER_BUNDLE_CODE = "wonder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.wonderRepository = WonderRepository.getInstance(getApplication());
        this.wonders = this.wonderRepository.findAll();
        listView = (ListView) findViewById(R.id.listMain);
        listAdapter = new WonderListAdapter(this.wonders, this.getResources(), this);
        listView.setAdapter(listAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemDatabase:
                WonderGenerator.insertAll(getApplication());
                QuestionGenerator.insertAll(getApplication());
                this.wonders = this.wonderRepository.findAll();
                listAdapter = new WonderListAdapter(this.wonders, this.getResources(), this);
                listView.setAdapter(listAdapter);
                return true;
            case R.id.menuItemLoadUserData:
                new LoadDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
                return true;
            case R.id.menuItemSaveUserData:
                new SaveDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
                return true;
            case R.id.menuItemSeeUserData:
                new UserScoreDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
                return true;
            case R.id.menuItemHelp:
                new HelpDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
                return true;
            default:
                return true;
        }
    }

    public void saveUserData() {
        String serialized = User.getInstance().serialize();
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return;
        }
        FileManager.writeFile(this, serialized, User.USER_DATA_FILE);
        Snackbar.make(
                findViewById(android.R.id.content),
                R.string.save_completed,
                Snackbar.LENGTH_LONG
        )
                .show();
    }

    public void saveCanceled() {
        Snackbar.make(
                findViewById(android.R.id.content),
                R.string.save_canceled,
                Snackbar.LENGTH_LONG
        )
                .show();
    }

    public void loadUserData() {
        String serialized = FileManager.readFile(this, User.USER_DATA_FILE);
        if (serialized.equals("")) {
            Snackbar.make(
                    findViewById(android.R.id.content),
                    R.string.load_empty,
                    Snackbar.LENGTH_LONG
            )
                    .show();
        } else {
            User.getInstance().deserialize(serialized);
            Snackbar.make(
                    findViewById(android.R.id.content),
                    R.string.load_completed,
                    Snackbar.LENGTH_LONG
            )
                    .show();
        }
    }

    public void loadCanceled() {
        Snackbar.make(
                findViewById(android.R.id.content),
                R.string.load_canceled,
                Snackbar.LENGTH_LONG
        )
                .show();
    }

}