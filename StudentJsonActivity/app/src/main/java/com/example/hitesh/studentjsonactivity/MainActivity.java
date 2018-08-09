package com.example.hitesh.studentjsonactivity;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String Student_URL = "https://api.androidhive.info/contacts/";
    ProgressDialog dialog;
    ListView listView;
    //List<String> stringList;
    ArrayList<HashMap<String, String>> hashMapArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.student_list);
        //stringList = new ArrayList<>();

        new MyTask().execute();


    }

    public class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Connecting");
            dialog.setTitle("Loading");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ParserDemo parser = new ParserDemo();
            String result = parser.getDatajson(Student_URL);
            //  Log.d("hhh",result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String id = jsonObject1.getString("id");
                    String name = jsonObject1.getString("name");
                    String email = jsonObject1.getString("email");
                    String address = jsonObject1.getString("address");
                    String gender = jsonObject1.getString("gender");

                    JSONObject jsonObject2 = jsonObject1.getJSONObject("phone");
                    String mobile = jsonObject2.getString("mobile");
                    String home = jsonObject2.getString("home");
                    String office = jsonObject2.getString("office");

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", id);
                    hashMap.put("name", name);
                    hashMap.put("email", email);
                    hashMap.put("address", address);
                    hashMap.put("gender", gender);
                    hashMap.put("mob", mobile);
                    hashMap.put("home", home);
                    hashMap.put("office", office);
                    hashMapArrayList.add(hashMap);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            StudentAdapter adapter = new StudentAdapter(MainActivity.this, hashMapArrayList);
            listView.setAdapter(adapter);
            super.onPostExecute(aVoid);
        }
    }
}
