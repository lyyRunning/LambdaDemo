package com.function.luo.lambdademo;

/**
 * Created by luo on 2019/8/12.
 */

public class UtilsInterface {
    /**
     * 点击 Item
     */
    public interface OnItemListener{
        void  onItemClick(int points,String msg);
    }


    /**
     * 点击Button按钮
     */
    public interface  OnButtonListener{
        void onButtonClick(int points,String msg);
    }

}
