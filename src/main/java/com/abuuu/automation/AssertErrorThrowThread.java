package com.abuuu.automation;

public class AssertErrorThrowThread implements Runnable{

	public void run() {
		throw new AssertionError("assertion Error");
	}

	
}
