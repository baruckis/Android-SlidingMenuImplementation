package com.baruckis.SlidingMenuImplementation;

import android.os.Bundle;

import com.baruckis.SlidingMenuImplementation.FromClass.ActivityBase;
import com.baruckis.SlidingMenuImplementation.FromClass.SlidingMenuBuilderConcrete;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This activity demonstrates simple and more optimised approach how a
 *         sliding menu can be added to our activity. Because this Activity
 *         extends our made ActivityBase class, all the work of creating sliding
 *         menu is done there. So, every time you want to add sliding menu to any
 *         activity, you just need to extend base activity class and override
 *         setSlidingMenu method. Also you need to provide a concrete sliding
 *         menu builder class, which defines, what actions to do, when you press
 *         on separate list items from the menu.
 * 
 */
public class SlidingMenuFromClassActivity extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding_menu_from_class_activity);
	}
	
	// Your need to put this method in every Activity class where you want to
	// have sliding menu.
	@Override
	public Class<?> setSlidingMenu() {
		// Each activity can have it's own sliding menu controlling builder
		// class.
		return SlidingMenuBuilderConcrete.class;
	}
	
	@Override
	public boolean enableHomeIconActionSlidingMenu() {
		return true;
	}
}
