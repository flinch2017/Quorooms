package com.example.quorooms.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide; // If using Glide for image loading
import com.example.quorooms.R;
import com.example.quorooms.ui.home.StoryViewActivity;
import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoryViewHolder> {

    private final List<String> storyList; // Assume each story is a URL or drawable reference

    public StoriesAdapter(List<String> storyList) {
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        String storyUrl = storyList.get(position);

        // Load the story image or the default image if the URL is null or empty
        if (storyUrl == null || storyUrl.isEmpty()) {
            // Load default image
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.nophoto) // Make sure this image exists
                    .into(holder.storyImage);
        } else {
            // Load the actual story image
            Glide.with(holder.itemView.getContext())
                    .load(storyUrl) // Assuming this is a URL
                    .into(holder.storyImage);
        }

        // Show the add story icon for the first item (user's story)
        holder.addStoryIcon.setVisibility(position == 0 ? View.VISIBLE : View.GONE);

        // Set onClickListener to open the story viewer when clicking on the story image
        holder.storyImage.setOnClickListener(v -> openStoryViewer(holder, storyUrl));

        // Set onClickListener to open the story viewer when clicking on the add story icon
        holder.addStoryIcon.setOnClickListener(v -> openStoryViewer(holder, storyUrl));
    }

    private void openStoryViewer(StoryViewHolder holder, String storyUrl) {
        Intent intent = new Intent(holder.itemView.getContext(), StoryViewActivity.class);
        intent.putExtra("story_url", storyUrl); // Pass the story URL or identifier
        holder.itemView.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImage;
        ImageView addStoryIcon;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = itemView.findViewById(R.id.storyImage);
            addStoryIcon = itemView.findViewById(R.id.addStoryIcon);
        }
    }
}
