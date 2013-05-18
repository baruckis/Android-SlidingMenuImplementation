package com.baruckis.SlidingMenuImplementation.FromXML;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This is base activity which is responsible of implementing common
 *         things for your other activities. You just have to extend it. This
 *         base class is responsible for modifying default device back button
 *         press behavior.
 * 
 */
public class ActivityBase extends Activity {
	protected SlidingMenuInitialiser slidingMenuInitialiser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (enableHomeIconActionBack() || enableHomeIconActionSlidingMenu()) {
			ActionBar actionBar = getActionBar();
			if (actionBar != null)
				actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (enableHomeIconActionSlidingMenu()
					&& slidingMenuInitialiser != null) {
				slidingMenuInitialiser.getSlidingMenu().toggle();
			} else if (enableHomeIconActionBack()) {
				onCustomBackPressed();
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// We need to override default behavior of a device back button press if we
	// want to toggle sliding menu.
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			onCustomBackPressed();
			return true;
		default:
			return super.onKeyDown(keyCode, event);
		}
	}

	// If sliding menu is showing, we need to hide it on the first back button
	// press.
	private void onCustomBackPressed() {
		if (slidingMenuInitialiser != null
				&& slidingMenuInitialiser.getSlidingMenu().isMenuShowing()) {
			slidingMenuInitialiser.getSlidingMenu().toggle();
		} else {
			this.onBackPressed();
		}
	}

	/**
	 * Sets activity home icon to have up icon and on press act as device back
	 * button press.
	 * 
	 * @return Activation state.
	 */
	public boolean enableHomeIconActionBack() {
		return false;
	}

	/**
	 * Sets activity home icon to be as a sliding menu invoke icon and on press
	 * call toggle command for the sliding menu.
	 * 
	 * @return Activation state.
	 */
	public boolean enableHomeIconActionSlidingMenu() {
		return false;
	}
}
