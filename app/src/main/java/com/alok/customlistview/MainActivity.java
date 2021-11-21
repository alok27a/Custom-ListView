package com.alok.customlistview;

import static com.alok.customlistview.R.menu.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alok.customlistview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ActivityMainBinding binding;
    ListAdaptor listAdaptor;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = findViewById(R.id.main_list_view);
        searchView =(SearchView) findViewById(R.id.action_search);

//        Data Creation
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User("Alok Mathur", "20BCE2959", "27/03/2002", "CSE Core"));
        arrayList.add(new User("Prasoon Soni", "20BCE2960", "28/03/2002", "CSE Core"));
        arrayList.add(new User("Vishnu Nanduri", "20BCE2946", "12/12/2002", "CSE Core"));
        arrayList.add(new User("Rishi Kaushal", "20BCB0035", "29/11/2002", "CSE Bioinfo"));
        arrayList.add(new User("John A", "20BME0235", "09/11/2002", "Mechanical"));
        arrayList.add(new User("Jane Doe", "20BEE0005", "29/07/2002", "Electrical"));
        arrayList.add(new User("Dexter Morgan", "20BEC0025", "09/05/2002", "Electronics"));
        arrayList.add(new User("Captain America", "20BCE0035", "10/01/2002", "CSE Core"));

//      Custom Adaptor
        listAdaptor = new ListAdaptor(this, arrayList);
        binding.mainListView.setAdapter(listAdaptor);
        binding.mainListView.setClickable(true);
        binding.mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.putExtra("name", arrayList.get(i).name);
                intent.putExtra("registerno", arrayList.get(i).regno);
                intent.putExtra("dob", arrayList.get(i).dob);
                intent.putExtra("branch", arrayList.get(i).branch);
                startActivity(intent);
            }
        });
//        listView.setTextFilterEnabled(true);
//        setupSearchView(searchView);
    }

    private void setupSearchView(SearchView mSearchView) {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener((SearchView.OnQueryTextListener) MainActivity.this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type Here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    listView.clearTextFilter();
                } else {
                    listView.setFilterText(newText);
                }
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}