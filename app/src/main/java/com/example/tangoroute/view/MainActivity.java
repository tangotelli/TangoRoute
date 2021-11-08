package com.example.tangoroute.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.tangoroute.R;
import com.example.tangoroute.dialogs.HelpDialog;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.persistence.QuestionRepository;
import com.example.tangoroute.persistence.WonderRepository;
import com.example.tangoroute.utils.QuestionGenerator;
import com.example.tangoroute.utils.WonderGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WonderRepository wonderRepository;
    private QuestionRepository questionRepository;
    private List<Wonder> wonders;
    private ListView listView;
    private ListAdapter listAdapter;

    protected static final String WONDER_BUNDLE_CODE = "wonder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.wonderRepository = WonderRepository.getInstance(getApplication());
        this.questionRepository = QuestionRepository.getInstance(getApplication());
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
            case R.id.menuItemHelp:
                new HelpDialog().show(getSupportFragmentManager(), "ALERT_DIALOG");
                return true;
            default:
                return true;
        }
    }

}