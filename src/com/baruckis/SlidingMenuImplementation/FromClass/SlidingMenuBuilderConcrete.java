package com.baruckis.SlidingMenuImplementation.FromClass;

import com.baruckis.SlidingMenuImplementation.R;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;

import android.widget.Toast;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This is concrete builder class, which extends base builder and can
 *         override default, add new list items click actions.
 * 
 */
public class SlidingMenuBuilderConcrete extends SlidingMenuBuilderBase {

	// We can define actions, which will be called, when we press on separate
	// list items. These actions can override default actions defined inside the
	// base builder. Also, you can create new actions, which will added to the
	// default ones.
	@Override
	public void onListItemClick(SlidingMenuListItem selectedSlidingMenuListItem) {
		switch (selectedSlidingMenuListItem.Id) {
		case R.slidingmenu.list_item_angry_id:
			menu.toggle();

			CharSequence text = "Clicked item “"
					+ activity.getString(R.slidingmenu.list_item_angry_label)
					+ "”. "
					+ activity.getString(R.string.toast_sliding_menu_toggle);
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
			
			return;
		}
		super.onListItemClick(selectedSlidingMenuListItem);
	}
}
