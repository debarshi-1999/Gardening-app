package com.example.gardeningapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Chat extends AppCompatActivity {
    LinearLayout screen;
    private static final int PICK_IMAGE=1;
    Uri imageuri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar=findViewById(R.id.tool1);
        setSupportActionBar(toolbar);
        ImageView imageView=findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Chat.this,MainActivity.class);
                startActivity(inte);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.wallpaper){
            //screen=findViewById(R.id.chatWall);
            //screen.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.yd1));
            screen=(LinearLayout)findViewById(R.id.chatWall);
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"select image"),PICK_IMAGE);
        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK){
            imageuri=data.getData();
            try {InputStream inputStream=getContentResolver().openInputStream(imageuri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                //Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
                screen.setBackground(bitmapDrawable);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
