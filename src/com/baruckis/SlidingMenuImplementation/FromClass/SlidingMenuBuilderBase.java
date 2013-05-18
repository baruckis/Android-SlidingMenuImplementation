package com.baruckis.SlidingMenuImplementation.FromClass;

import android.app.Activity;
import android.widget.Toast;

import com.baruckis.SlidingMenuImplementation.R;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;
import com.slidingmenu.lib.SlidingMenu;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This is base abstract builder class, which is responsible for
 *         creating sliding menu and implementing it's default list items click
 *         actions.
 * 
 */
public abstract class SlidingMenuBuilderBase {
	protected Activity activity;
	protected SlidingMenu menu = null;

	/**
	 * This method creates sliding out menu from the left screen side. It uses
	 * external "SlidingMenu" library for creation. When menu is attached to the
	 * activity, it places a list fragment inside the menu as it's content.
	 * 
	 * @param activity
	 *            This is Activity to which sliding menu is attached.
	 * 
	 */
	public void createSlidingMenu(Activity activity) {
		this.activity = activity;
		// For actual sliding menu creation we use an external open source
		// Android library called "SlidingMenu". It can be found at
		// "https://github.com/jfeinstein10/SlidingMenu".
		// We configure the SlidingMenu to our needs.
		menu = new SlidingMenu(activity);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.sliding_menu_shadow_width);
		menu.setShadowDrawable(R.drawable.sliding_menu_shadow);
		menu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(activity, SlidingMenu.SLIDING_WINDOW);
		menu.setMenu(R.layout.sliding_menu_frame);

		SlidingMenuListFragment slidingMenuListFragment = new SlidingMenuListFragment();
		slidingMenuListFragment.setMenuBuilder(this);

		// We replace a FrameLayout, which is a content of sliding menu, with
		// created list fragment filled with data from menu builder.
		activity.getFragmentManager().beginTransaction()
				.replace(R.id.sliding_menu_frame, slidingMenuListFragment)
				.commit();
	}

	public SlidingMenu getSlidingMenu() {
		return menu;
	}

	// It is our base builder which can be extended, so we can define default
	// actions, which will be called when we press on separate list items.
	public void onListItemClick(SlidingMenuListItem selectedSlidingMenuListItem) {
		CharSequence text;
		switch (selectedSlidingMenuListItem.Id) {
		case R.slidingmenu.list_item_angry_id:
			text = "Clicked item “"
					+ selectedSlidingMenuListItem.Name
					+ "”. "
					+ activity
							.getString(R.string.toast_sliding_menu_custom_action);
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
			break;
		case R.slidingmenu.list_item_basic_id:
			text = "Clicked item “"
					+ selectedSlidingMenuListItem.Name
					+ "”. "
					+ activity
							.getString(R.string.toast_sliding_menu_custom_action);
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
			break;
		default:
			text = "Clicked item. "
					+ activity
							.getString(R.string.toast_sliding_menu_no_action_default);
			Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
			break;
		}
	}

}
