package com.baruckis.SlidingMenuImplementation;

import android.os.Bundle;

import com.baruckis.SlidingMenuImplementation.FromXML.ActivityBase;
import com.baruckis.SlidingMenuImplementation.FromXML.SlidingMenuInitialiser;
import com.baruckis.SlidingMenuImplementation.FromXML.SlidingMenuListFragmentConcrete;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         This activity demonstrates more complex approach how a sliding menu
 *         can be added to our activity. We have few lines of code which do all
 *         the work. We need to provide an XML file to be used as data file and
 *         a fragment to be used as a content for our menu. Our fragment is
 *         defined as a ListFragment and is filled with items that are described
 *         inside XML file. XML file is kept inside raw folder. The raw folder
 *         must be inside the res folder. Raw resources are not compiled by the
 *         platform, they available as raw files and these files can refer to
 *         any type of files.
 * 
 */
public class SlidingMenuFromXMLActivity extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding_menu_from_xml_activity);

		// These two lines of code adds left side sliding out menu to your
		// activity. First we create new SlidingMenuInitializer instance and
		// pass our activity as a constructor parameter.
		slidingMenuInitialiser = new SlidingMenuInitialiser(this);
		// Secondly we call a method which creates sliding menu from our given
		// XML file and a fragment to be used as content for our menu.
		slidingMenuInitialiser.createSlidingMenu(
				SlidingMenuListFragmentConcrete.class,
				R.raw.sliding_menu_list_items);
	}
	
	@Override
	public boolean enableHomeIconActionBack() {
		return true;
	}
}
