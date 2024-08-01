package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.databinding.DriveModePopupBinding;
import com.ahmet.androiduitestapp.databinding.SoundPopupBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */
public class SoundPopup extends CustomPopupWindow {

    SoundPopupBinding binding;
    private final SoundPopupListener listener;
    private ToggleManager toggleManager;

    public SoundPopup(Context context, SoundPopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = SoundPopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());

        // Initialize toggle buttons
        List<ToggleButton> toggleButtons = new ArrayList<>();
        toggleButtons.add(binding.voiceSend);
        toggleButtons.add(binding.voiceReceive);
        toggleButtons.add(binding.pushToTalk);

        toggleManager = new ToggleManager(toggleButtons, toggleListener, ToggleManager.ToggleMode.SINGLE_SELECTION);
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
            if (buttonView == binding.voiceSend) {
                listener.onVoiceSendSelected();
            } else if (buttonView == binding.voiceReceive) {
                listener.onVoiceReceiveSelected();
            } else if (buttonView == binding.pushToTalk) {
                listener.onPushToTalkSelected();
            }
        }
    }

    public interface SoundPopupListener {
        void onVoiceSendSelected();
        void onVoiceReceiveSelected();
        void onPushToTalkSelected();
    }
}
