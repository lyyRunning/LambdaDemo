package com.function.luo.lambdademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView  recyclerView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);

        List<String> list = new ArrayList<>();
        list.add("JAVA");
        list.add("Android");
        list.add("IOS");
        list.add(".NET");
        list.add("PHP");
        list.add("C");
        list.add("C++");
         myAdapter = new MyAdapter(this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        //设置Adapter
        recyclerView.setAdapter(myAdapter);


        /**
         * 点击整个条目
         */
        myAdapter.setOnItemListener(new UtilsInterface.OnItemListener() {
            @Override
            public void onItemClick(int points, String msg) {
                Toast.makeText(MainActivity.this,points+msg,Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 采用 Lambda 表达式，点击 Item
         */
        myAdapter.setOnItemListener(
                ( points,  msg)
                        ->
                        Toast.makeText(MainActivity.this,points+msg,Toast.LENGTH_SHORT).show()
        );


        /**
         * 采用 Lambda 表达式，点击 Button
         */
        myAdapter.setOnButtonListener(
                ( points,  msg)
                        ->
                        Toast.makeText(MainActivity.this,points+msg,Toast.LENGTH_SHORT).show()
        );

    }


    /**
     * 采用 Java7 排序
     * @param view
     */
    public void btn1(View view) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        Log.d("LUO","Java 7 语法======="+names1);
    }

    /**
     * 采用 Java8 排序
     * @param view
     */
    public void btn2(View view) {
        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
        Log.d("LUO","Java 8 语法======="+names2);
    }

}
