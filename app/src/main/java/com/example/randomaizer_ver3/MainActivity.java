package com.example.randomaizer_ver3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private ArrayList<HistoryItem> history;

    public static final String HISTORY_KEY = "history";

    private final FirstFragment firstFragment = new FirstFragment();
    private final SecondFragment secondFragment = new SecondFragment();
    //private final TryFragment tryFragment = new TryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = new ArrayList<>();

        Button btn_frag1 = findViewById(R.id.onefrag);
        btn_frag1.setOnClickListener(v -> setNewFragment(firstFragment));

       Button btn_frag2 = findViewById(R.id.twofrag);
        btn_frag2.setOnClickListener(v -> setNewFragment(secondFragment));

        Button buttonAct2 = (Button)findViewById(R.id.act2);
        buttonAct2.setOnClickListener(this);

        Button askButton  = (Button) findViewById(R.id.askbut0);
        askButton.setOnClickListener(v -> answerd());
    /*    askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerd();
            }
        });*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(HISTORY_KEY,history);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey(HISTORY_KEY))
            history = savedInstanceState.getParcelableArrayList(HISTORY_KEY);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

    private void setNewFragment(Fragment fragment){

        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame1, fragment); //ft.add
        ft.addToBackStack(null);
        ft.commit();
    }

    public void addToHistory(HistoryItem newItem){
        history.add(newItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.open_history_item:
                Intent intent = new Intent(this, HistoryListActivity.class);
                intent.putParcelableArrayListExtra(HISTORY_KEY,history);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    void answerd(){
        Button askButton = findViewById(R.id.askbut0);
        askButton.setOnClickListener( v -> answerd());
        String[] answerWords;

        answerWords = new String[] {
                getString(R.string.aW1),
                getString(R.string.aW2),
                getString(R.string.aW3),
                getString(R.string.aW4),
                getString(R.string.aW5),
                getString(R.string.aW6),
                getString(R.string.aW7),
                getString(R.string.aW8),
                getString(R.string.aW9),
                getString(R.string.aW10)
        };

        TextInputEditText words = Objects.requireNonNull(findViewById(R.id.textask1));

        if (Objects.requireNonNull(words.getText()).length() != 0) {

            int sum = 0;
            Editable text_answer_string = words.getText();
            int n = words.getText().length();
            for(int i = 0; i<n; i++)
                sum = sum + (int) text_answer_string.charAt(i);

            while (sum > 9 ) {
                int all_number = sum;
                int one_number;
                sum = 0;
                while (all_number / 10 > 0){
                    one_number = all_number % 10;
                    all_number = all_number / 10;
                    sum = sum + one_number;
                }
            }
            TextView result = findViewById(R.id.textout2);
            result.setText(answerWords[sum]);


        } else {

            Toast toast = Toast.makeText(getApplicationContext(),R.string.toast_text, Toast.LENGTH_LONG);
            toast.show();
        }

    }

}