package com.mpn.listviewautoselect.listadapters;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxpower on 3/15/2016.
 */
public abstract class BaseAdapterAutoSelect<T> extends BaseAdapter {
  private List<T> mainList =new ArrayList<T>();  // this is the list the holds the entire data
  protected List<T> items =new ArrayList<T>();   // this is the list the holds the filtered data
  private String searchString ="";

  public BaseAdapterAutoSelect(List<T> Items) {
    super();
    mainList =Items;
  }

  @Override
  public int getCount() {
    return items ==null ? 0 : items.size();
  }

  @Override
  public T getItem(int position) {
    return items ==null ? null : items.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  public void RefreshData(String searchString){
    this.searchString=searchString;
    items.clear();
    for(int i=0;i< mainList.size();i++){
      if(mainList.get(i).toString().toUpperCase().contains(this.searchString.toUpperCase()))
        items.add(mainList.get(i));
    }

    notifyDataSetChanged();
  }
}
