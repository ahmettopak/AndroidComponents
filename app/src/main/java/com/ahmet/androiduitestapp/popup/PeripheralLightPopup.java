package com.ahmet.androiduitestapp.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.SeekBar;

import com.ahmet.androiduitestapp.databinding.LightPopupBinding;
import com.ahmet.androiduitestapp.databinding.PeripheralLightPopupBinding;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 7/31/2024
 */
public class PeripheralLightPopup extends CustomPopupWindow {

    PeripheralLightPopupBinding binding;
    private final PeripheralLightPopupListener listener;

    public PeripheralLightPopup(Context context, PeripheralLightPopupListener listener) {
        super(context);
        this.listener = listener;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = PeripheralLightPopupBinding.inflate(inflater);

        // Set the content view and dimensions
        setContentView(binding.getRoot());


        // Initialize SeekBars and set listeners
        binding.peripheralLightBrightnessValue.setOnSeekBarChangeListener(seekBarChangeListener);
        binding.peripheralLightFlashRateValue.setOnSeekBarChangeListener(seekBarChangeListener);
    }
    private final SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (listener != null) {
                if (seekBar.equals(binding.peripheralLightBrightnessValue)) {
                    listener.onBrightnessValueChanged(progress);
                } else if (seekBar.equals(binding.peripheralLightFlashRateValue)) {
                    listener.onFlashRateValueChanged(progress);
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
    public interface PeripheralLightPopupListener {
        void onBrightnessValueChanged(int value);
        void onFlashRateValueChanged(int value);
    }
}
