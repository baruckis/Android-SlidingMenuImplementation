package com.baruckis.SlidingMenuImplementation.FromClass;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This is base activity which is responsible of implementing common
 *         things for your other activities. You just have to extend it. At
 *         current situation we are creating sliding menu, so here, this
 *         activity is responsible for building it. Later, in your activities,
 *         you can create a sliding menu by just calling base "setSlidingMenu"
 *         method. This base class is also responsible for modifying default
 *         device back button press behavior.
 * 
 */
public class ActivityBase extends Activity {

	private SlidingMenuBuilderBase slidingMenuBuilderBase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		createSlidingMenu();

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
			if (enableHomeIconActionSlidingMenu() && setSlidingMenu() != null) {
				slidingMenuBuilderBase.getSlidingMenu().toggle();
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
		if (setSlidingMenu() != null
				&& slidingMenuBuilderBase.getSlidingMenu().isMenuShowing()) {
			slidingMenuBuilderBase.getSlidingMenu().toggle();
		} else {
			this.onBackPressed();
		}
	}

	private void createSlidingMenu() {
		// If nothing is set, than sliding menu wont be created.
		if (setSlidingMenu() != null) {
			Class<?> builder = setSlidingMenu();
			try {
				// We use our made base builder to create a sliding menu.
				slidingMenuBuilderBase = (SlidingMenuBuilderBase) builder
						.newInstance();
				slidingMenuBuilderBase.createSlidingMenu(this);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Allows to create a sliding out menu in the activity, which extends
	 * ActivityBase class, by overriding it and defining controlling builder
	 * class.
	 * 
	 * @return Controlling builder class.
	 */
	public Class<?> setSlidingMenu() {
		// By default it is set not to create a sliding menu.
		return null;
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
