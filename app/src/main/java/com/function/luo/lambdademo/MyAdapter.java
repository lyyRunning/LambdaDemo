package com.function.luo.lambdademo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luo on 2019/8/12.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private final Context context;
    private final List<String> list;
    private UtilsInterface.OnItemListener onItemListener;
    private UtilsInterface.OnButtonListener onButtonListener;


    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.tv_item.setText(list.get(position));
        //点击事件接口回调
        holder.ll_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemListener!=null){
                    onItemListener.onItemClick(position,"====item==="+list.get(position));

                }
            }
        });
        holder.ll_item.setOnClickListener((v) -> {
                    if (onItemListener!=null){
                        onItemListener.onItemClick(position, "====item===" + list.get(position));

                    }
                }

        );

        //点击 Button
//        holder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onButtonListener!=null){
//                    onButtonListener.onButtonClick(position,"====button==="+list.get(position));
//
//                }
//            }
//        });

        holder.button.setOnClickListener((v) -> {
                    if (onButtonListener != null) {
                        onButtonListener.onButtonClick(position, "====button===" + list.get(position));

                    }
                }


        );


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_item;
        LinearLayout ll_item;
        Button button;

        public MyHolder(View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            ll_item = itemView.findViewById(R.id.ll_item);
            button = itemView.findViewById(R.id.button);
        }
    }


    /**
     * 设置Item点击事假
     *
     * @param onItemListener
     */
    public void setOnItemListener(UtilsInterface.OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }


    /**
     * 点击 button 按钮
     */
    public void setOnButtonListener(UtilsInterface.OnButtonListener onButtonListener) {
        this.onButtonListener = onButtonListener;
    }


}
