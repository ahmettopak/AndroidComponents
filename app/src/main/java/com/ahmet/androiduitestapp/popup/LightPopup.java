package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.ahmet.androiduitestapp.ToggleManager;
import com.ahmet.androiduitestapp.databinding.LightPopupBinding;
import com.ahmet.androiduitestapp.databinding.SoundPopupBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */
public class LightPopup extends CustomPopupWindow {

    LightPopupBinding binding;
    private final LightPopupListener listener;

    public LightPopup(Context context, LightPopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LightPopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());


        // Initialize SeekBars and set listeners
        binding.frontLightValue.setOnSeekBarChangeListener(seekBarChangeListener);
        binding.backLightValue.setOnSeekBarChangeListener(seekBarChangeListener);
        binding.ptzLightValue.setOnSeekBarChangeListener(seekBarChangeListener);
    }
    private final SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (listener != null) {
                if (seekBar.equals(binding.frontLightValue)) {
                    listener.onFrontLightValueChanged(progress);
                } else if (seekBar.equals(binding.backLightValue)) {
                    listener.onBackLightValueChanged(progress);
                } else if (seekBar.equals(binding.ptzLightValue)) {
                    listener.onPTZLightValueChanged(progress);
                }
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // You can implement this if needed
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // You can implement this if needed
        }
    };
    public interface LightPopupListener {
        void onFrontLightValueChanged(int value);
        void onBackLightValueChanged(int value);
        void onPTZLightValueChanged(int value);
    }
}
