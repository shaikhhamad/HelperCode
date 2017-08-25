package com.hamadshaikh.helpercodelib;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by Hamad Shaikh on 11/08/2017.
 */

public class PermissionGranter {

    public boolean isMarshmallow(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return false;
        return true;
    }
    public boolean hasPermission(Context context, String manifestPermission){
        if(isMarshmallow()) {
            if(ActivityCompat.checkSelfPermission(context, manifestPermission)== PackageManager.PERMISSION_GRANTED)
                return true;
            return false;
        }
        return true;
    }

    public void requestPermission(Context context,String manifestPermission,int requestCode,String msgAboutPermission) {
        ActivityCompat.requestPermissions((Activity) context, new String[]{manifestPermission}, requestCode);
        if (msgAboutPermission != null)
            Toast.makeText(context, msgAboutPermission, Toast.LENGTH_LONG).show();
    }
    public boolean isPermissionGrantedByUser(Context context,int requestCode, int[] grantResults, int requestedCode, String msgAboutPermission){
        if(requestCode==requestCode){
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                return true;
            if (msgAboutPermission != null)
                Toast.makeText(context, msgAboutPermission, Toast.LENGTH_LONG).show();
        }
        return false;
    }

}
