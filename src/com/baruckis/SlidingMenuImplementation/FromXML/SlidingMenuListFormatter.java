package com.baruckis.SlidingMenuImplementation.FromXML;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;

import com.baruckis.SlidingMenuImplementation.SlidingMenuListItem;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class SlidingMenuListFormatter {
	private final List<SlidingMenuListItem> list;

	public SlidingMenuListFormatter() {
		list = new ArrayList<SlidingMenuListItem>();
	}

	public List<SlidingMenuListItem> getList() {
		return list;
	}

	// This generates a list from a given data stream of a raw resource.
	public void generate(InputStream inputStream) {

		// Data stream is processed by our XmlParser class.
		XmlParser xmlParser = new XmlParser(inputStream);

		// Returns a NodeList of all the Elements in document order with a given
		// tag name and are contained in the document.
		NodeList nodes = xmlParser.getNodesByTagName("item");
		final int length = nodes.getLength();

		for (int i = 0; i < length; i++) {
			// Retrieves an attributes values.
			final int itemId = Integer.parseInt(xmlParser
					.getNodeAttributeValue(nodes.item(i), "id"));
			final String itemName = xmlParser.getNodeAttributeValue(
					nodes.item(i), "name");
			final String itemIcon = xmlParser.getNodeAttributeValue(
					nodes.item(i), "icon");

			// Creates new object using these values.
			SlidingMenuListItem slidingMenuListItem = new SlidingMenuListItem(
					itemId, itemName, itemIcon);

			// Fills the list.
			list.add(slidingMenuListItem);
		}
	}
}
