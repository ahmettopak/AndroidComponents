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
import com.ahmet.androiduitestapp.ToggleManager;
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
    private final DriveModePopupListener listener;
    private ToggleManager toggleManager;

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
        List<ToggleButton> toggleButtons = new ArrayList<>();
        toggleButtons.add(binding.offRoadDriveMode);
        toggleButtons.add(binding.normalDriveMode);
        toggleButtons.add(binding.learningDriveMode);

        toggleManager = new ToggleManager(toggleButtons, toggleListener, ToggleManager.ToggleMode.SINGLE_MUST_BE_ACTIVE);
    }

    private final ToggleManager.ToggleListener toggleListener = new ToggleManager.ToggleListener() {
        @Override
        public void onToggleCheckedChange(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                handleSelection(buttonView);
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
