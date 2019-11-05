package com.chen.user.debug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.chen.user.R;
import com.chen.user.UserFragment;

public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.content, new UserFragment());
        trans.commitAllowingStateLoss();
    }
}
