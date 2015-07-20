package com.ljaymori.androidhashtag;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class SearchActivity extends ActionBarActivity {

    public static final String PARAM_KEYWORD = "keyword";

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tvResult = (TextView) findViewById(R.id.text_result_search);

        Uri data = getIntent().getData();

        if(data != null) {
            Toast.makeText(SearchActivity.this, data.toString(), Toast.LENGTH_SHORT).show();

            Log.i("getHost", data.getHost());
            Log.i("getQuery", data.getQuery());

            tvResult.setText("#" + data.getQueryParameter(PARAM_KEYWORD));
//            Log.i("getQuery", data.getQueryParameter("keyword"));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
