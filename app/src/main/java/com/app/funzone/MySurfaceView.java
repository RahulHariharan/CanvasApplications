package com.app.funzone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by rahulhariharan on 12/02/17.
 */

public class MySurfaceView extends SurfaceView {

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas canvas = surfaceHolder.lockCanvas();
                drawSomething(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    private void drawSomething(Canvas canvas) {
        int strokeWidth = 200;
        Paint paint = new Paint();
        paint.setStrokeWidth(strokeWidth);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Random random = new Random();
        int numberOfLines = width / strokeWidth;
        int[] colors = {Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.RED, Color.CYAN, Color.DKGRAY, Color.GREEN, Color.LTGRAY};
        int x_start = 0;
        int y_start = 0;
        for(int i=0; i <= numberOfLines; i++) {
            int index = random.nextInt(colors.length);
            paint.setColor(colors[index]);
            canvas.drawRect(x_start, y_start, x_start + strokeWidth, height, paint);
            x_start += strokeWidth;
        }
    }

}
