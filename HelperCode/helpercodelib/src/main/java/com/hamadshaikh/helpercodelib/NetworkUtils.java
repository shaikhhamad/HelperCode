package com.hamadshaikh.helpercodelib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
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
    public boolean isDomainUp(String server){
        String serverDomain="www.google.com";
        if(server!=null)serverDomain=server;
        try {
            InetAddress.getByName(serverDomain);
            return true;
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



}
