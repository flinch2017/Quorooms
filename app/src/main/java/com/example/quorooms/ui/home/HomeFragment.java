package com.example.quorooms.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.quorooms.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Sample data for stories
        List<String> storyList = new ArrayList<>();
        storyList.add("User Story"); // User's story
        storyList.add("Story 1");
        storyList.add("Story 2");
        storyList.add("Story 3");

        // Initialize the StoriesAdapter
        StoriesAdapter storiesAdapter = new StoriesAdapter(storyList);

        // Set up the RecyclerView for stories
        binding.storiesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.storiesRecyclerView.setAdapter(storiesAdapter);

        // Set welcome text if needed


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
