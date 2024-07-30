package com.ahmet.androiduitestapp.topbar;

import android.view.View;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/30/2024
 */

public class TopBarController {

    private TopBar topBar;

    public TopBarController(TopBar topBar) {
        this.topBar = topBar;
        initTopBarListener();
    }

    private void initTopBarListener() {
        topBar.setTopBarListener(new TopBar.TopBarListener() {
            @Override
            public void onToggleButtonCheckedChange(View view, TopBar.TopBarViewId viewId, boolean isChecked) {
                handleToggleButtonCheckedChange(viewId, isChecked);
            }

            @Override
            public void onViewClicked(View view, TopBar.TopBarViewId viewId) {
                handleViewClicked(viewId);
            }

            @Override
            public void onViewLongPressed(View view, TopBar.TopBarViewId viewId) {
                handleViewLongPressed(viewId);
            }
        });
    }

    private void handleToggleButtonCheckedChange(TopBar.TopBarViewId viewId, boolean isChecked) {
        switch (viewId) {
            case DRIVE_MODE:
                // Handle drive mode toggle button change
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

    private void handleViewClicked(TopBar.TopBarViewId viewId) {
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

    private void handleViewLongPressed(TopBar.TopBarViewId viewId) {
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
