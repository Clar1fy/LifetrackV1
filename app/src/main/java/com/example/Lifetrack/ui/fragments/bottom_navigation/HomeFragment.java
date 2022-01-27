package com.example.Lifetrack.ui.fragments.bottom_navigation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.Lifetrack.R;
import com.example.Lifetrack.adapter.notes_adapter.AdapterNotes;
import com.example.Lifetrack.data.NoteModel;
import com.example.Lifetrack.databinding.FragmentHomeBinding;
import com.example.Lifetrack.interfaces.OnItemClickListener;
import com.example.Lifetrack.utilities.App;

import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    AdapterNotes adapterNotes;
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
            adapterNotes = new AdapterNotes((List<NoteModel>) taskList, this);
            binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.recyclerview.setAdapter(adapterNotes);


        });
    }


    private void initListeners() {
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateTaskFragment createTaskFragment = new CreateTaskFragment();
                createTaskFragment.show(requireActivity().getSupportFragmentManager(), "");
            }
        });
        binding.deleteAllNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setTitle("Delete all notes")
                        .setMessage("Are you ok with deleting all tasks?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                App.getApp().getDb().noteDao().deleteAll();
                                Toast.makeText(getActivity(), "You have successfully deleted all tasks", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setIcon(getResources().getDrawable(R.drawable.ic_baseline_warning_24))
                        .show();

            }
        });


    }

    @Override
    public void onItemPress(NoteModel model) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete this task?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        App.getApp().getDb().noteDao().delete(model);
                        Toast.makeText(getActivity(), "You have successfully deleted this task!", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setIcon(getResources().getDrawable(R.drawable.delete_all_notes))
                .show();


    }

}