package com.example.michael.canvasexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class AndroidCanvasExample extends Activity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_canvas_example);

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }
    public void SetColorPink(View v) {
        customCanvas.SetPenColor(0xFFFF4081);
    }
    public void SetColorBlack(View v) {
        customCanvas.SetPenColor(Color.BLACK);
    }
    public void SetColorGreen(View v) {
        customCanvas.SetPenColor(0xFF669900);
    }

}