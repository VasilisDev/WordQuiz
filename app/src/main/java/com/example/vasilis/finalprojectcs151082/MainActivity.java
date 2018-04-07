package com.example.vasilis.finalprojectcs151082;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


    private static long back_pressed;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getBooleanExtra("EXIT", false)) {

            finish();
            System.exit(0);

        }
        start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){


                Toast.makeText(getApplicationContext(),"Let's,play!",Toast.LENGTH_SHORT).show();
                Intent neo = new Intent(MainActivity.this, secondActivity.class);
                startActivity(neo);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.action_about){
            Toast.makeText(getApplicationContext(),"About App",Toast.LENGTH_SHORT).show();
            Intent aboutActivity=new Intent(getApplicationContext(), aboutActivity.class);
            startActivity(aboutActivity);
         overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//animations for MainActivity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Utility method to determine screen density and show info
    private void showScreenDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

    }

    @Override
    public void onBackPressed()
    {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }




}