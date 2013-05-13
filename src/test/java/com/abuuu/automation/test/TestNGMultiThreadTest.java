package com.abuuu.automation.test;

import org.testng.annotations.Test;

import com.abuuu.automation.AssertErrorThrowThread;
import com.abuuu.automation.AssertThread;
import com.abuuu.automation.AsynchTester;

public class TestNGMultiThreadTest {

	@Test
	public void assert_fail_in_thread_lead_to_test_pass() throws InterruptedException
	{
		Thread thread = new Thread(new AssertThread());
		thread.start();
		thread.join();
	}
	
	@Test
	public void throw_AssertionError_in_thread_lead_to_test_pass() throws InterruptedException
	{
		Thread thread = new Thread(new AssertErrorThrowThread());
		thread.start();
		thread.join();
	}
	
	@Test
	public void assert_fail_in_AsynchTester_lead_to_test_fail()
	{
		AsynchTester.run(new AssertThread());
	}
	
	@Test
	public void throw_AssertionError_in_AsynchTester_lead_to_test_fail()
	{
		AsynchTester.run(new AssertErrorThrowThread());
	}
}
