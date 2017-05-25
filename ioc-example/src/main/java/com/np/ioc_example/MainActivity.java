package com.np.ioc_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.np.ioc.MyAnnotation;

@MyAnnotation("MainActivity 类")
public class MainActivity extends AppCompatActivity {

    @MyAnnotation("MainActivity 类中的成员变量")
    String mainActivityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
