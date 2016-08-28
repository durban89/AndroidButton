package com.gowhich.androidbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener, View.OnFocusChangeListener, View.OnKeyListener {

    private int value = 1;
    private Button commonButton;
    private Button imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commonButton = (Button) this.findViewById(R.id.commonButton);
        imageButton = (Button) this.findViewById(R.id.imageButton);

        commonButton.setOnClickListener(this);

        imageButton.setOnClickListener(this);
        imageButton.setOnTouchListener(this);
        imageButton.setOnFocusChangeListener(this);
        imageButton.setOnKeyListener(this);
    }


    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        if(value == 1 && button.getWidth() == getWindowManager().getDefaultDisplay().getWidth()){
            value = -1;

        }else if (value == -1 && button.getWidth() < 100){
            value = 1;
        }

        button.setWidth(button.getWidth() + (int)(button.getWidth() * 0.1) * value);
        button.setHeight(button.getHeight() + (int) (button.getHeight() * 0.1) * value);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(b){
            view.setBackgroundResource(R.color.backgroundColor2);
        } else {
            view.setBackgroundResource(R.color.backgroundColor1);
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(KeyEvent.ACTION_UP == keyEvent.getAction()){
//            view.setBackgroundResource(R.drawable.button1);
            view.setBackgroundResource(R.color.backgroundColor2);
        } else if(KeyEvent.ACTION_DOWN == keyEvent.getAction()) {
            view.setBackgroundResource(R.color.backgroundColor1);
        }
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(MotionEvent.ACTION_UP == motionEvent.getAction()){
//            view.setBackgroundResource(R.drawable.button1);
            view.setBackgroundResource(R.color.backgroundColor2);
        } else if(MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
            view.setBackgroundResource(R.color.backgroundColor1);
        }
        return false;
    }
}
