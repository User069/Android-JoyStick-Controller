package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class Main extends Activity {
    private RelativeLayout layout_joystick1, layout_joystick2;
    private ImageView image_joystick1, image_joystick2;
    private TextView textView1, textView2, textView3, textView4, textView5;
    private TextView textView6, textView7, textView8, textView9, textView10;

    private JoyStickClass js1, js2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initialize the first joystick
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        layout_joystick1 = findViewById(R.id.layout_joystick1);

        js1 = new JoyStickClass(getApplicationContext(), layout_joystick1, R.drawable.image_button_bg);
        js1.setStickSize(150, 150);
        js1.setLayoutSize(500, 500);
        js1.setLayoutAlpha(150);
        js1.setStickAlpha(100);
        js1.setOffset(90);
        js1.setMinimumDistance(50);

        // Text views for joystick 2 values
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        layout_joystick2 = findViewById(R.id.layout_joystick2);

        js2 = new JoyStickClass(getApplicationContext(), layout_joystick2, R.drawable.controller);
        js2.setStickSize(150, 150);
        js2.setLayoutSize(500, 500);
        js2.setLayoutAlpha(150);
        js2.setStickAlpha(100);
        js2.setOffset(90);
        js2.setMinimumDistance(50);

        // Set touch listeners for both joysticks
        layout_joystick1.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                js1.drawStick(arg1);
                if (arg1.getAction() == MotionEvent.ACTION_DOWN
                        || arg1.getAction() == MotionEvent.ACTION_MOVE) {
                    textView1.setText("X : " + String.valueOf(js1.getX()));
                    textView2.setText("Y : " + String.valueOf(js1.getY()));
                    textView3.setText("Angle : " + String.valueOf(js1.getAngle()));
                    textView4.setText("Distance : " + String.valueOf(js1.getDistance()));

                    int direction = js1.get8Direction();
                    if (direction == JoyStickClass.STICK_UP) {
                        textView5.setText("Direction : Up");
                    } else if (direction == JoyStickClass.STICK_UPRIGHT) {
                        textView5.setText("Direction : Up Right");
                    } else if (direction == JoyStickClass.STICK_RIGHT) {
                        textView5.setText("Direction : Right");
                    } else if (direction == JoyStickClass.STICK_DOWNRIGHT) {
                        textView5.setText("Direction : Down Right");
                    } else if (direction == JoyStickClass.STICK_DOWN) {
                        textView5.setText("Direction : Down");
                    } else if (direction == JoyStickClass.STICK_DOWNLEFT) {
                        textView5.setText("Direction : Down Left");
                    } else if (direction == JoyStickClass.STICK_LEFT) {
                        textView5.setText("Direction : Left");
                    } else if (direction == JoyStickClass.STICK_UPLEFT) {
                        textView5.setText("Direction : Up Left");
                    } else if (direction == JoyStickClass.STICK_NONE) {
                        textView5.setText("Direction : Center");
                    }
                } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                    textView1.setText("X :");
                    textView2.setText("Y :");
                    textView3.setText("Angle :");
                    textView4.setText("Distance :");
                    textView5.setText("Direction :");
                }
                return true;
            }
        });

        layout_joystick2.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                js2.drawStick(arg1);
                if (arg1.getAction() == MotionEvent.ACTION_DOWN
                        || arg1.getAction() == MotionEvent.ACTION_MOVE) {
                    textView6.setText("X : " + String.valueOf(js2.getX()));
                    textView7.setText("Y : " + String.valueOf(js2.getY()));
                    textView8.setText("Angle : " + String.valueOf(js2.getAngle()));
                    textView9.setText("Distance : " + String.valueOf(js2.getDistance()));

                    int direction = js2.get8Direction();
                    if (direction == JoyStickClass.STICK_UP) {
                        textView10.setText("Direction : Up");
                    } else if (direction == JoyStickClass.STICK_UPRIGHT) {
                        textView10.setText("Direction : Up Right");
                    } else if (direction == JoyStickClass.STICK_RIGHT) {
                        textView10.setText("Direction : Right");
                    } else if (direction == JoyStickClass.STICK_DOWNRIGHT) {
                        textView10.setText("Direction : Down Right");
                    } else if (direction == JoyStickClass.STICK_DOWN) {
                        textView10.setText("Direction : Down");
                    } else if (direction == JoyStickClass.STICK_DOWNLEFT) {
                        textView10.setText("Direction : Down Left");
                    } else if (direction == JoyStickClass.STICK_LEFT) {
                        textView10.setText("Direction : Left");
                    } else if (direction == JoyStickClass.STICK_UPLEFT) {
                        textView10.setText("Direction : Up Left");
                    } else if (direction == JoyStickClass.STICK_NONE) {
                        textView10.setText("Direction : Center");
                    }
                } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
                    textView6.setText("X :");
                    textView7.setText("Y :");
                    textView8.setText("Angle :");
                    textView9.setText("Distance :");
                    textView10.setText("Direction :");
                }
                return true;
            }
        });
    }
}
