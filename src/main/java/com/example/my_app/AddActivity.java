package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private Button button;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        button =(Button)findViewById(R.id.button3);
        et = (EditText) findViewById(R.id.add_id);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s1 = et.getText().toString();

                Intent intent =new Intent();
                intent.putExtra("name",s1);
                AddActivity.this.setResult(RESULT_OK,intent);
                AddActivity.this.finish();

            }
        });
    }
}
