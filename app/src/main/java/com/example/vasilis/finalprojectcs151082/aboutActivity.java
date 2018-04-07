package com.example.vasilis.finalprojectcs151082;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        float percentResult= getIntent().getFloatExtra("result", -1);
        TextView resultLabel=(TextView)findViewById(R.id.resultLabel);
        TextView result=(TextView)findViewById(R.id.result);

        if(percentResult==-1){
            resultLabel.setVisibility(View.GONE);
            result.setVisibility(View.GONE);
        }
        else{
            result.setText(getString(R.string.percent,percentResult*100));
        }

    }

    public void onBackPressed() {

        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}
