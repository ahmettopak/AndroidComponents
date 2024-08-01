package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.databinding.InfraredPopupBinding;
import com.ahmet.androiduitestapp.databinding.SoundPopupBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */
public class InfraredPopup extends CustomPopupWindow {

    InfraredPopupBinding binding;
    private final InfraredPopupListener listener;
    private ToggleManager toggleManager;

    public InfraredPopup(Context context, InfraredPopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = InfraredPopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());

        // Initialize toggle buttons
        List<ToggleButton> toggleButtons = new ArrayList<>();
        toggleButtons.add(binding.frontCameraInfrared);
        toggleButtons.add(binding.backCameraInfrared);
        toggleButtons.add(binding.ptzCameraInfrared);

        toggleManager = new ToggleManager(toggleButtons, toggleListener, ToggleManager.ToggleMode.MULTI_SELECTION);
    }

    private final ToggleManager.ToggleListener toggleListener = new ToggleManager.ToggleListener() {
        @Override
        public void onToggleCheckedChange(CompoundButton buttonView, boolean isChecked) {
                handleCheckedChange(buttonView , isChecked);
        }
    };

    private void handleCheckedChange(CompoundButton buttonView , boolean isChecked) {
        if (listener != null) {
            if (buttonView == binding.frontCameraInfrared) {
                listener.onFrontCameraInfraredStateChanged(isChecked);
            } else if (buttonView == binding.backCameraInfrared) {
                listener.onBackCameraInfraredStateChanged(isChecked);
            } else if (buttonView == binding.ptzCameraInfrared) {
                listener.onPTZCameraInfraredStateChanged(isChecked);
            }
        }
    }

    public interface InfraredPopupListener {
        void onFrontCameraInfraredStateChanged(boolean isChecked);
        void onBackCameraInfraredStateChanged(boolean isChecked);
        void onPTZCameraInfraredStateChanged(boolean isChecked);
    }
}
