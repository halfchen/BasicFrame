package com.chen.eye.debug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.chen.eye.R;
import com.chen.eye.fragment.VideoFragment;

public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.content, new VideoFragment());
        trans.commitAllowingStateLoss();
    }
}
