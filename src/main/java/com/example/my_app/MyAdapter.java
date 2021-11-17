package com.example.my_app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<com.example.my_app.Line> lineList;
    private ButtonInterface buttonInterface;
    private CheckBoxInterface checkBoxInterface;

    public MyAdapter(List<com.example.my_app.Line> lineList) {
        this.lineList = lineList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;

    }

    @Override
    public int getItemCount() {
        return lineList.size();
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        com.example.my_app.Line line = lineList.get(position);
        holder.num.setText(line.getNum());
        holder.time.setText(line.getTime());
        holder.t_f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(checkBoxInterface!=null) {
//                  //接口实例化后的而对象，调用重写后的方法
                        checkBoxInterface.onclick(holder.getAdapterPosition(),isChecked);
                    }
                    else ;


            }
        });
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonInterface!=null) {
//                  //接口实例化后的对象，调用重写后的方法
                    buttonInterface.onclick(holder.getAdapterPosition());
                }
                else ;

            }

        });
    }

    //按钮点击事件需要的方法
    public void buttonSetOnclick(ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }

    //确认框点击事件需要的方法
    public void checkboxSetOnclick(CheckBoxInterface checkBoxInterface){
        this.checkBoxInterface=checkBoxInterface;
    }

    //按钮点击事件对应的接口
    public interface ButtonInterface{
        public void onclick(int position);
    }
    //确认框点击事件对应的接口
    public interface CheckBoxInterface{
        public void onclick(int position,boolean isChecked);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView num;
        TextView time;
        CheckBox t_f;
        Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.num = itemView.findViewById(R.id.textView);
            this.time = itemView.findViewById(R.id.textView2);
            this.t_f = itemView.findViewById(R.id.checkBox);
            this.button = itemView.findViewById(R.id.button2);

        }
    }



}
