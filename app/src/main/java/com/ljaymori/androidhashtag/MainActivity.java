package com.ljaymori.androidhashtag;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ItemAdapter mAdapter;

    private EditText etContent;

    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_main);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ItemAdapter(this);
        ItemData id = new ItemData();
        id.setContent(getResources().getString(R.string.ipsum));
        mAdapter.add(id);

        recyclerView.setAdapter(mAdapter);

        etContent = (EditText) findViewById(R.id.edit_content_main);

        Button btn = (Button) findViewById(R.id.button_submit_main);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submit_main : {

                ItemData id = new ItemData();
                id.setContent(etContent.getText().toString());

                mAdapter.add(id);

                etContent.setText("");

                recyclerView.smoothScrollToPosition(mAdapter.getItemCount()-1);
                break;
            }
        }
    }
}
