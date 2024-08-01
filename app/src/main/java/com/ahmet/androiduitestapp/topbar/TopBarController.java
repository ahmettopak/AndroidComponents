package com.ahmet.androiduitestapp.topbar;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.popup.DriveModePopup;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/30/2024
 */

public class TopBarController {

    private Context context;
    private TopBar topBar;

    private DriveModePopup driveModePopup;


    public TopBarController(TopBar topBar) {
        this.topBar = topBar;
        this.context = topBar.getContext();
        initTopBarListener();
        initPopups();
    }
    public TopBarController(TopBar topBar , Context context) {
        new TopBarController(topBar);
    }
    private void initPopups(){
        initDriveModePopup();

    }

    private void initTopBarListener() {
        topBar.setTopBarListener(new TopBar.TopBarListener() {
            @Override
            public void onCompoundButtonCheckedChange(CompoundButton compoundButton, TopBar.TopBarViewId viewId, boolean isChecked) {
                handleCompoundButtonCheckedChange(compoundButton,viewId, isChecked);
            }

            @Override
            public void onViewClicked(View view, TopBar.TopBarViewId viewId) {
                handleViewClicked(view,viewId);
            }

            @Override
            public void onViewLongPressed(View view, TopBar.TopBarViewId viewId) {
                handleViewLongPressed(view,viewId);
            }
        });
    }

    private void initDriveModePopup() {
        driveModePopup = new DriveModePopup(topBar.getContext(), new DriveModePopup.DriveModePopupListener() {
            @Override
            public void onOffRoadDriveModeSelected() {
                Toast.makeText(topBar.getContext(), "onOffRoadDriveModeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNormalDriveModeSelected() {
                Toast.makeText(topBar.getContext(), "onNormalDriveModeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLearningDriveModeSelected() {
                Toast.makeText(context, "onLearningDriveModeSelected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleCompoundButtonCheckedChange(CompoundButton button , TopBar.TopBarViewId viewId, boolean isChecked) {
        switch (viewId) {
            case DRIVE_MODE:
                // Handle drive mode toggle button change
                togglePopup(button , driveModePopup , isChecked);

                break;
            case SOUND:
                // Handle sound toggle button change
                break;
            case LIGHTS:
                // Handle lights toggle button change
                break;
            case IR_BUTTONS:
                // Handle IR buttons toggle button change
                break;
            case PERIPHERAL_LIGHTS:
                // Handle peripheral lights toggle button change
                break;
            case CONNECTIONS:
                // Handle connections toggle button change
                break;
            case PARK_MODE:
                // Handle park mode toggle button change
                break;
            case SCREEN_RECORD:
                // Handle screen record toggle button change
                break;
            case SCREENSHOT_BUTTON:
                // Handle screenshot button toggle button change
                break;
            case EMERGENCY_STOP:
                // Handle emergency stop toggle button change
                break;
            case CLOSE_ROBOT:
                // Handle close robot toggle button change
                break;
        }
    }
    private void togglePopup(View anchorView,PopupWindow popupWindow , boolean isShow){
        if(isShow){
            popupWindow.showAsDropDown(anchorView);
        }else{
            popupWindow.dismiss();
        }
    }
    private void handleViewClicked(View view , TopBar.TopBarViewId viewId) {
        switch (viewId) {
            case DRIVE_MODE:
                // Handle drive mode button click
                break;
            case SOUND:
                // Handle sound button click
                break;
            case LIGHTS:
                // Handle lights button click
                break;
            case IR_BUTTONS:
                // Handle IR buttons button click
                break;
            case PERIPHERAL_LIGHTS:
                // Handle peripheral lights button click
                break;
            case CONNECTIONS:
                // Handle connections button click
                break;
            case PARK_MODE:
                // Handle park mode button click
                break;
            case SCREEN_RECORD:
                // Handle screen record button click
                break;
            case SCREENSHOT_BUTTON:
                // Handle screenshot button click
                break;
            case EMERGENCY_STOP:
                // Handle emergency stop button click
                break;
            case CLOSE_ROBOT:
                // Handle close robot button click
                break;
        }
    }

    private void handleViewLongPressed(View view , TopBar.TopBarViewId viewId) {
        switch (viewId) {
            case DRIVE_MODE:
                // Handle drive mode button long press
                break;
            case SOUND:
                // Handle sound button long press
                break;
            case LIGHTS:
                // Handle lights button long press
                break;
            case IR_BUTTONS:
                // Handle IR buttons button long press
                break;
            case PERIPHERAL_LIGHTS:
                // Handle peripheral lights button long press
                break;
            case CONNECTIONS:
                // Handle connections button long press
                break;
            case PARK_MODE:
                // Handle park mode button long press
                break;
            case SCREEN_RECORD:
                // Handle screen record button long press
                break;
            case SCREENSHOT_BUTTON:
                // Handle screenshot button long press
                break;
            case EMERGENCY_STOP:
                // Handle emergency stop button long press
                break;
            case CLOSE_ROBOT:
                // Handle close robot button long press
                break;
        }
    }
}
