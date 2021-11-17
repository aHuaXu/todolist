package com.example.my_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_app.Dao;
import com.example.my_app.Line;
import com.example.my_app.MyAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button button;

    Dao dao = new Dao(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //按钮
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        //布局
        recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(dao.query());
        recyclerView.setAdapter(myAdapter);

        myAdapter.buttonSetOnclick(new MyAdapter.ButtonInterface() {
            @Override
            public void onclick(int position) {
                View view = layoutManager.getChildAt(position);
                TextView textView = view.findViewById(R.id.textView);
                String str = textView.getText().toString();
                dao.delete(str);
                Toast.makeText(MainActivity.this, "成功删除任务：" + str, 2 * Toast.LENGTH_SHORT).show();

            }
        });

        myAdapter.checkboxSetOnclick(new MyAdapter.CheckBoxInterface() {
            @Override
            public void onclick(int position, boolean isChecked) {
                View view = layoutManager.getChildAt(position);
                TextView textView = view.findViewById(R.id.textView);
                String str = textView.getText().toString();
                if (isChecked) {
                    dao.updatet(str);
                    Toast.makeText(MainActivity.this, "恭喜你！你完成了任务：" + str, 2 * Toast.LENGTH_SHORT).show();
                } else {
                    dao.updatef(str);
                    Toast.makeText(MainActivity.this, "继续加油完成任务：" + str, 2 * Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String s1 = data.getStringExtra("name");

        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String s2 = simpleDateFormat.format(date);

        Line line = new Line(s1, s2, false);
        Dao dao = new Dao(this);
        dao.insert(line);

        //布局
        recyclerView = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(dao.query());
        recyclerView.setAdapter(myAdapter);

        myAdapter.buttonSetOnclick(new MyAdapter.ButtonInterface() {
            @Override
            public void onclick(int position) {
                View view = layoutManager.getChildAt(position);
                TextView textView = view.findViewById(R.id.textView);
                String str = textView.getText().toString();
                dao.delete(str);
                Toast.makeText(MainActivity.this, "成功删除任务：" + str, 2 * Toast.LENGTH_SHORT).show();

            }
        });

        myAdapter.checkboxSetOnclick(new MyAdapter.CheckBoxInterface() {
            @Override
            public void onclick(int position, boolean isChecked) {
                View view = layoutManager.getChildAt(position);
                TextView textView = view.findViewById(R.id.textView);
                String str = textView.getText().toString();
                if (isChecked) {
                    dao.updatet(str);
                    Toast.makeText(MainActivity.this, "恭喜你！你完成了任务：" + str, 2 * Toast.LENGTH_SHORT).show();
                } else {
                    dao.updatef(str);
                    Toast.makeText(MainActivity.this, "继续加油完成任务：" + str, 2 * Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}