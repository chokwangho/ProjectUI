package com.example.administrator.sample;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by Administrator on 2016-04-12.
 */
@SuppressLint("DrawAllocation")
public class DrawActivity extends Activity {
    class Point {
        float x;
        float y;
        boolean isDraw;
        public Point(float x, float y, boolean isDraw) {
            this.x = x;
            this.y = y;
            this.isDraw = isDraw;
        }
    }

    class MyPaint extends View {
        public MyPaint(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            this.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch( event.getAction() ) {
                        case MotionEvent.ACTION_MOVE:
                            points.add(new Point(event.getX(), event.getY(), true));
                            invalidate();
                            break;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_DOWN:
                            points.add(new Point(event.getX(), event.getY(), false));
                    }
                    return true;
                }
            });
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.MAGENTA);
            p.setStrokeWidth(3);
            for(int i=1; i<points.size(); i++) {
                if(!points.get(i).isDraw) continue;
                canvas.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y, p);
            }
        }
    }
    ArrayList<Point> points = new ArrayList<Point>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyPaint mp = new MyPaint(this);
        setContentView(mp);
    }

}
