package com.example.a7.englishwords;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView russianWord, correctWord1, correctWord2, correctWord3, inARow;
    EditText input1, input2, input3;
    Button checkButton, nextButton;
    Words words;
    int inARowCounter;
    boolean firstCheck, guessed;
    MediaPlayer mediaPlayer;
    int tracks[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        russianWord = (TextView) findViewById(R.id.russianWord);
        correctWord1 = (TextView) findViewById(R.id.correctWord1);
        correctWord2 = (TextView) findViewById(R.id.correctWord2);
        correctWord3 = (TextView) findViewById(R.id.correctWord3);
        inARow = (TextView) findViewById(R.id.inARow);
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        input3 = (EditText) findViewById(R.id.input3);
        checkButton = (Button) findViewById(R.id.checkButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        getNewWord();
        firstCheck = true;

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.checkButton:
                        clickCheckButton(correctWord1, correctWord2 , correctWord3);
                        break;
                    case R.id.nextButton:
                        getNewWord();
                        break;
                    case R.id.input1:
                        input1.setBackgroundResource(R.drawable.back_with_border);
                        break;
                    case R.id.input2:
                        input2.setBackgroundResource(R.drawable.back_with_border);
                        break;
                    case R.id.input3:
                        input3.setBackgroundResource(R.drawable.back_with_border);
                        break;
                }

            }
        };

        checkButton.setOnClickListener(onClickListener);
        nextButton.setOnClickListener(onClickListener);
        input1.setOnClickListener(onClickListener);
        input2.setOnClickListener(onClickListener);
        input3.setOnClickListener(onClickListener);
    }

    private void pronounWords() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[0]);

        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[1]);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), tracks[2]);
                        mediaPlayer.start();
                    }
                });
            }
        });

    }

    private void getNewWord() {
        if (!guessed) inARowCounter = 0;
        guessed = false;
        hideOldAnswers();
        firstCheck = true;
        setInARow();
        words = new Words();
        setSounds(words);
        russianWord.setText(words.getRussianWord());
    }

    private void setSounds(Words words) {

        int infinitiveId = getResources().getIdentifier(setInfinitiveWord(words), "raw", getPackageName());
        int pastSimpleId = getResources().getIdentifier(words.getEnglishWords().getPastSimple(), "raw", getPackageName());
        int pastParticularId = getResources().getIdentifier(words.getEnglishWords().getPastParticular(), "raw", getPackageName());

        tracks = new int[]{infinitiveId, pastSimpleId, pastParticularId};
    }

    private String setInfinitiveWord(Words words) {
        String infinitive = words.getEnglishWords().getInfinitive();
        words.getEnglishWords().getInfinitive();

        if (infinitive.equals("do") || infinitive.equals("break") || infinitive.equals("throw")) {
            infinitive += 1;
        }
        return infinitive;
    }

    private void hideOldAnswers() {
        input1.setBackgroundResource(R.drawable.back_with_border);
        input2.setBackgroundResource(R.drawable.back_with_border);
        input3.setBackgroundResource(R.drawable.back_with_border);
        input1.setText("");
        input2.setText("");
        input3.setText("");
        correctWord1.setText("");
        correctWord2.setText("");
        correctWord3.setText("");
    }

    private void clickCheckButton(TextView correctWord1,
                                  TextView correctWord2,
                                  TextView correctWord3) {

        checkWords();
        setInARow();
        correctWord1.setText(words.getEnglishWords().getInfinitive());
        correctWord2.setText(words.getEnglishWords().getPastSimple());
        correctWord3.setText(words.getEnglishWords().getPastParticular());

    }

    private void setInARow() {
        String text = "Guessed in a row: " + String.valueOf(inARowCounter);
        inARow.setText(text);
    }

    private void checkWords() {

        checkWordAndSetColor(input1, words.getEnglishWords().getInfinitive());
        checkWordAndSetColor(input2, words.getEnglishWords().getPastSimple());
        checkWordAndSetColor(input3, words.getEnglishWords().getPastParticular());

       if (firstCheck &&
               input1.getText().toString().toLowerCase().equals(words.getEnglishWords().getInfinitive()) &&
               input2.getText().toString().toLowerCase().equals(words.getEnglishWords().getPastSimple()) &&
               input3.getText().toString().toLowerCase().equals(words.getEnglishWords().getPastParticular()))
       {
           inARowCounter++;
           firstCheck = false;
           guessed = true;
           pronounWords();

       } else if (input1.getText().toString().toLowerCase().equals(words.getEnglishWords().getInfinitive()) &&
               input2.getText().toString().toLowerCase().equals(words.getEnglishWords().getPastSimple()) &&
               input3.getText().toString().toLowerCase().equals(words.getEnglishWords().getPastParticular()))
       {
           guessed = true;
           pronounWords();
       } else {
           guessed = false;
           firstCheck = false;
           inARowCounter = 0;
       }
    }

    private void checkWordAndSetColor(EditText input, String correctWord) {
        if (input.getText().toString().toLowerCase().equals(correctWord)) {
            input.setBackgroundResource(R.drawable.green_border);
        } else {
            input.setBackgroundResource(R.drawable.red_border);
        }
    }
}
