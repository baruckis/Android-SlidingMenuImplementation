package com.baruckis.SlidingMenuImplementation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class Utilities {

	public static void goToGitHub(Context context) {
		// Opens Internet browser to show source code of this application in the GitHub
		Uri uriUrl = Uri.parse(context
				.getString(R.string.source_code_repository_link));
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
		context.startActivity(launchBrowser);
	}
}
