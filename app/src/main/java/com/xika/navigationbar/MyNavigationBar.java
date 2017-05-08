package com.xika.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.xika.baselibrary.NavigationBar;

/**
 * Email 727320580@qq.com
 * Created by xika on 2017/5/7
 * Vwesion 1.0
 * Dsscription:
 */

public class MyNavigationBar extends NavigationBar<MyNavigationBar.Builder.MyNavigationParams> {

    public MyNavigationBar(MyNavigationBar.Builder.MyNavigationParams params) {
        super(params);
    }

    @Override
    public int bindViewId() {
        return R.layout.title_bar;
    }

    @Override
    public void applyView() {
        if (getParams().title != null) {
            setText(R.id.title, getParams().title);
        }
        if (getParams().leftText != null) {
            setText(R.id.back, getParams().leftText);
        }
        if (getParams().leftListenner != null) {
            setClick(R.id.back, getParams().leftListenner);
        }
        if (getParams().leftResId != 0) {
            setIcon(R.id.back, getParams().leftResId);
        }
        if (getParams().rgihtText != null) {
            setText(R.id.right_text, getParams().rgihtText);
        }
        if (getParams().rightListenner != null) {
            setClick(R.id.right_text, getParams().rightListenner);
        }
        if (getParams().rightResId != 0) {
            setIcon(R.id.right_text, getParams().rightResId);
        }
    }

    public void setLeftClick(View.OnClickListener listenner) {
        setClick(R.id.back, listenner);
    }

    public void setRightClick(View.OnClickListener listenner) {
        setClick(R.id.right_text, listenner);
    }


    public static class Builder extends NavigationBar.Builder {

        public MyNavigationParams p;

        public Builder(Context context, ViewGroup viewGroup) {
            super(context, viewGroup);
            p = new MyNavigationParams(context, viewGroup);
        }

        public Builder setTitle(CharSequence title) {
            p.title = title;
            return this;
        }

        public Builder setLeftText(CharSequence text) {
            p.leftText = text;
            return this;
        }

        public Builder setLeftClick(View.OnClickListener listenner) {
            p.leftListenner = listenner;
            return this;
        }

        public Builder setLeftIcon(int leftResId) {
            p.leftResId = leftResId;
            return this;
        }

        public Builder setRightText(CharSequence text) {
            p.rgihtText = text;
            return this;
        }

        public Builder setRightClick(View.OnClickListener listenner) {
            p.rightListenner = listenner;
            return this;
        }

        public Builder setRightIcon(int rightResId) {
            p.rightResId = rightResId;
            return this;
        }

        public MyNavigationBar build() {
            MyNavigationBar navigation = new MyNavigationBar(p);
            return navigation;
        }


        public static class MyNavigationParams extends NavigationBarParams {

            public CharSequence title;
            public CharSequence leftText;
            public View.OnClickListener leftListenner = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) mContext).finish();
                }
            };
            public int leftResId;
            public int rightResId;
            public CharSequence rgihtText;
            public View.OnClickListener rightListenner;

            public MyNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }

}
