package com.example.andsadroid.room.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andsadroid.room.Model.Notes;
import com.example.andsadroid.room.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.NotesHolder> {

    private  List<Notes> allnotes =new ArrayList<>();

    public void setNotes(List<Notes> notess){
        this.allnotes=notess;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecycleAdapter.NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.NotesHolder holder, int position) {
       Notes note= allnotes.get(position);
       holder.title.setText(note.getNote());
       holder.description.setText(note.getDescription());
     }

    @Override
    public int getItemCount() {
        return allnotes.size();
    }

    public Notes getNote(int position){
        return allnotes.get(position);

    }

    public class NotesHolder extends RecyclerView.ViewHolder{


        TextView title;
        TextView description;
        TextView piorty;
        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text_view_title);
            description=itemView.findViewById(R.id.text_view_description);
         //   piorty=itemView.findViewById(R.id.text_view_priority);
        }
    }
}
