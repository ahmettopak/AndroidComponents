package com.ahmet.androiduitestapp.sidebar;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 5/28/2024
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import com.ahmet.androiduitestapp.R;

public class CustomMenuView extends LinearLayout {

    private CustomMenuListener listener;

    private ImageView logoImageView;
    private ToggleButton emergencyStopButton;
    private ToggleButton driveModeButton;
    private ToggleButton lightsButton;
    private ToggleButton irButtons;
    private ToggleButton peripheralLightsButton;
    private ToggleButton connectionsButton;
    private ToggleButton parkModeButton;
    private ToggleButton screenRecordButton;
    private Button screenshotButton;

    public static final String EMERGENCY_STOP_ID = "emergencyStop";
    public static final String DRIVE_MODE_ID = "driveMode";
    public static final String LIGHTS_ID = "lights";
    public static final String IR_BUTTONS_ID = "irButtons";
    public static final String PERIPHERAL_LIGHTS_ID = "peripheralLights";
    public static final String CONNECTIONS_ID = "connections";
    private static final String PARK_MODE_ID = "parkMode";
    private static final String SCREEN_RECORD_ID = "screenRecord";
    private static final String SCREENSHOT_BUTTON_ID = "screenshotButton";
    private static final String LOGO_IMAGE_VIEW_ID = "logoImageView";

    public CustomMenuView(Context context) {
        super(context);
        init(context);
    }

    public CustomMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomMenuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_menu_layout, this);

        logoImageView = findViewById(R.id.logoImageView);
        emergencyStopButton = findViewById(R.id.emergencyStopButton);
        driveModeButton = findViewById(R.id.driveModeButton);
        lightsButton = findViewById(R.id.lightsButton);
        irButtons = findViewById(R.id.irButtons);
        peripheralLightsButton = findViewById(R.id.peripheralLightsButton);
        connectionsButton = findViewById(R.id.connectionsButton);
        parkModeButton = findViewById(R.id.parkModeButton);
        screenRecordButton = findViewById(R.id.screenRecordButton);
        screenshotButton = findViewById(R.id.screenshotButton);

        setToggleClickListener(emergencyStopButton, EMERGENCY_STOP_ID);
        setToggleClickListener(driveModeButton, DRIVE_MODE_ID);
        setToggleClickListener(lightsButton, LIGHTS_ID);
        setToggleClickListener(irButtons, IR_BUTTONS_ID);
        setToggleClickListener(peripheralLightsButton, PERIPHERAL_LIGHTS_ID);
        setToggleClickListener(connectionsButton, CONNECTIONS_ID);
        setToggleClickListener(parkModeButton, PARK_MODE_ID);
        setToggleClickListener(screenRecordButton, SCREEN_RECORD_ID);

        setOnClickListener(screenshotButton , SCREENSHOT_BUTTON_ID);
        setOnClickListener(logoImageView , LOGO_IMAGE_VIEW_ID);

    }

    private void setToggleClickListener(ToggleButton button, final String buttonId) {
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (listener != null) {
                    listener.onToggleButtonCheckedChange(compoundButton , buttonId, button.isChecked());
                }
            }
        });
    }
    private void setOnClickListener(View view, final String buttonId) {
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onViewClicked(view , buttonId);
                }
            }
        });
    }
    private void setOnLongClickListener(View view, final String buttonId) {
        view.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null) {
                    listener.onViewLongClicked(view,buttonId);
                }
                return false;
            }
        });
    }
    public void setCustomMenuListener(CustomMenuListener listener) {
        this.listener = listener;
    }

    public interface CustomMenuListener {
        void onToggleButtonCheckedChange(View view ,String buttonId, boolean isChecked);
        void onViewClicked(View view ,String viewId);
        void onViewLongClicked(View view ,String viewId);

    }
}