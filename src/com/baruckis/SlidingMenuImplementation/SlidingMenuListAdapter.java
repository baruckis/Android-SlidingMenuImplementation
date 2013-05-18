package com.baruckis.SlidingMenuImplementation;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class SlidingMenuListAdapter extends ArrayAdapter<SlidingMenuListItem> {
	private Context context;
	private int rowViewResourceId;
	private List<SlidingMenuListItem> slidingMenuItemsList = new ArrayList<SlidingMenuListItem>();
	
	private ImageView slidingMenuItemIcon;
	private TextView slidingMenuItemName;

	public SlidingMenuListAdapter(Context context, int rowViewResourceId,
			List<SlidingMenuListItem> objects) {
		super(context, rowViewResourceId, objects);
		this.context = context;
		this.rowViewResourceId = rowViewResourceId;
		this.slidingMenuItemsList = objects;
	}

	public int getCount() {
		return this.slidingMenuItemsList.size();
	}

	public SlidingMenuListItem getItem(int index) {
		return this.slidingMenuItemsList.get(index);
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View row = convertView;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(rowViewResourceId, parent,
					false);
		}
		SlidingMenuListItem slidingMenuListItem = getItem(position);

		slidingMenuItemIcon = (ImageView) row.findViewById(R.id.row_icon);
		slidingMenuItemName = (TextView) row.findViewById(R.id.row_title);

		slidingMenuItemName.setText(slidingMenuListItem.Name);

		int imageResource = context.getResources().getIdentifier(
				slidingMenuListItem.IconResourceId, null,
				context.getPackageName());

		slidingMenuItemIcon.setImageResource(imageResource);

		return row;
	}
}
