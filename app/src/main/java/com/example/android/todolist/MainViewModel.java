package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    private TaskRepository repository;

    public MainViewModel(Application application) {
        super(application);
       repository = new TaskRepository(application);
       tasks = repository.getData();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
