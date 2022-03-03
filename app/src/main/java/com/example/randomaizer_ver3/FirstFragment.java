package com.example.randomaizer_ver3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class FirstFragment extends Fragment {
    TextView resultTextLabel;
    EditText xEdit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_first, container, false);
        Button askButton  = (Button) inflatedView.findViewById(R.id.askbut0);
        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              answerd();
            }
        });

        // Inflate the layout for this fragment
        return inflatedView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    void answerd() {
        Button askButton = Objects.requireNonNull(getView()).findViewById(R.id.askbut0);
        askButton.setOnClickListener(v -> answerd());
        String[] answerWords;

        answerWords = new String[]{
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

        /*
        string answerWord[] =  findViewByName(R.id.asnwerWord);
        Bundle date = new Bundle();
        String  answerWords;
        answerWords = new String []{
        date.getStringArray(getString(answerWords1))
        }*/

        TextInputEditText words = Objects.requireNonNull(getView()).findViewById(R.id.textask1);

        TextView result;
        if (Objects.requireNonNull(words.getText()).length() != 0) {

            int sum = 0;
            Editable text_answer_string = words.getText();
            int n = words.getText().length();
            for (int i = 0; i < n; i++)
                sum = sum + (int) text_answer_string.charAt(i);

            while (sum > 9) {
                int all_number = sum;
                int one_number;
                sum = 0;
                while (all_number / 10 > 0) {
                    one_number = all_number % 10;
                    all_number = all_number / 10;
                    sum = sum + one_number;
                }
            }
            result = getView().findViewById(R.id.textout2);
            result.setText(answerWords[sum]);

            Integer x = Integer.parseInt(xEdit.getText().toString());
            resultTextLabel.setText(String.valueOf(answerWords[sum]));
            // Snackbar.make(answerWords[sum], String.valueOf(answerWords[sum]), Snackbar.LENGTH_LONG).show();
            String historyask = String.valueOf(words.getText());
            String historyres =  String.valueOf(result.getText());
            addHistoryItem(historyask, historyres);
            String output = answerWords[sum] + ". - Имеет результат:  " + result.getText();
            outResult(output);

        } else {

            Toast.makeText(Objects.requireNonNull(getActivity()).getBaseContext(), R.string.toast_text, Toast.LENGTH_SHORT).show();
        }


    }

    private void outResult(String result) {
        resultTextLabel.setText(result);
        Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
    }

    private void addHistoryItem(String operand1, String result){
        //bad style, but will stay till lab7
        MainActivity parent = (MainActivity)getActivity();
        parent.addToHistory(new HistoryItem(operand1,result));
    }

}