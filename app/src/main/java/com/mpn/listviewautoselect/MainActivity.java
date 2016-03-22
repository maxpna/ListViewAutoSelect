package com.mpn.listviewautoselect;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.mpn.listviewautoselect.listadapters.BaseAdapterAutoSelect;
import com.mpn.listviewautoselect.listadapters.SampleAdapterAutoSelect;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  ListView list=null;
  SampleAdapterAutoSelect adapter;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // read in an array of items in a List<StateObject>
    StateObject item;
    String[] states=getResources().getStringArray(R.array.states);
    List<StateObject> items=new ArrayList<StateObject>();

    for(int i=0;i<states.length;i++){
      String[] tokens=states[i].split(",");
      item=new StateObject();
      item.Name=tokens[0];
      item.StateLetters=tokens[1];
      item.StateCapital=tokens[2];
      item.Selected=( i%2==0 ? true : false);
      items.add(item);
    }

    // create the adapter
    adapter = new SampleAdapterAutoSelect(items, getApplicationContext());
    items=null;  // set local reference to null.

    // create the list and assign the adapter
    list = (ListView) findViewById(R.id.listview);
    Log.d("MainActivity", "list: " + (list == null ? "null" : "not null"));
    list.setAdapter(adapter);

    // refresh the adapter to get it to show data
    adapter.RefreshData("");

    // assign a change listener to edittext.
    EditText edit=(EditText)findViewById(R.id.txtInput);
    edit.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        adapter.RefreshData(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Snackbar.make(view, "item clicked", Snackbar.LENGTH_LONG).setAction("Action", null).show();
      }
    });
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
}
