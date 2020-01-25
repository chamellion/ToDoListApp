package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class TaskRepository {

    private AppDatabase mdb;

    LiveData<List<TaskEntry>> mData;

    public TaskRepository(Application application) {
        mdb = AppDatabase.getInstance(application.getApplicationContext());
        mData = mdb.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getData() {
        return mData;
    }
    void insertTask(final TaskEntry taskEntry){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mdb.taskDao().insertTask(taskEntry);
            }
        });
    }
    void updateTask(final TaskEntry taskEntry){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mdb.taskDao().updateTask(taskEntry);
            }
        });
    }
    void deleteTask(final TaskEntry taskEntry){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mdb.taskDao().deleteTask(taskEntry);
            }
        });
    }
    LiveData<TaskEntry> queryWithID(int id){
         LiveData<TaskEntry> tasks = mdb.taskDao().loadTaskById(id);
         return tasks;
    }
}
