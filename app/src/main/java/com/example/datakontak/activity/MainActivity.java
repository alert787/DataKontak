//15-05-2019
//Muhammad Ilyas
//10116339
//IF -8

package com.example.datakontak.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.datakontak.R;
import com.example.datakontak.fragment.HomeFragment;
import com.example.datakontak.fragment.KontakFragment;
import com.example.datakontak.fragment.ProfilFragment;
import com.example.datakontak.fragment.TentangFragment;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    public static final String FRAGMENT_VIEWPAGER = "FRAGMENT_VIEWPAGER";
    public static final String FRAGMENT_FIRST = "FRAGMENT_FIRST";
    public static final String FRAGMENT_SECOND = "FRAGMENT_SECOND";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(HomeFragment.newInstance(), FRAGMENT_FIRST);
                    return true;
                case R.id.navigation_dashboard:
                    replaceFragment(ProfilFragment.newInstance(), FRAGMENT_SECOND);
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(KontakFragment.newInstance(), FRAGMENT_VIEWPAGER);
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, HomeFragment.newInstance())
                .commit();
    }

    private void replaceFragment(Fragment newFragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, newFragment, tag)
                .commit();

    }

}
