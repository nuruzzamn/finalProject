package zaman.example.com.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DashboardActivity extends AppCompatActivity {
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        TextView news1= (TextView) findViewById(R.id.bnews1);
        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(DashboardActivity.this,firstNewsbangla.class);
                startActivity(sports);
            }
        });

        TextView news2= (TextView) findViewById(R.id.bnews2);
        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent sports=new Intent(DashboardActivity.this,secondNewsbangla.class);
                startActivity(sports);
            }
        });

        TextView news3= (TextView) findViewById(R.id.bnews3);
        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(DashboardActivity.this,thirdNewsbangla.class);
                startActivity(sports);
            }
        });

        TextView news4= (TextView) findViewById(R.id.bnews4);
        news4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(DashboardActivity.this,fourNewsbangla.class);
                startActivity(sports);
            }
        });

        ImageButton youtube1= (ImageButton) findViewById(R.id.bimageButton1);
        youtube1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(DashboardActivity.this,firstBanglaYoutube.class);
                startActivity(sports);

            }
        });
        ImageButton youtube2= (ImageButton) findViewById(R.id.bimageButton2);
        youtube2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(DashboardActivity.this,secondBanglaYoutube.class);
                startActivity(sports);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.id_bangla) {

            Intent intentBangla=new Intent(DashboardActivity.this,DashboardActivity.class);
            startActivity(intentBangla);

            Toast.makeText(DashboardActivity.this,"Successfully Enter In Banglanews", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id ==R.id.id_english) {

            Intent intentEnglish=new Intent(DashboardActivity.this,englishProfile.class);
            startActivity(intentEnglish);

            Toast.makeText(DashboardActivity.this,"Successfully Enter In Englishnews", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id ==R.id.id_sports) {

            Intent intentSports=new Intent(DashboardActivity.this,sportsProfile.class);
            startActivity(intentSports);

            Toast.makeText(DashboardActivity.this,"Successfully Enter In Sportsnews", Toast.LENGTH_LONG).show();
            return true;
        }


        return true;
    }



    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
