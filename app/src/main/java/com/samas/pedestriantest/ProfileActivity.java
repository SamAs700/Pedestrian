package com.samas.pedestriantest;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView userName;
    private TextView userBio;
    private Button editProfileButton;
    private RecyclerView recyclerViewPosts;

    private List<String> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profile_image);
        userName = findViewById(R.id.user_name);
        userBio = findViewById(R.id.user_bio);
        editProfileButton = findViewById(R.id.edit_profile_button);
        recyclerViewPosts = findViewById(R.id.recycler_view_posts);
        String name = "Name";
        String bio = "Travel enthusiast exploring the world.";
        userName.setText(name);
        userBio.setText(bio);
        posts = new ArrayList<>();
        posts.add("Just visited the Eiffel Tower!");
        posts.add("Amazing food in Italy!");
        posts.add("Hiking in the Swiss Alps!");

        recyclerViewPosts.setLayoutManager(new LinearLayoutManager(this));
        PostAdapter postAdapter = new PostAdapter(posts);
        recyclerViewPosts.setAdapter(postAdapter);
        editProfileButton.setOnClickListener(v -> {

        });
    }
}