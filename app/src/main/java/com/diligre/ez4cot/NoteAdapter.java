package com.diligre.ez4cot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.diligre.ez4cot.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.textViewName.setText(currentNote.getName());
        holder.textViewBorn.setText(currentNote.getBorn());
        holder.textViewFrom.setText(currentNote.getFrom());
        holder.textViewLocation.setText(currentNote.getLocation());
        holder.textViewStudies.setText(currentNote.getStudies());
        holder.textViewPhone.setText(String.valueOf(currentNote.getPhone()));
        holder.textViewBiography.setText(currentNote.getBio());


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewBorn;
        private TextView textViewFrom;
        private TextView textViewLocation;
        private TextView textViewStudies;
        private TextView textViewPhone;
        private TextView textViewBiography;



        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name_default);
            textViewBorn = itemView.findViewById(R.id.born_default);
            textViewFrom = itemView.findViewById(R.id.from_default);
            textViewLocation = itemView.findViewById(R.id.location_default);
            textViewStudies = itemView.findViewById(R.id.studies_default);
            textViewPhone = itemView.findViewById(R.id.phone_default);
            textViewBiography = itemView.findViewById(R.id.biography_default);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(notes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
