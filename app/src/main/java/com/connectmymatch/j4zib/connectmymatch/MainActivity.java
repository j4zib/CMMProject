package com.connectmymatch.j4zib.connectmymatch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSubject;
    SubjectAdapter subjectAdapter;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        rvSubject = findViewById(R.id.subject_rv);
        rvSubject.setLayoutManager(new LinearLayoutManager(this));
        subjectAdapter = new SubjectAdapter();
        rvSubject.setAdapter(subjectAdapter);
        ArrayList<Subject> subjects;
        subjects = new ArrayList<>();


        //Adding dummy data
        subjects.add(new Subject("Mental Ability", 0));
        subjects.add(new Subject("Physics", 0));
        subjects.add(new Subject("Chemistry", 0.71));
        subjects.add(new Subject("Mathematics", 0));
        subjects.add(new Subject("Biology", 24.64));
        subjectAdapter.submitList(subjects);
        subjectAdapter.notifyDataSetChanged();
    }

}
