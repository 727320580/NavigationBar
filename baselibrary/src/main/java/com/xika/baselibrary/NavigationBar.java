package com.xika.baselibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Email 727320580@qq.com
 * Created by xika on 2017/5/6
 * Vwesion 1.0
 * Dsscription:
 */

public abstract class NavigationBar<T extends NavigationBar.Builder.NavigationBarParams> implements INavigation {

    public T p;
    private SparseArray<WeakReference<View>> mViewArray;
    private View navigationView;

    public NavigationBar(T p) {
        this.p = p;
        mViewArray = new SparseArray<>();
        createAndBindView();
    }

    private void createAndBindView() {
        navigationView = LayoutInflater.from(p.mContext).inflate(bindViewId(), p.mParent, false);

        if (p.mParent != null) {
            // 获取类加载的根布局  通过源码获取内容
            ViewGroup viewRoot = (ViewGroup) ((Activity) (p.mContext)).findViewById(android.R.id.content);
            p.mParent = (ViewGroup) viewRoot.getChildAt(0);
        }
        if (p.mParent == null) {
            return;
        }
        p.mParent.addView(navigationView, 0);
        applyView();
    }

    public T getParams() {
        return p;
    }

    /**
     * 设置内容
     *
     * @param viewId
     * @param text
     */
    public void setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        if (!TextUtils.isEmpty(text) && tv != null) {
            tv.setVisibility(View.VISIBLE);
            tv.setText(text);
        }
    }

    /**
     * 设置点击事件
     *
     * @param viewId
     * @param listenner
     */
    public void setClick(int viewId, View.OnClickListener listenner) {
        View view = getView(viewId);
        if (view != null && listenner != null) {
            view.setVisibility(View.VISIBLE);
            view.setOnClickListener(listenner);
        }
    }

    /**
     * 设置图标
     *
     * @param viewId
     * @param resId
     */
    public void setIcon(int viewId, int resId) {
        View view = getView(viewId);
        if (view != null && resId != 0) {
            view.setVisibility(View.VISIBLE);
            view.setBackgroundDrawable(view.getResources().getDrawable(resId));
        }
    }

    /**
     * 获取布局的控件view
     *
     * @param viewId
     * @param <V>
     * @return
     */
    private <V extends View> V getView(int viewId) {
        WeakReference weakReference = mViewArray.get(viewId);
        View view = null;
        if (weakReference != null) {
            view = (View) weakReference.get();
        }
        if (view == null) {
            view = navigationView.findViewById(viewId);
            mViewArray.put(viewId, new WeakReference<>(view));
        }
        return (V) view;
    }


    // 创建头部建造者
    public static class Builder {

        public Builder(Context context, ViewGroup viewGroup) {
            new NavigationBarParams(context, viewGroup);
        }

        public static class NavigationBarParams {
            public Context mContext;
            public ViewGroup mParent;

            public NavigationBarParams(Context context, ViewGroup parent) {
                this.mContext = context;
                this.mParent = parent;
            }
        }
    }
}
