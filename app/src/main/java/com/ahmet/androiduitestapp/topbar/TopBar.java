package com.ahmet.androiduitestapp.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.databinding.TopBarLayoutBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/29/2024
 */



public class TopBar extends LinearLayout {

    private TopBarLayoutBinding binding;
    private TopBarListener listener;
    private ToggleManager toggleManager;
    private Map<CompoundButton, TopBarViewId> buttonIdMap;

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

        buttonIdMap = new HashMap<>();
        buttonIdMap.put(binding.driveMenuToggleButton, TopBarViewId.DRIVE_MODE);
        buttonIdMap.put(binding.soundMenuToggleButton, TopBarViewId.SOUND);
        buttonIdMap.put(binding.lightMenuToggleButton, TopBarViewId.LIGHTS);
        buttonIdMap.put(binding.infraredMenuToggleButton, TopBarViewId.IR_BUTTONS);
        buttonIdMap.put(binding.peripheralLightMenuToggleButton, TopBarViewId.PERIPHERAL_LIGHTS);
        buttonIdMap.put(binding.connectionMenuToggleButton, TopBarViewId.CONNECTIONS);

        List<ToggleButton> toggleButtons = new ArrayList<>();
        for (CompoundButton button : buttonIdMap.keySet()) {
            if (button instanceof ToggleButton) {
                toggleButtons.add((ToggleButton) button);
            }
        }
        toggleManager = new ToggleManager(toggleButtons, new ToggleManager.ToggleListener() {
            @Override
            public void onToggleCheckedChange(CompoundButton buttonView, boolean isChecked) {
                if (listener != null) {
                    TopBarViewId viewId = buttonIdMap.get(buttonView);
                    if (viewId != null) {
                        listener.onCompoundButtonCheckedChange(buttonView, viewId, isChecked);
                    }
                }
            }
        }, ToggleManager.ToggleMode.SINGLE_SELECTION
        );

        for (Map.Entry<CompoundButton, TopBarViewId> entry : buttonIdMap.entrySet()) {
            setOnClickListener(entry.getKey(), entry.getValue());
            setOnLongClickListener(entry.getKey(), entry.getValue());
        }
    }

    private void setOnClickListener(View view, final TopBarViewId buttonId) {
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onViewClicked(view, buttonId);
                }
            }
        });
    }

    private void setOnLongClickListener(View view, final TopBarViewId buttonId) {
        view.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener != null) {
                    listener.onViewLongPressed(view, buttonId);
                }
                return true;
            }
        });
    }

    public void setTopBarListener(TopBarListener listener) {
        this.listener = listener;
    }

    public interface TopBarListener {
        void onCompoundButtonCheckedChange(CompoundButton compoundButton, TopBarViewId viewId, boolean isChecked);
        void onViewClicked(View view, TopBarViewId viewId);
        void onViewLongPressed(View view, TopBarViewId viewId);
    }
}