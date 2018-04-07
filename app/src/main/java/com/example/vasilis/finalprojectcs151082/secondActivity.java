package com.example.vasilis.finalprojectcs151082;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView wordTv;
    private TextView score;
    private EditText wordEnteredTv;
    private Button validate;
    private String wordToFind;
    private int mScore = 0;
    private int counter = 0;
    private int tries = 0;
    public Dialog mDialog;
    public Button mDialogyes,mDialogno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        createDialog();


        wordTv = (TextView) findViewById(R.id.wordTv);
        score = (TextView) findViewById(R.id.score);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        score.setText("Score:" + mScore + "/" + 10);
        validate.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view == validate) {
            tries++;
            validate();
        }
    }

    private void validate() {
        String w = wordEnteredTv.getText().toString();
        if (wordToFind.equals(w)) {
            mScore++;
            score.setText("Score:" + mScore + "/" + 10);
            Toast.makeText(this, "Congratulations ! You found the word " + wordToFind, Toast.LENGTH_SHORT).show();

            if ( counter == 10 ) {

                Toast.makeText(this, "End of Game!", Toast.LENGTH_SHORT).show();
                Intent aboutActivity = new Intent(getApplicationContext(), aboutActivity.class);
                aboutActivity.putExtra("result", (float) counter / (float) tries);
                startActivity(aboutActivity);//ekinisi tis othonis about
                this.finish();

            }
            newGame();
        } else {

            Toast.makeText(this, "Retry !", Toast.LENGTH_SHORT).show();//emfanisi lathous
        }
    }

    private void newGame() {

        counter++;
        wordToFind = Anagram.randomWord();
        String wordShuffled = Anagram.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");


    }


    //methods for inflating and handling the menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    protected void createDialog() {
        mDialog = new Dialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_exit);

        mDialog.setCanceledOnTouchOutside(true);
        mDialog.setCancelable(true);
        mDialogyes = (Button) mDialog.findViewById(R.id.yes);
        mDialogno = (Button) mDialog.findViewById(R.id.No);
        mDialogyes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });

        mDialogno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

    }


    @Override

        public boolean onOptionsItemSelected (MenuItem item){
            int id = item.getItemId();
            switch (id) {
                case R.id.new_game:
                    this.finish();
                    Toast.makeText(this, "New game", Toast.LENGTH_SHORT).show();
                    Intent secondActivity=new Intent(getApplicationContext(), secondActivity.class);
                    startActivity(secondActivity);// enarkh neou paixnidiou
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//animations for secondActivity
                    return true;
                case R.id.quit:
                  createDialog();
                    mDialog.show();
                    return true;
                case R.id.home:
                    onBackPressed();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }

        }

    }


