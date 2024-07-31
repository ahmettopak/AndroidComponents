package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.R;
import com.ahmet.androiduitestapp.databinding.DriveModePopupBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */

public class DriveModePopup extends CustomPopupWindow {

    DriveModePopupBinding binding;
    private DriveModePopupListener listener;
    private List<ToggleButton> toggleButtons = new ArrayList<>();

    public DriveModePopup(Context context, DriveModePopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DriveModePopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());


        // Initialize toggle buttons
        toggleButtons.add(binding.offRoadDriveMode);
        toggleButtons.add(binding.normalDriveMode);
        toggleButtons.add(binding.learningDriveMode);

        for (ToggleButton toggleButton : toggleButtons) {
            toggleButton.setOnCheckedChangeListener(toggleListener);
        }

        // Set initial state (one ToggleButton should be selected)
        if (!toggleButtons.isEmpty()) {
            toggleButtons.get(0).setChecked(true);  // Set the first button as selected initially
        }


    }

    private final CompoundButton.OnCheckedChangeListener toggleListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                for (ToggleButton toggleButton : toggleButtons) {
                    if (toggleButton != buttonView) {
                        toggleButton.setChecked(false);
                    }
                }
                handleSelection(buttonView);
            } else {
                // Ensure that at least one ToggleButton remains selected
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
        }
    };

    private void handleSelection(CompoundButton buttonView) {
        if (listener != null) {
            if (buttonView == binding.offRoadDriveMode) {
                listener.onOffRoadDriveModeSelected();
            } else if (buttonView == binding.normalDriveMode) {
                listener.onNormalDriveModeSelected();
            } else if (buttonView == binding.learningDriveMode) {
                listener.onLearningDriveModeSelected();
            }
        }
    }

    public interface DriveModePopupListener {
        void onOffRoadDriveModeSelected();
        void onNormalDriveModeSelected();
        void onLearningDriveModeSelected();
    }
}


