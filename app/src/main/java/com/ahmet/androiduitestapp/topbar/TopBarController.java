package com.ahmet.androiduitestapp.topbar;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.popup.ConnectionTypePopup;
import com.ahmet.androiduitestapp.popup.DriveModePopup;
import com.ahmet.androiduitestapp.popup.InfraredPopup;
import com.ahmet.androiduitestapp.popup.LightPopup;
import com.ahmet.androiduitestapp.popup.PeripheralLightPopup;
import com.ahmet.androiduitestapp.popup.SoundPopup;

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
    private SoundPopup soundPopup;
    private LightPopup lightPopup;
    private InfraredPopup infraredPopup;
    private PeripheralLightPopup peripheralLightPopup;
    private ConnectionTypePopup connectionTypePopup;


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
        initSoundPopup();
        initLightPopup();
        initInfraredPopup();
        initPeripheralLightPopup();
        initConnectionTypePopup();
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

    private void initSoundPopup() {
        soundPopup = new SoundPopup(topBar.getContext(), new SoundPopup.SoundPopupListener() {
            @Override
            public void onVoiceSendSelected() {

            }

            @Override
            public void onVoiceReceiveSelected() {

            }

            @Override
            public void onPushToTalkSelected() {

            }
        });
    }

    private void initLightPopup() {
        lightPopup = new LightPopup(topBar.getContext(), new LightPopup.LightPopupListener() {
            @Override
            public void onFrontLightValueChanged(int value) {

            }

            @Override
            public void onBackLightValueChanged(int value) {

            }

            @Override
            public void onPTZLightValueChanged(int value) {

            }
        });
    }

    private void initInfraredPopup() {
        infraredPopup = new InfraredPopup(topBar.getContext(), new InfraredPopup.InfraredPopupListener() {
            @Override
            public void onFrontCameraInfraredStateChanged(boolean isChecked) {

            }

            @Override
            public void onBackCameraInfraredStateChanged(boolean isChecked) {

            }

            @Override
            public void onPTZCameraInfraredStateChanged(boolean isChecked) {

            }
        });
    }
    private void initPeripheralLightPopup() {
        peripheralLightPopup = new PeripheralLightPopup(topBar.getContext(), new PeripheralLightPopup.PeripheralLightPopupListener() {
            @Override
            public void onBrightnessValueChanged(int value) {

            }

            @Override
            public void onFlashRateValueChanged(int value) {

            }
        });
    }

    private  void initConnectionTypePopup(){
        connectionTypePopup = new ConnectionTypePopup(topBar.getContext(), new ConnectionTypePopup.ConnectionTypePopupListener() {
            @Override
            public void onLteModeSelected() {

            }

            @Override
            public void onCableModeSelected() {

            }

            @Override
            public void onRfModeSelected() {

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
                togglePopup(button , soundPopup , isChecked);
                break;
            case LIGHTS:
                togglePopup(button , lightPopup , isChecked);
                break;
            case IR_BUTTONS:
                togglePopup(button , infraredPopup , isChecked);
                break;
            case PERIPHERAL_LIGHTS:
                togglePopup(button , peripheralLightPopup , isChecked);
                break;
            case CONNECTIONS:
                togglePopup(button , connectionTypePopup , isChecked);
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
