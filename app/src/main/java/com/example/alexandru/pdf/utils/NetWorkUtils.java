package com.example.alexandru.pdf.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtils {

    public static boolean isNetworkAvailable(Object systemService) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) systemService;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
