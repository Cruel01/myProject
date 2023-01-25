package com.example.suitemediatest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Redapter extends RecyclerView.Adapter<Redapter.ViewHolder> {

    private List<post> post1;

    public Redapter(List<post> post1) {
        this.post1 = post1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.firstname.setText(post1.get(position).getName());
        holder.email.setText(post1.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return post1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView firstname, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.firstname);
            email = itemView.findViewById(R.id.email);
        }
    }
}
