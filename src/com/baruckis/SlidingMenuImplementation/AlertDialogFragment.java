package com.baruckis.SlidingMenuImplementation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * @author Andrius Baruckis http://www.baruckis.com
 * 
 */
public final class AlertDialogFragment extends DialogFragment {

	public static AlertDialogFragment newInstance(int iconResourceId,
			CharSequence titleText, CharSequence messageText,
			CharSequence buttonText) {
		AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
		Bundle arguments = new Bundle();
		arguments.putInt(Constants.ALERT_DIALOG_ICON_KEY, iconResourceId);
		arguments.putCharSequence(Constants.ALERT_DIALOG_TITLE_KEY, titleText);
		arguments.putCharSequence(Constants.ALERT_DIALOG_MESSAGE_KEY,
				messageText);
		arguments
				.putCharSequence(Constants.ALERT_DIALOG_BUTTON_KEY, buttonText);
		alertDialogFragment.setArguments(arguments);
		return alertDialogFragment;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// We always create dialog from stored arguments.
		// This allows us to avoid problems on device screen rotation.
		int iconResourceId = getArguments().getInt(
				Constants.ALERT_DIALOG_ICON_KEY);
		CharSequence titleText = getArguments().getCharSequence(
				Constants.ALERT_DIALOG_TITLE_KEY);
		CharSequence messageText = getArguments().getCharSequence(
				Constants.ALERT_DIALOG_MESSAGE_KEY);
		CharSequence buttonText = getArguments().getCharSequence(
				Constants.ALERT_DIALOG_BUTTON_KEY);

		return new AlertDialog.Builder(getActivity())
				.setIcon(iconResourceId)
				.setTitle(titleText)
				.setMessage(messageText)
				.setPositiveButton(buttonText,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						}).create();
	}
}
