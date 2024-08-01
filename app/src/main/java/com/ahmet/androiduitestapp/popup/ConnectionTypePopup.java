package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.databinding.ConnectionTypePopupBinding;
import com.ahmet.androiduitestapp.databinding.DriveModePopupBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */
public class ConnectionTypePopup extends CustomPopupWindow {

    ConnectionTypePopupBinding binding;
    private final ConnectionTypePopupListener listener;
    private ToggleManager toggleManager;

    public ConnectionTypePopup(Context context, ConnectionTypePopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = ConnectionTypePopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());

        // Initialize toggle buttons
        List<ToggleButton> toggleButtons = new ArrayList<>();
        toggleButtons.add(binding.lteConnection);
        toggleButtons.add(binding.cableConnection);
        toggleButtons.add(binding.rfConnection);

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
            if (buttonView == binding.lteConnection) {
                listener.onLteModeSelected();
            } else if (buttonView == binding.cableConnection) {
                listener.onCableModeSelected();
            } else if (buttonView == binding.rfConnection) {
                listener.onRfModeSelected();
            }
        }
    }

    public interface ConnectionTypePopupListener {
        void onLteModeSelected();
        void onCableModeSelected();
        void onRfModeSelected();
    }
}
