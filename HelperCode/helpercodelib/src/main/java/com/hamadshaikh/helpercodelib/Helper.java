package com.hamadshaikh.helpercodelib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Hashtable;

/**
 * Created by usmankhalil on 02/08/2017.
 */

public class Helper {

    public int getAppVersionCode(){
        int versionCode=0;
        versionCode = BuildConfig.VERSION_CODE;
        return versionCode;
    }

    public String getTwoDigitFractionAmountFormat(Double amount) {
        return String.format("%,.2f", amount);

    }

    public void showShortToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public  SpannableStringBuilder changeSentenceStringStyleInTwo(String strFist,int typefaceStyleFirst, String strSecond,int typefaceStyleSecond){
        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString firstSpannable= new SpannableString(strFist);
        firstSpannable.setSpan(new StyleSpan(typefaceStyleFirst), 0, strFist.length(), 0);
        builder.append(firstSpannable);
        SpannableString secondSpannable= new SpannableString(strSecond);
        secondSpannable.setSpan(new StyleSpan(typefaceStyleSecond), 0, strSecond.length(), 0);
        builder.append(secondSpannable);
        return builder;
    }

    public AlertDialog.Builder messageAlertDialog(final Context context,int iconID,String title, String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        if(title!=null)
        alertDialogBuilder.setTitle(title);
        if(iconID!=0)
        alertDialogBuilder.setIcon(iconID);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(false);
        return alertDialogBuilder;
    }
    public Typeface getFontCache(Context context,String assetPath) {
        Typeface tf;
            try {
                tf = Typeface.createFromAsset(context.getAssets(), assetPath);
            } catch (Exception e) {
                return null;
            }
        return tf;
    }

    @TargetApi(21)
    public  void notificationBarColor(Context context,int color){
        int currentAPIVersion = android.os.Build.VERSION.SDK_INT;
        if (currentAPIVersion>=21) {
            Window window = ((Activity)context).getWindow();
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // finally change the color
            window.setStatusBarColor(ContextCompat.getColor(context, color));
        }
    }
}
