package zaman.example.com.finalproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class englishProfile extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd interstitialAd;

    TextView newsView9,newsView10,newsView11,newsView12;
    //ImageView youTubeFive,youTubeSix;
    String url9="",url10="",url11="",url12="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_profile);


        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


       // setupInterstialAd();



        ///////////////////////////////////////
        //////////////////////////////////////

        newsView9= (TextView) findViewById(R.id.enews1);
        newsView10= (TextView) findViewById(R.id.enews2);
        newsView11= (TextView) findViewById(R.id.enews3);
        newsView12= (TextView) findViewById(R.id.enews4);


        DownloadTask9 task9 = new DownloadTask9();
        DownloadTask10 task10 = new DownloadTask10();
        DownloadTask11 task11 = new DownloadTask11();
        DownloadTask12 task12 = new DownloadTask12();



        task9.execute("https://newsapi.org/v1/articles?source=national-geographic&sortBy=top&apiKey=50867244a3f04d69b730457261999c25");
        task10.execute("https://newsapi.org/v1/articles?source=independent&sortBy=top&apiKey=50867244a3f04d69b730457261999c25");
        task11.execute("https://newsapi.org/v1/articles?source=mtv-news&sortBy=top&apiKey=50867244a3f04d69b730457261999c25");
        task12.execute("https://newsapi.org/v1/articles?source=hacker-news&sortBy=top&apiKey=50867244a3f04d69b730457261999c25");

        //------------------------BBC Sports Apl Title Onclick---------------

        newsView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nationalGeo = new Intent(englishProfile.this,ShowFullNews.class);
                nationalGeo.putExtra("name","nationalGeo");
                nationalGeo.putExtra("url",url9);
                startActivity(nationalGeo);
            }
        });
        //------------------------Espn  Apl Title Onclick---------------

        newsView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent independent = new Intent(englishProfile.this,ShowFullNews.class);
                independent.putExtra("name","independent");
                independent.putExtra("url",url10);
                startActivity(independent);
            }
        });

        //---------------------ESPN CRIC AU API title Onclick---------------------------------

        newsView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mtvNews = new Intent(englishProfile.this,ShowFullNews.class);
                mtvNews.putExtra("name","mtvNews");
                mtvNews.putExtra("url",url11);
                startActivity(mtvNews);
            }
        });

        //---------------------Football Italian  News----------------------------

        newsView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hackerNews = new Intent(englishProfile.this,ShowFullNews.class);
                hackerNews.putExtra("name","hackerNews");
                hackerNews.putExtra("url",url12);
                startActivity(hackerNews);
            }
        });








   /* private void setupInterstialAd() {
        interstitialAd = new InterstitialAd(englishProfile.this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstetial_add_unit_id));
        AdRequest adRequestFull = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequestFull);
        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }

        });*/



        ImageButton youtube1= (ImageButton) findViewById(R.id.eimageButton1);
        youtube1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sports=new Intent(englishProfile.this,firstEnglishYoutube.class);
                startActivity(sports);

            }
        });

        ImageButton youtube2= (ImageButton) findViewById(R.id.eimageButton2);
        youtube2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent sports=new Intent(englishProfile.this,secondEnglishYoutube.class);
                startActivity(sports);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id ==R.id.id_bangla) {

            Intent intentBangla=new Intent(englishProfile.this,DashboardActivity.class);
            startActivity(intentBangla);

            Toast.makeText(englishProfile.this,"Successfully Enter In Banglanews", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id ==R.id.id_english) {

            Intent intentEnglish=new Intent(englishProfile.this,englishProfile.class);
            startActivity(intentEnglish);

            Toast.makeText(englishProfile.this,"Successfully Enter In Englishnews", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id ==R.id.id_sports) {

            Intent intentSports=new Intent(englishProfile.this,sportsProfile.class);
            startActivity(intentSports);

            Toast.makeText(englishProfile.this,"Successfully Enter In Sportsnews", Toast.LENGTH_LONG).show();
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










    // Json Parsing start code ---------------BBC Sports HeadLines-------------

    public class DownloadTask9 extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);

                int data=reader.read();
                while(data!=-1){
                    char current= (char) data;
                    result=result+current;
                    data=reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject=new JSONObject(result);
                String newsInfo=jsonObject.getString("articles");
                JSONArray array=new JSONArray(newsInfo);
                for (int i=0;i<jsonObject.length();i++){
                    JSONObject jsonPart=array.getJSONObject(i);
                    // Log.i("Main",jsonPart.getString("main"));
                    // textView.setText(jsonPart.getString("title"));
                    newsView9.setText(jsonPart.getString("title"));
                    url9=jsonPart.getString("url");

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    //-----------------ESPN News---------------------------

    public class DownloadTask10 extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);

                int data=reader.read();
                while(data!=-1){
                    char current= (char) data;
                    result=result+current;
                    data=reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject=new JSONObject(result);
                String newsInfo=jsonObject.getString("articles");
                JSONArray array=new JSONArray(newsInfo);
                for (int i=0;i<jsonObject.length();i++){
                    JSONObject jsonPart=array.getJSONObject(i);
                    newsView10.setText(jsonPart.getString("title"));
                    url10=jsonPart.getString("url");

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    //------------------------------ESPN CRIC news AU---------------------------------------------

    public class DownloadTask11 extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);

                int data=reader.read();
                while(data!=-1){
                    char current= (char) data;
                    result=result+current;
                    data=reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject=new JSONObject(result);
                String newsInfo=jsonObject.getString("articles");
                JSONArray array=new JSONArray(newsInfo);
                for (int i=0;i<jsonObject.length();i++){
                    JSONObject jsonPart=array.getJSONObject(i);
                    newsView11.setText(jsonPart.getString("title"));
                    url11=jsonPart.getString("url");

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    //-----------------Footbal Itallian News--------------------------
    public class DownloadTask12 extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);

                int data=reader.read();
                while(data!=-1){
                    char current= (char) data;
                    result=result+current;
                    data=reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject=new JSONObject(result);
                String newsInfo=jsonObject.getString("articles");
                JSONArray array=new JSONArray(newsInfo);
                for (int i=0;i<jsonObject.length();i++){
                    JSONObject jsonPart=array.getJSONObject(i);
                    newsView12.setText(jsonPart.getString("title"));
                    url12=jsonPart.getString("url");

                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
