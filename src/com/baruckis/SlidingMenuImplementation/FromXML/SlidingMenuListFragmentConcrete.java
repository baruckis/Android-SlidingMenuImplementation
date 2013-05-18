package com.baruckis.SlidingMenuImplementation.FromXML;

import com.baruckis.SlidingMenuImplementation.R;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class SlidingMenuListFragmentConcrete extends
		SlidingMenuListFragmentBase {

	// We can define actions, which will be called, when we press on separate
	// list items. These actions can override default actions defined inside
	// base fragment. Also, you can create new actions, which will added to the
	// default ones.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		SlidingMenuListItem item = slidingMenuList.get(position);
		CharSequence text;
		Activity activity = getActivity();

		switch (item.Id) {
		case 1:
			menu.toggle();

			text = "Clicked item “"
					+ activity.getString(R.slidingmenu.list_item_angry_label)
					+ "”. "
					+ activity.getString(R.string.toast_sliding_menu_toggle);
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
			
			return;
		}
		super.onListItemClick(l, v, position, id);
	}

}
