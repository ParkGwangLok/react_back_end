package com.pkr.project.thread;

public class RunnableExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyRunnable());
		thread.start(); // 스레드 실행
	}
}
