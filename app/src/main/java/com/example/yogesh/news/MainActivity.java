package com.example.yogesh.news;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    String myuri;
    ListView lv;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              //  Toast.makeText(getApplicationContext(),"ID ",Toast.LENGTH_LONG).show();
                TextView turl=(TextView)view.findViewById(R.id.t3);
                String myurl=turl.getText().toString().trim();
                Intent intent=new Intent(getApplicationContext(),WebActivity.class);
                intent.putExtra("myurl",myurl);
                startActivity(intent);

            }
        });




        Intent intent=getIntent();
        myuri=intent.getStringExtra("key");
        Newsdata ob= new Newsdata(this);
        ob.execute();
    }



    class Newsdata extends AsyncTask<String,Void,String>{
  Context ctx;
  Newsdata(Context ctx){
      this.ctx=ctx;
  }

       @Override
       protected String doInBackground(String... strings) {
      try{

          java.net.URL url=new java.net.URL(myuri);
          HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
          con.connect();
          InputStream is=con.getInputStream();
          InputStreamReader ins=new InputStreamReader(is);
          BufferedReader reader=new BufferedReader(ins);
          StringBuffer st= new StringBuffer();
          String line="";
          while ((line=reader.readLine())!=null)
          {


              st.append(line+"\n");
          }
          return  st.toString();

      }
      catch (Exception ex){

      }
           return null ;
       }
   @Override
       protected  void onPostExecute(String result){

      // Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
       ArrayList<HashMap<String,String>> newslist=new ArrayList();
       try{
           JSONObject  jsonobj= new JSONObject(result);
           JSONArray news=jsonobj.getJSONArray("articles");
           for (int i=0;i<news.length();i++){
               JSONObject d=news.getJSONObject(i);
               String title=d.getString("title");
               String description=d.getString("description");
               url=d.getString("url");
               String urlToImage = d.getString("urlToImage");


               HashMap<String,String> hnews=new HashMap<String,String>();
               hnews.put("k1",(i+1)+"."+title);
               hnews.put("k2",description);
               hnews.put("k3",url);
               hnews.put("k4",urlToImage);
               newslist.add(hnews);

           }
           MyListAdapter listAdapter=new MyListAdapter(MainActivity.this
                   ,newslist,R.layout.newslist,new String[]{"k1","k2","k3","k4"},new int[]{R.id.t1,R.id.t2,R.id.t3,R.id.im1} );
           lv.setAdapter(listAdapter);

       } catch (Exception e) {
           Toast.makeText(getApplicationContext(),"Error 2 "+result,Toast.LENGTH_LONG).show();
       }


   }

    }

}
