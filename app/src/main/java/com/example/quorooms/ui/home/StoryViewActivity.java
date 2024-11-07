package com.example.quorooms.ui.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide; // For image loading with Glide
import com.example.quorooms.R;


public class StoryViewActivity extends AppCompatActivity {

    private ImageView storyImageView;
    private ImageView reactButton;
    private EditText commentEditText;
    private Button sendCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        storyImageView = findViewById(R.id.storyImageView);
        reactButton = findViewById(R.id.reactButton);
        commentEditText = findViewById(R.id.commentEditText);
        sendCommentButton = findViewById(R.id.sendCommentButton);

        String storyUrl = getIntent().getStringExtra("story_url");
        // Load the story image into the ImageView
        Glide.with(this).load(storyUrl).into(storyImageView);

        // Set up the react button
        reactButton.setOnClickListener(v -> {
            // Handle reaction logic
            // You can toggle the heart image or perform another action
        });

        // Send comment functionality
        sendCommentButton.setOnClickListener(v -> {
            String comment = commentEditText.getText().toString();
            // Handle sending comment logic
        });
    }
}
