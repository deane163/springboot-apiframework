package com.xiaoshu.task;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.xiaoshu.task.impl.LogTask;

public abstract class Task<T> implements Runnable {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataHandler<T> dataHandler;

	public ReentrantLock lock = new ReentrantLock();

	public ConcurrentLinkedQueue<T> queue = new ConcurrentLinkedQueue<T>();

	private static Task<?> task;

	/**
	 * 使用当独线程时，线程的休眠时间
	 */
	private static final long SLEEP_TIME = 5000;

	public Task(DataHandler<T> dataHandler) {
		super();
		this.dataHandler = dataHandler;
	}

	public void addQueue(T t) {
		queue.add(t);
	}
	
	@SuppressWarnings("rawtypes") 
	public static Task<?> getInstance(DataHandler dataHandler) throws Exception {

		return getInstance(LogTask.class, dataHandler);
	}

	@SuppressWarnings("rawtypes")
	public static Task<?> getInstance(Class<? extends Task> taskClazz,DataHandler dataHandler) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,IllegalArgumentException, InvocationTargetException {

		if (null == task) {
			Constructor<? extends Task> constructor = taskClazz.getConstructor(DataHandler.class);
			task = constructor.newInstance(dataHandler);
		}
		return task;

	}

	public void execute() {
		lock.lock();
		// 从队列中读取数据，并将数据批量写入到数据库
		try {
			List<T> lists = new ArrayList<T>();
			T t = queue.poll();
			while (null != t) {
				lists.add(t);
				t = queue.poll();
			}
			if (!CollectionUtils.isEmpty(lists)) {
				dataHandler.handleData(lists);
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(SLEEP_TIME);

				if (logger.isDebugEnabled()) {
					logger.info("每 {} 时间，执行一次 execute ！！！", SLEEP_TIME);
				}
				execute();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
