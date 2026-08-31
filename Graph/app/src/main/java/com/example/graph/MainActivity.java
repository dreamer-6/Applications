package com.example.graph;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnTouchListener {

    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private float downX, downY, upX, upY;

    // Change this value to select the shape
    // 1 = Line
    // 2 = Circle
    // 3 = Rectangle
    private int shape = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView1);

        bitmap = Bitmap.createBitmap(
                1000,
                1500,
                Bitmap.Config.ARGB_8888
        );

        canvas = new Canvas(bitmap);

        // White background
        canvas.drawColor(Color.WHITE);

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        imageView.setImageBitmap(bitmap);
        imageView.setOnTouchListener(this);

        Toast.makeText(
                this,
                "Touch and drag to draw",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                downX = event.getX();
                downY = event.getY();

                return true;

            case MotionEvent.ACTION_UP:

                upX = event.getX();
                upY = event.getY();

                if (shape == 1) {

                    // Draw line
                    canvas.drawLine(
                            downX,
                            downY,
                            upX,
                            upY,
                            paint
                    );

                } else if (shape == 2) {

                    // Draw circle
                    float dx = upX - downX;
                    float dy = upY - downY;

                    float radius = (float) Math.sqrt(
                            dx * dx + dy * dy
                    );

                    canvas.drawCircle(
                            downX,
                            downY,
                            radius,
                            paint
                    );

                } else if (shape == 3) {

                    // Draw rectangle
                    canvas.drawRect(
                            downX,
                            downY,
                            upX,
                            upY,
                            paint
                    );
                }

                imageView.invalidate();

                return true;

            default:
                return true;
        }
    }
}