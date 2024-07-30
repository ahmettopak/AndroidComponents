package com.ahmet.androiduitestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Switch;

import com.ahmet.androiduitestapp.databinding.ActivitySideBarBinding;
import com.ahmet.androiduitestapp.sidebar.CustomMenuView;

public class SideBarActivity extends AppCompatActivity {
    private PopupWindow popupWindow;

    ActivitySideBarBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySideBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customMenu.setCustomMenuListener(new CustomMenuView.CustomMenuListener() {
            @Override
            public void onToggleButtonCheckedChange(View view, String buttonId, boolean isChecked) {
                if (isChecked){
                    showPopupMenu(view);
                }
                else{
                    hidePopupMenu();
                }
            }

            @Override
            public void onViewClicked(View view, String viewId) {
                showPopupMenu(view);

            }

            @Override
            public void onViewLongClicked(View view, String viewId) {
            }
        });
    }



    private void showPopupMenu(View anchorView) {
        // Popup menüyü oluşturma
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_menu_layout, null);

        // Alt menü bileşenlerini bağlama
        Switch switchButton = popupView.findViewById(R.id.switch_button);
        // Alt menüdeki bileşenlere tıklama olaylarını ekleme
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch düğmesine tıklandığında yapılacak işlemler
            }
        });

        // Popup penceresini oluşturma ve konumlandırma
        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        if (popupWindow == null){
            popupWindow = new PopupWindow(popupView, width, height, true);
        }
        popupWindow.setOutsideTouchable(true); // Popup dışına tıklandığında kapanmasını sağlar
        popupWindow.setFocusable(false);


        popupWindow.showAsDropDown(anchorView, -100+anchorView.getWidth()*-1, anchorView.getHeight() * -1);
    }

    public void hidePopupMenu(){
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}