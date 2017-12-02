package com.example.nikhilbansal.jct.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.example.nikhilbansal.jct.R;

/**
 * Created by Nikhil Bansal on 18-11-2017.
 */

public class DialogUtils {

    public static void showSuccessMessageDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(context.getString(R.string.ok_text), null);
        alertDialog.show();
    }

    public static void showErrorMessageDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setNegativeButton(context.getString(R.string.cancel_text), null);
        alertDialog.show();
    }

}
