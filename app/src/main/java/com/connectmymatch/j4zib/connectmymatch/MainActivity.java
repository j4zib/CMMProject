package com.connectmymatch.j4zib.connectmymatch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rvSubject;
    SubjectAdapter subjectAdapter;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout mDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar,  R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // navigationView.getMenu().getItem(0).setChecked(true);

        TextView trialText = findViewById(R.id.trial_text);
        String first = "Your free trial expired on ";
        String next = "<font color='#00BCD4'>29 Jan 2019</font>";
        String last = ".<br>Please upgrade now to get full access.";
        trialText.setText(Html.fromHtml(first + next + last));
        rvSubject = findViewById(R.id.subject_rv);
        rvSubject.setLayoutManager(new LinearLayoutManager(this));
        subjectAdapter = new SubjectAdapter();
        rvSubject.setAdapter(subjectAdapter);
        ArrayList<Subject> subjects;
        subjects = new ArrayList<>();


        //Adding dummy data
        subjects.add(new Subject("Mental Ability", 0, R.drawable.fill_2));
        subjects.add(new Subject("Physics", 0, R.drawable.fill_3));
        subjects.add(new Subject("Chemistry", 0.71, R.drawable.fill_1));
        subjects.add(new Subject("Mathematics", 0, R.drawable.fill_2));
        subjects.add(new Subject("Biology", 24.64, R.drawable.fill_3));
        subjectAdapter.submitList(subjects);
        subjectAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
