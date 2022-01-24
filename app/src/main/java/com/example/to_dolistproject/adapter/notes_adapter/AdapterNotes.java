package com.example.to_dolistproject.adapter.notes_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.to_dolistproject.data.NoteModel;
import com.example.to_dolistproject.databinding.NotesHolderBinding;
import com.example.to_dolistproject.interfaces.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.HolderNotes> {
    List<NoteModel> list = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public AdapterNotes(List<NoteModel> list) {
        this.list = list;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdapterNotes.HolderNotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderNotes(NotesHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes.HolderNotes holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderNotes extends RecyclerView.ViewHolder {
        private NotesHolderBinding binding;

        public HolderNotes(@NonNull NotesHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(NoteModel noteModel) {
            binding.tvTask.setText(noteModel.getTaskName());
            binding.tvDate.setText(noteModel.getDate());
            binding.tvFrequency.setText(noteModel.getFrequency());

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    onItemClickListener.onItemPress(noteModel);
                    return true;
                }
            });
        }
    }
}
