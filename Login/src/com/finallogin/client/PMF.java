package com.finallogin.client;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PMF {
	private static final PersistenceManagerFactory pmInstance=
			JDOHelper.getPersistenceManagerFactory("transactions-optional");
	private PMF(){
		
	}
	public static PersistenceManagerFactory get() {
		return pmInstance;
	}
}
