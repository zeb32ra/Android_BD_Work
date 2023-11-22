package com.example.pr17;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Groups_Adapter extends RecyclerView.Adapter<Groups_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Group> list;

    public Groups_Adapter(Context context, ArrayList<Group> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Group group = list.get(position);
        // groups's content
        holder.id = group.getId();
        holder.name = group.getName();
        holder.countStudent = group.getCountStudent();
        // end of group's content
        holder.tv.setText(group.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        int id;
        String name;
        int countStudent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.name_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), Change_Delete_View_Group.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("ID", id);
                    intent.putExtra("Name", name);
                    intent.putExtra("Count", countStudent);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
