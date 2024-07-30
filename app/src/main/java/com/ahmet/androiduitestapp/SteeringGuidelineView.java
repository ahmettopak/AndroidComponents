package com.ahmet.androiduitestapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Ahmet TOPAK
 * @version 1.0
 * @since 5/21/2024
 */
public class SteeringGuidelineView extends View {
    private Paint paint;
    private float steeringAngle = 0;

    public SteeringGuidelineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(0xFF00FF00); // Yeşil renk
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

    }

    public void setSteeringAngle(float angle) {
        this.steeringAngle = angle;
        invalidate(); // View'i yeniden çiz
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // Çizgilerin başlangıç noktaları
        float startX1 = width / 3;
        float startX2 = 2 * width / 3;
        float startY = height;

        // Direksiyon açısına göre yay şeklinde kılavuz çizgilerini çizecek bir Path oluşturma
        Path path1 = createCurvedPath(startX1, startY, steeringAngle, height);
        Path path2 = createCurvedPath(startX2, startY, steeringAngle, height);

        canvas.drawPath(path1, paint);
        canvas.drawPath(path2, paint);
    }

    private Path createCurvedPath(float startX, float startY, float angle, float height) {
        Path path = new Path();
        path.moveTo(startX, startY);

        // Kontrol noktası (eğrinin büküldüğü yer) ve bitiş noktası
        float controlX = startX + (float) Math.tan(Math.toRadians(angle)) * height / 2;
        float controlY = startY - height / 2;
        float endX = startX;
        float endY = 0;

        // Quadratic Bezier eğrisi ile curved path oluşturma
        path.quadTo(controlX, controlY, endX, endY);

        return path;
    }
}