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

public class Sprinkles extends SurfaceView {
    public Sprinkles(Context context, AttributeSet attrs) {
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
        Paint paint = new Paint();

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int numberOfPoints = 100000;

        int[] colors = {Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.RED, Color.CYAN, Color.DKGRAY, Color.GREEN, Color.LTGRAY};
        Random random = new Random();
        paint.setStrokeWidth(5);
        canvas.drawLine(100, 100, 0, 0, paint);

        for(int i=0; i<numberOfPoints; i++) {
            int index = random.nextInt(colors.length);
            paint.setColor(colors[index]);
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            canvas.drawPoint(x, y, paint);
        }
    }
}
