package com.example.to_dolistproject.ui.fragments.bottom_navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.to_dolistproject.App;
import com.example.to_dolistproject.adapter.notes_adapter.AdapterNotes;
import com.example.to_dolistproject.databinding.FragmentHomeBinding;
import com.example.to_dolistproject.interfaces.OnItemClickListener;

public class HomeFragment extends Fragment {
    OnItemClickListener onItemClickListener;
    private FragmentHomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        initAdapter();


    }

    private void initAdapter() {
        App.getApp().getDb().noteDao().getAllNotes().observe(getViewLifecycleOwner(), taskList -> {
            AdapterNotes adapterNotes = new AdapterNotes(taskList);
            binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerview.setAdapter(adapterNotes);

        });
    }


//    private void deleteFromDatabase() {
//        adapterNotes.setOnItemLongClickListener(new OnItemLongClickListener() {
//            @Override
//            public void onItemPress(NoteModel noteModel) {
//                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
//                        .setTitle("Delete")
//                        .setMessage("Are you sure you want to delete this task?")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                App.getApp().getDb().noteDao().delete(noteModel);
//                                Toast.makeText(getActivity(), "You have successfully deleted this task!", Toast.LENGTH_SHORT).show();
//
//                            }
//                        })
//                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//
//                            }
//                        })
//                        .show();
//
//            }
//        });
//    }

    private void initListeners() {
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                createTaskFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });

    }

}