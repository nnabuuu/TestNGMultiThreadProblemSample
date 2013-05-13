package com.abuuu.automation;

import org.testng.Assert;

public class AssertThread implements Runnable{

	public void run() {
		//should fail
		Assert.assertEquals(1, 2);
	}

}
