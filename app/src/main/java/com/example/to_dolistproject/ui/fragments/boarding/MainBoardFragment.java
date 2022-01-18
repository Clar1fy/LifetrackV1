package com.example.to_dolistproject.ui.fragments.boarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.to_dolistproject.R;
import com.example.to_dolistproject.adapter.ViewPagerAdapter;
import com.example.to_dolistproject.databinding.FragmentMainBoardBinding;
import com.example.to_dolistproject.model.ViewPagerModel;
import com.example.to_dolistproject.databinding.FragmentBoardBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainBoardFragment extends Fragment {
    private FragmentMainBoardBinding binding;
    ViewPagerAdapter adapter;
    ArrayList<ViewPagerModel> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new ViewPagerModel("Welcome to productive life!", "You can plan your time,add and organize tasks. Reminders so that you don't forget a thing - we take care of it.", R.drawable.onboarding_first_image));
        list.add(new ViewPagerModel("Collaboration with students", "You can create a common study schedule,group tasks,manage them and communicate with other members.", R.drawable.onboarding_second_image));
        list.add(new ViewPagerModel("How to keep up everything?", "You can track your productivity, see your results and progress. Also,this is a great opportunity to track how much time you spend studying", R.drawable.onboarding_third_image));
        adapter = new ViewPagerAdapter(list);
        binding.viewpager.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.viewpager);

    }
}