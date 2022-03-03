package com.example.randomaizer_ver3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private final FirstFragment firstFragment = new FirstFragment();
    private final SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button buttonAct1 = findViewById(R.id.act1);
        buttonAct1.setOnClickListener(v -> onBackPressed());

        setNewFragment2(secondFragment);

        setNewFragment(firstFragment);


    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void setNewFragment(Fragment fragment){

        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame2, fragment); //ft.add
        ft.addToBackStack(null);
        ft.commit();
    }

    private void setNewFragment2(Fragment fragment){

        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame3, fragment); //ft.add
        ft.addToBackStack(null);
        ft.commit();
    }
}
