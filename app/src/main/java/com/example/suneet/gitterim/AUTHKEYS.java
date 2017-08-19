package com.example.suneet.gitterim;

import android.app.Application;
import android.content.Context;

/**
 * Created by suneet on 15/8/17.
 */

public class AUTHKEYS {
    //public static String CLIENT_ID="6ed58fd00e49db1aa862a91276be30b4c7936fd2";
    public static String CLIENT_ID="fd122a6c5b22d805770abba999758125431b87ea";
    //public static String CLIENT_SECRET="582daa67d4eec18552b3c812569e59206474fd7f";
    public static String CLIENT_SECRET="cb825216c918624e6e243f913bb8671a231e55fe";
    //public static String REDIRECT_LINK="http://about:blank";
    public static String REDIRECT_LINK="https://gitter.im/home";
    public static String TOKEN="";

    public static void setTOKEN(String TOKEN) {
        AUTHKEYS.TOKEN = TOKEN;
    }
}
