package com.samas.pedestriantest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WritePostActivity extends AppCompatActivity {

    private EditText editTextPost;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        editTextPost = findViewById(R.id.editTextPost);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
            }
        });
    }

    private void submitPost() {
        String postContent = editTextPost.getText().toString().trim();

        if (!postContent.isEmpty()) {
            Toast.makeText(this, "Пост отправлен: " + postContent, Toast.LENGTH_SHORT).show();
            editTextPost.setText("");
            finish();
        } else {
            Toast.makeText(this, "Пожалуйста, напишите что-нибудь!", Toast.LENGTH_SHORT).show();
        }
    }
}