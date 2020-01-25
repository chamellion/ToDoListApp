package com.example.android.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// TODO (5) Make this class extend ViewModel
public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> mTask;


    public AddTaskViewModel(AppDatabase mdb, int Id) {
        mTask = mdb.taskDao().loadTaskById(Id);
    }
    public LiveData<TaskEntry> getTask() {
        return mTask;
    }


    // TODO (6) Add a task member variable for the TaskEntry object wrapped in a LiveData

    // TODO (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId

    // TODO (7) Create a getter for the task variable
}
