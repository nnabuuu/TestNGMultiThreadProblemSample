package com.abuuu.automation;

public class AsynchTester {
    private volatile static Error error;
    private volatile static RuntimeException runtimeExc;
    
    public static void run(final Runnable runnable)
    {
    	Thread thread = new Thread(new Runnable() { 
    		public void run() {
    			try {
    				runnable.run();
                } catch (Error e) {
                    error = e;
                } catch (RuntimeException e) {
                    runtimeExc = e;
                }
            }
        });
    	
    	thread.start();
    	try {
			thread.join();
		} catch (InterruptedException e) {

		}
    	
    	//Throw error for TestNG to capture.
    	if (error != null)
    		throw error;
    	if (runtimeExc != null)
    		throw runtimeExc;
    }
}
