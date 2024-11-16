package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapters.TaskAdapter;
import com.example.myapplication.models.Task;

import java.util.ArrayList;
import java.util.List;

public class DayFragment extends Fragment {

    private ListView todayTaskListView;
    private ImageView arrowBack;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedule_day, container, false);
        todayTaskListView = view.findViewById(R.id.today_task_list);


        return view;
    }
}
