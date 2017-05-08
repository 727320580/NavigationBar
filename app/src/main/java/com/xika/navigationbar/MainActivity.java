package com.xika.navigationbar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xika.baselibrary.NavigationBar;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        MyNavigationBar topBar = new MyNavigationBar.Builder(mContext, (ViewGroup) findViewById(R.id.activity_main))
                .setTitle("内涵段子")
                .setRightIcon(R.drawable.ic_img_del)
                .build();
        topBar.setRightClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "删除", Toast.LENGTH_LONG).show();
            }
        });
    }
}
