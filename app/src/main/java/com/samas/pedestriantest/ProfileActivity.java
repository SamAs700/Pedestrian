package com.samas.pedestriantest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView userName;
    private TextView userBio;
    private Button editProfileButton;
    private ListView listViewPosts;

    private List<String> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profile_image);
        userName = findViewById(R.id.user_name);
        userBio = findViewById(R.id.user_bio);
        editProfileButton = findViewById(R.id.edit_profile_button);
        listViewPosts = findViewById(R.id.list_view_posts);
        String name = "Name";
        String bio = "Travel enthusiast exploring the world.";
        userName.setText(name);
        userBio.setText(bio);
        posts = new ArrayList<>();
        posts.add("Just visited the Eiffel Tower!");
        posts.add("Amazing food in Italy!");
        posts.add("Hiking in the Swiss Alps!");
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                intent.putExtra("userName", userName.getText().toString());
                intent.putExtra("userBio", userBio.getText().toString());
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String updatedName = data.getStringExtra("userName");
            String updatedBio = data.getStringExtra("userBio");
            userName.setText(updatedName);
            userBio.setText(updatedBio);
        }
    }
}