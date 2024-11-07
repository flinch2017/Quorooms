package com.example.quorooms.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quorooms.R;

import java.util.ArrayList;
import java.util.List;


public class StoryDetailActivity extends AppCompatActivity {

    private RecyclerView commentsRecyclerView;
    private List<String> commentsList;
    private CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);

        commentsRecyclerView = findViewById(R.id.commentsRecyclerView);
        commentsList = new ArrayList<>();

        commentsAdapter = new CommentsAdapter(commentsList);
        commentsRecyclerView.setAdapter(commentsAdapter);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Handle comment posting
        findViewById(R.id.postCommentButton).setOnClickListener(v -> {
            EditText commentInput = findViewById(R.id.commentInput);
            String comment = commentInput.getText().toString().trim();
            if (!comment.isEmpty()) {
                commentsList.add(comment);
                commentsAdapter.notifyItemInserted(commentsList.size() - 1);
                commentInput.setText("");
            }
        });
    }
}
