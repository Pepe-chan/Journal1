package com.coding.journal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(new CircleView(this));

    }

    public class CircleView extends View implements View.OnTouchListener {

        Paint paint;
        int marginTop = 0;


        public CircleView(Context context) {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Display display = getWindowManager().getDefaultDisplay();
            Point displayPoint = new Point();
            display.getSize(displayPoint);

            int dWidth = displayPoint.x;
            int dHeight = displayPoint.y;


            int square = dWidth / 8;
            if (marginTop == 0)
                marginTop = (dHeight - square * 8) / 2;
            int marginLeft = (dWidth - square * 8) / 2;

            for(int i = 0; i < 8; i ++) {
                for (int j = 0; j < 8; j ++) {
                    if ((i + j) % 2 == 0)
                    canvas.drawRect(marginLeft + j * (square), marginTop + i * square,
                                    marginLeft +(j + 1) * square, marginTop + (i + 1) * square, paint);
                }
            }

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            marginTop -= 100;
            this.invalidate();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            return true;
        }
    }
}
