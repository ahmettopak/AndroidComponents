package com.ahmet.androiduitestapp.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import com.ahmet.androiduitestapp.databinding.TopBarLayoutBinding;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/29/2024
 */



public class TopBar extends LinearLayout {

    TopBarLayoutBinding binding;
    private TopBarListener listener;
    public enum TopBarViewId {
        DRIVE_MODE,
        SOUND,
        LIGHTS,
        IR_BUTTONS,
        PERIPHERAL_LIGHTS,
        CONNECTIONS,
        PARK_MODE,
        SCREEN_RECORD,
        SCREENSHOT_BUTTON,
        EMERGENCY_STOP,
        CLOSE_ROBOT
    }
    public TopBar(Context context) {
        super(context);
        init(context);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TopBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        binding = TopBarLayoutBinding.inflate(LayoutInflater.from(context), this, true);

        setOnCheckedChangeListener(binding.driveMenuToggleButton, TopBarViewId.DRIVE_MODE);
        setOnCheckedChangeListener(binding.soundMenuToggleButton, TopBarViewId.SOUND);

        setOnCheckedChangeListener(binding.lightMenuToggleButton, TopBarViewId.LIGHTS);
        setOnCheckedChangeListener(binding.infraredMenuToggleButton, TopBarViewId.IR_BUTTONS);
        setOnCheckedChangeListener(binding.peripheralLightMenuToggleButton, TopBarViewId.PERIPHERAL_LIGHTS);
        setOnCheckedChangeListener(binding.connectionMenuToggleButton, TopBarViewId.CONNECTIONS);
        setOnCheckedChangeListener(binding.parkModeToggleButton, TopBarViewId.PARK_MODE);
        setOnCheckedChangeListener(binding.screenRecordToggleButton, TopBarViewId.SCREEN_RECORD);
        setOnCheckedChangeListener(binding.screenshotToggleButton, TopBarViewId.SCREENSHOT_BUTTON);
        setOnCheckedChangeListener(binding.emergencyStopToggleButton, TopBarViewId.EMERGENCY_STOP);
        setOnCheckedChangeListener(binding.closeRobotToggleButton , TopBarViewId.CLOSE_ROBOT);
    }

    private void setOnCheckedChangeListener(ToggleButton button, final TopBarViewId buttonId) {
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (listener != null) {
                    listener.onToggleButtonCheckedChange(button , buttonId, button.isChecked());
                }
            }
        });
    }
    private void setOnClickListener(View view, final TopBarViewId buttonId) {
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onViewClicked(view , buttonId);
                }
            }
        });
    }
    private void setOnLongClickListener(View view, final TopBarViewId buttonId) {
        view.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null) {
                    listener.onViewLongPressed(view,buttonId);
                }
                return false;
            }
        });
    }
    public void setTopBarListener(TopBarListener listener) {
        this.listener = listener;
    }

    public interface TopBarListener {
        void onToggleButtonCheckedChange(ToggleButton toggleButton ,TopBarViewId viewId, boolean isChecked);
        void onViewClicked(View view ,TopBarViewId viewId);
        void onViewLongPressed(View view , TopBarViewId viewId);

    }
}
