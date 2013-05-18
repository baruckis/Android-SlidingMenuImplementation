package com.baruckis.SlidingMenuImplementation;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class SlidingMenuListItem {
	public int Id;
	public String Name;
	public String IconResourceId;

	public SlidingMenuListItem() {
	}

	public SlidingMenuListItem(int id, String name, String iconResourceId) {
		this.Id = id;
		this.Name = name;
		this.IconResourceId = iconResourceId;
	}
}
