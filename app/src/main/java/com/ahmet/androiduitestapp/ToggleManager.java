package com.ahmet.androiduitestapp;

import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */

public class ToggleManager {

    private List<ToggleButton> toggleButtons;
    private ToggleListener listener;
    private ToggleMode mode;

    public enum ToggleMode {
        SINGLE_SELECTION, // Only one can be active at a time
        MULTI_SELECTION,  // All can be active
        SINGLE_MUST_BE_ACTIVE // At least one must be active
    }

    public ToggleManager(List<ToggleButton> toggleButtons, ToggleListener listener, ToggleMode mode) {
        this.toggleButtons = toggleButtons;
        this.listener = listener;
        this.mode = mode;
        initToggleButtons();
    }

    public ToggleManager(List<ToggleButton> toggleButtons, ToggleListener listener) {
        new ToggleManager(toggleButtons, listener, ToggleMode.MULTI_SELECTION);
    }

    private void initToggleButtons() {
        for (ToggleButton toggleButton : toggleButtons) {
            toggleButton.setOnCheckedChangeListener(toggleListener);
        }
    }



    private final CompoundButton.OnCheckedChangeListener toggleListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (mode == ToggleMode.SINGLE_SELECTION && isChecked) {
                for (ToggleButton toggleButton : toggleButtons) {
                    if (toggleButton != buttonView) {
                        toggleButton.setChecked(false);
                    }
                }
            }

            if (mode == ToggleMode.SINGLE_MUST_BE_ACTIVE && !isChecked) {
                boolean anyChecked = false;
                for (ToggleButton toggleButton : toggleButtons) {
                    if (toggleButton.isChecked()) {
                        anyChecked = true;
                        break;
                    }
                }
                if (!anyChecked) {
                    buttonView.setChecked(true);
                }
            }

            handleSelection(buttonView , isChecked);
        }
    };

    private void handleSelection(CompoundButton buttonView , boolean isChecked) {
        if (listener != null) {
            listener.onToggleCheckedChange(buttonView , isChecked);
        }
    }

    public void selectAll() {
        for (ToggleButton toggleButton : toggleButtons) {
            toggleButton.setChecked(true);
        }
    }

    public void deselectAll() {
        for (ToggleButton toggleButton : toggleButtons) {
            toggleButton.setChecked(false);
        }
    }

    public void selectToggleButton(ToggleButton button) {
        button.setChecked(true);
    }

    public void deselectToggleButton(ToggleButton button) {
        button.setChecked(false);
    }



    public void setMode(ToggleMode mode) {
        this.mode = mode;
    }
    public ToggleMode getMode() {
        return mode;
    }

    public void setListener(ToggleListener listener) {
        this.listener = listener;
    }

    public void setToggleButtons(List<ToggleButton> toggleButtons) {
        this.toggleButtons = toggleButtons;
    }

    public interface ToggleListener {
        void onToggleCheckedChange(CompoundButton buttonView , boolean isChecked);
    }
}