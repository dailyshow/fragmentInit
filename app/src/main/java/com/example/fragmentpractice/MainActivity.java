package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager manager;
    FragmentTransaction ft;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    FragmentThree fragmentThree;
    FragmentFour fragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();
        fragmentThree = new FragmentThree();
        fragmentFour = new FragmentFour();

        ft = manager.beginTransaction();
        ft.add(R.id.fragment_container, fragmentOne);
        ft.addToBackStack(null);
        ft.commit();

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ft = manager.beginTransaction();

        int id = v.getId();
        switch (id) {
            case R.id.one:
                ft.replace(R.id.fragment_container, fragmentOne);
                ft.commit();
                break;
            case R.id.two:
                ft.replace(R.id.fragment_container, fragmentTwo);
                ft.commit();
                break;
            case R.id.three:
                ft.replace(R.id.fragment_container, fragmentThree);
                ft.commit();
                break;
            case R.id.four:
                ft.replace(R.id.fragment_container, fragmentFour);
                ft.commit();
                break;
        }
    }
}
