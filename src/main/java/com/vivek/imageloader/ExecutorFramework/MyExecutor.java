package com.vivek.imageloader.ExecutorFramework;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by vivek-pc on 12/5/2015.
 * http://stackoverflow.com/questions/807223/how-do-i-implement-task-prioritization-using-an-executorservice-in-java-5
 * http://funofprograming.blogspot.in/2013/11/priorityexecutorservice-for-java.html
 */
public class MyExecutor {

    private static MyExecutor instance;

    private final BlockingQueue<Runnable> mDecodeWorkQueue = new LinkedBlockingQueue<Runnable>();

    private static int NUMBER_OF_CORES =
            Runtime.getRuntime().availableProcessors();

    private static final int KEEP_ALIVE_TIME = 1;
    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    // Instantiates the queue of Runnables as a LinkedBlockingQueue
    // Creates a thread pool manager
    private final ExecutorService executor;

    private MyExecutor() {
        executor = Executors.newFixedThreadPool(NUMBER_OF_CORES);
        /*executor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,       // Initial pool size
                NUMBER_OF_CORES,       // Max pool size
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                mDecodeWorkQueue);*/
//        executor = getPriorityExecutor(NUMBER_OF_CORES);
    }

    public static synchronized MyExecutor getInstance() {
        if (instance == null) {
            instance = new MyExecutor();
            return instance;
        } else {
            return instance;
        }
    }

    public Future<?> submit(Callable callable) {
        return executor.submit(callable);
    }

}
