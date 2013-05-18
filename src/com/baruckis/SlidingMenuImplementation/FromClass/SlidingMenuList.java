package com.baruckis.SlidingMenuImplementation.FromClass;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import com.baruckis.SlidingMenuImplementation.R;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public final class SlidingMenuList {

	/**
	 * Building a list that will be used as a data for list fragment, which is a
	 * sliding menu content.
	 * 
	 * @param activity
	 * @return List filled with SlidingMenuListItem objects.
	 */
	public static final List<SlidingMenuListItem> getSlidingMenu(
			Activity activity) {

		List<SlidingMenuListItem> list = new ArrayList<SlidingMenuListItem>();

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_angry_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_angry_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_angry_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_basic_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_basic_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_basic_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_cool_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_cool_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_cool_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_cry_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_cry_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_cry_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_err_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_err_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_err_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_evil_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_evil_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_evil_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_kiss_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_kiss_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_kiss_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_laugh_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_laugh_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_laugh_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_shame_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_shame_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_shame_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_tongue_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_tongue_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_tongue_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_wink_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_wink_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_wink_icon)));

		list.add(new SlidingMenuListItem(R.slidingmenu.list_item_wonder_id,
				activity.getResources().getString(
						R.slidingmenu.list_item_wonder_label), activity
						.getResources().getString(
								R.slidingmenu.list_item_wonder_icon)));

		return list;
	}
}