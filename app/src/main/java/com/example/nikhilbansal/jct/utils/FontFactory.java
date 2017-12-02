package com.example.nikhilbansal.jct.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.example.nikhilbansal.jct.JCTApplication;
import com.example.nikhilbansal.jct.R;
import com.example.nikhilbansal.jct.constant.Constants;

import java.util.HashMap;

/**
 * Created by Nikhil Bansal on 26-10-2017.
 */

public class FontFactory {

    private static HashMap<String, Typeface> fontMap;
    private static Context mContext;

    public static Typeface getFont(String key){
        if(null == fontMap){
            if(null == mContext){
                mContext = JCTApplication.getInstance();
            }
            initFontMap();
        }

        if(fontMap.containsKey(key)){
            return fontMap.get(key);
        }else {
            return fontMap.get(Constants.KEY_FONT_AWESOME);
        }
    }

    private static void initFontMap() {
        fontMap = new HashMap<>();

        fontMap.put(Constants.KEY_FONT_AWESOME, Typeface.createFromAsset(mContext.getAssets(), Constants.KEY_FONT_AWESOME));

    }
}
