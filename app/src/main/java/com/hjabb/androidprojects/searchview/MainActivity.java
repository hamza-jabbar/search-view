package com.hjabb.androidprojects.searchview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    String[] names = {"Akaash Hall", "Bassmead Manor Barns", "Delbury Hall", "Packington Moor", "Panshee Hall",
            "Pentney Abbey", "Rio Grande", "The Courts", "The Grand", "Wasing Park"};

    int[] halls = {R.drawable.akaash_hall, R.drawable.bassmead_manor_barns, R.drawable.delbury_hall,
            R.drawable.packington_moor, R.drawable.panshee_hall, R.drawable.pentney_abbey, R.drawable.rio_grande,
            R.drawable.the_courts, R.drawable.the_grand, R.drawable.wasing_park};

    Toolbar toolbar;

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Hall> hallArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        int count = 0;

        for (String name: names) {
            hallArray.add(new Hall(name, halls[count]));
            count++;
        }

        adapter = new RecyclerAdapter(hallArray);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this); // The onQueryTextChange method will invoke
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    // When user inputs text in the searchview
    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Hall> newList = new ArrayList<>();
        for (Hall hall: hallArray) {
            String name = hall.getName().toLowerCase();
            if (name.contains(newText))
                newList.add(hall);
        }
        adapter.setFilter(newList);
        return true;
    }
}
