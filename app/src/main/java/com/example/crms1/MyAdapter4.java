package com.example.crms1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.ViewHolder> {

    private Context context;
    private List<String> users;

    public MyAdapter4(Context context, List<String> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_job_path, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String path = users.get(position);
        holder.bind(path);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPath;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPath = itemView.findViewById(R.id.textViewPath);
        }

        public void bind(String path) {
            textViewPath.setText(path);
        }
    }
}
