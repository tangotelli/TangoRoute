package com.example.tangoroute.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.tangoroute.R;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.persistence.WonderRepository;
import com.example.tangoroute.utils.WonderGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WonderRepository repository;
    private List<Wonder> wonders;
    private ListView listView;
    private ListAdapter listAdapter;

    protected static final String WONDER_BUNDLE_CODE = "wonder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.repository = WonderRepository.getInstance(getApplication());
        this.wonders = this.repository.findAll();
        listView = (ListView) findViewById(R.id.list);
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
            case R.id.menuItemHelp:
                WonderGenerator.insertAll(getApplication()); //para la primera metida de datos, luego borralo
                return true;
            default:
                return true;
        }
    }

}