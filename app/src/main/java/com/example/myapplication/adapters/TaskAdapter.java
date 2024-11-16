package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.models.Task;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(@NonNull Context context, @NonNull List<Task> tasks) {
        super(context, 0, tasks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview_item, parent, false);
        }

        Task task = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.job_title);
        TextView descriptionTextView = convertView.findViewById(R.id.job_description);

        titleTextView.setText(task.getTitle());
        descriptionTextView.setText(task.getDescription());

        return convertView;
    }
}

