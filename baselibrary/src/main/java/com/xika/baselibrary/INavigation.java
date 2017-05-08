package com.xika.baselibrary;

/**
 * Email 727320580@qq.com
 * Created by xika on 2017/5/6
 * Vwesion 1.0
 * Dsscription: Navagation 的必须实现的接口 (接口内方法不用修饰符
 * )
 */

public interface INavigation {

    /**
     * 返回自定义的头部的布局
     * @return
     */
    int bindViewId();

    /**
     * 设置自定义的头部的view的属性功能
     */
    void applyView();

}
