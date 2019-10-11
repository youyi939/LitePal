package com.example.litepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Button create;
    private Button add;
    private Button delete;
    private Button find;
    private Button updata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.create);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        find = findViewById(R.id.find);
        updata = findViewById(R.id.updata);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
                Toast.makeText(Main2Activity.this,"数据库创建成功",Toast.LENGTH_LONG).show();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("三国");
                book.setAuthor("吴承恩");
                book.setPrice(16.1);
                book.save();
                Toast.makeText(Main2Activity.this,"添加数据成功",Toast.LENGTH_LONG).show();
            }
        });

        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("水壶");
                book.updateAll("name = ?","三国");
                Toast.makeText(Main2Activity.this,"修改数据成功",Toast.LENGTH_LONG).show();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"name = ?","水壶");
                Toast.makeText(Main2Activity.this,"删除数据成功",Toast.LENGTH_LONG).show();
            }
        });


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book:books){
                    Log.i("chen","book name is "+ book.getName());
                }
            }
        });


    }
}
