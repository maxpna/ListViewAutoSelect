package com.mpn.listviewautoselect.listadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mpn.listviewautoselect.R;
import com.mpn.listviewautoselect.StateObject;

import java.util.List;

/**
 * Created by maxpower on 3/22/2016.
 */
public class SampleAdapterAutoSelect extends BaseAdapterAutoSelect<StateObject> {
  Context ctx=null;

  public SampleAdapterAutoSelect(List<StateObject> Items, Context ctx) {
    super(Items);
    this.ctx=ctx;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // implement viewholder patterns and any other efficiency affecting patterns. this is just a sample

    // if not data, exit.
    if (items==null) return null;

    // Get the data item for this position
    StateObject item = getItem(position);
    // Check if an existing view is being reused, otherwise inflate the view
    if (convertView == null) {
      convertView = LayoutInflater.from(ctx).inflate(R.layout.list_item, parent, false);
    }

    // Lookup view for data population
    CheckBox chkSelected = (CheckBox) convertView.findViewById(R.id.checkbox);
    TextView txtState = (TextView) convertView.findViewById(R.id.txtState);
    TextView txtStateInfo = (TextView) convertView.findViewById(R.id.txtStateInfo);

    // Populate the data into the template view using the data object
    txtState.setText(item.Name);
    txtStateInfo.setText(item.StateLetters + " - " + item.StateCapital);
    chkSelected.setChecked(item.Selected);

    final int pos=position;
    chkSelected.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        items.get(pos).Selected=!items.get(pos).Selected;
        // RefreshData(searchString);
        notifyDataSetChanged();
      }
    });
    return convertView;
  }
}
