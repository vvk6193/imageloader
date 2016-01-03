package com.vivek.imageloader.tasks;

import java.util.concurrent.Callable;

/**
 * Created by v.vekariya on 12/10/2015.
 */
public class WorkerClass<T extends BaseTask> implements Callable{

    private T task;

    int priority;

//    public WorkerClass(T task) {
//        this.task = task;
//    }

    public WorkerClass(T task,int priority) {
        this.task = task;
        this.priority = priority;
    }

    @Override
    public Object call() throws Exception {
//        Log.d("maripriority", "executing " + getPriority());
        task.runTask();
        return new Object();
    }

}
