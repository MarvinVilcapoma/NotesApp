package com.vilcapoma.notesapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.vilcapoma.notesapp.R;
import com.vilcapoma.notesapp.models.Notes;
import com.vilcapoma.notesapp.models.User;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{
    private List<Notes> notes;

    public NotesAdapter(List<Notes>notes){
        this.notes=notes;
    }

    public void setNotes(List<Notes>notes){
        this.notes=notes;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            content = (TextView) itemView.findViewById(R.id.content_text);

        }
    }
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder viewHolder,final int position) {
        final Notes notes = this.notes.get(position);
        viewHolder.title.setText(notes.getTitle());
        viewHolder.content.setText(notes.getContent());


    }
    @Override
    public int getItemCount(){
        return this.notes.size();
    }
}
