package com.baruckis.SlidingMenuImplementation;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public class MainSlidingMenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu. This adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.github:
			// When you press GitHub icon in the ActionBar
			Utilities.goToGitHub(this);
			return true;
		case R.id.about:
			// When you press information icon in the ActionBar
			DialogFragment dialogFragment = AlertDialogFragment.newInstance(
					R.drawable.ic_dialog_about,
					getString(R.string.dialog_about_title),
					Html.fromHtml(getString(R.string.dialog_about_message)),
					getString(R.string.dialog_about_button_text));
			dialogFragment.show(getFragmentManager(),
					Constants.DIALOG_FRAGMENT_TAG);
			break;
		case R.id.contact:
			// When you press email icon in the ActionBar
			final Intent email = new Intent(
					android.content.Intent.ACTION_SENDTO);
			String uriText = null;
			try {
				uriText = "mailto:"
						+ getString(R.string.contact_email)
						+ "?subject="
						+ URLEncoder.encode(
								getString(R.string.contact_email_subject),
								"UTF-8");
			} catch (UnsupportedEncodingException error1) {
				Toast.makeText(this, R.string.toast_unsupported_encoding,
						Toast.LENGTH_SHORT).show();
				break;
			}

			email.setData(Uri.parse(uriText));
			try {
				startActivity(email);
			} catch (Exception error2) {
				Toast.makeText(this, R.string.toast_contact_no_email,
						Toast.LENGTH_SHORT).show();
			}
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void launchFirst(View view) {
		// Launches first part of the application, where left side sliding out
		// menu is created, and as a content it has a list fragment filled with
		// data loaded from XML file.
		Intent intent = new Intent(getApplicationContext(),
				SlidingMenuFromXMLActivity.class);
		startActivity(intent);
	}

	public void launchSecond(View view) {
		// Launches second part of the application, where left side sliding out
		// menu is created, and as a content it has a list fragment filled with
		// data loaded from a class.
		Intent intent = new Intent(getApplicationContext(),
				SlidingMenuFromClassActivity.class);
		startActivity(intent);
	}
}
