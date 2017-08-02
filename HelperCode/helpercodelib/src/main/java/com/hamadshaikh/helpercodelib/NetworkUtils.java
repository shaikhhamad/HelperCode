package com.hamadshaikh.helpercodelib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by Hamad Shaikh on 02/08/2017.
 */

public class NetworkUtils {
    public boolean isNetworkConnected(Context context) {
        boolean available = false;
        try {
            ConnectivityManager cm =
                    (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

            if (activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting()) {
                available = true;

            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return available;
    }


}
