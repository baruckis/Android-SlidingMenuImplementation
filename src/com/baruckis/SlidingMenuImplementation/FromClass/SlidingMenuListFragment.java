package com.baruckis.SlidingMenuImplementation.FromClass;

import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baruckis.SlidingMenuImplementation.R;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListAdapter;
import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 *         List fragment, which will be used as a content for sliding out menu.
 * 
 */
public class SlidingMenuListFragment extends ListFragment {
	protected List<SlidingMenuListItem> slidingMenuList;
	private SlidingMenuBuilderBase slidingMenuBuilderBase;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// We set here a custom layout which uses holo light theme colors.
		return inflater.inflate(R.layout.sliding_menu_holo_light_list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// We get a list from our specially created list data class.
		slidingMenuList = SlidingMenuList.getSlidingMenu(getActivity());
		if (slidingMenuList == null)
			return;

		// We pass our taken list to the adapter.
		SlidingMenuListAdapter adapter = new SlidingMenuListAdapter(
				getActivity(), R.layout.sliding_menu_holo_light_list_row, slidingMenuList);
		setListAdapter(adapter);
	}

	// We could define item click actions here, but instead we want our builder
	// to be responsible for that.
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		l.setSelection(position);
		SlidingMenuListItem item = slidingMenuList.get(position);
		slidingMenuBuilderBase.onListItemClick(item);
	}

	// We can not provide a builder as an argument inside a fragment
	// constructor, so that is why we have separate method for that.
	public void setMenuBuilder(SlidingMenuBuilderBase slidingMenuBuilderBase) {
		this.slidingMenuBuilderBase = slidingMenuBuilderBase;
	}
}
