package com.example.michael.canvasexample;

/**
 * Created by Michael on 4/10/2016.
 * Modified by hangaramYi on 2017.04.01
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class CanvasView extends View {

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    Context context;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 5;

    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        /*
        Todo : Paint 객체의 속성 설정
         */
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);
        /*
        Todo : 위의 drawPath() 메소드 호출을 지우고 변경된 색상이 유지되도록 변경하시오
         */
    }

    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
        /*
        Todo : ???
         */
    }

    public void clearCanvas() {
        /*
        Todo : 지우기 기능 구현
         */
        Toast.makeText(context, "Cleared", Toast.LENGTH_SHORT).show();
    }

    public void SetPenColor(int color) {
        /*
        Todo : mPaint 객체의 속성을 조정하여 색연필의 색깔 변경
         */
    }

    // when ACTION_UP stop touch
    private void upTouch() {
        mPath.lineTo(mX, mY);
    }

    //override the onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                /// Todo : 적절한 메소드 호출
                break;
            case MotionEvent.ACTION_MOVE:
                /// Todo : 적절한 메소드 호출
                break;
            case MotionEvent.ACTION_UP:
                /// Todo : 적절한 메소드 호출
                break;
        }
        return true;
    }
}
