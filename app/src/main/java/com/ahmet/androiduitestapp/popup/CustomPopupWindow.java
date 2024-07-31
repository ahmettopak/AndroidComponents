package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */

public class CustomPopupWindow extends PopupWindow {

    PopupWindowListener listener;
    public CustomPopupWindow(Context context){
        super(context);

        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setOutsideTouchable(false);
    }

    public void setPopupWindowListener(PopupWindowListener listener){
        this.listener = listener;
    }
    public interface PopupWindowListener {
        void onDismiss();
        void onShow();
    }
}
