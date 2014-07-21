/*
 * (C) Copyright 2012 CashEdge Inc. All rights reserved.
 * This software is confidential and proprietary information of CashEdge Inc and except as authorized
 * or permitted under the Agreement between you and CashEdge you have no rights to use, transfer or otherwise
 * sublicense the CashEdge Software. You may not (i) copy or otherwise reproduce the CashEdge Software;
 * (ii) rent, transfer or grant any rights in the CashEdge Software in any form to any person.
 **/
package com.dep.demo.utils;

/**
 * @author wliu
 *
 */
public interface IMessage {
	
	public static final int CRITICAL = -1;
    public static final int NONE = 0;
    public static final int INFO = 1;
    public static final int ERROR = 2;
    public static final int WARNING = 3;
    public static final int DEBUG1 = 4;
    public static final int DEBUG2 = 5;
    public static final int PERF = 6;
   
    /**
     *This variable is added to hide the sensitive informations which is being displayed in the console. 
     *The log.level in CE_PROPERTIES Table is 300.Added by G.Gokul dt:30/09/2005 
     */
    public static final int SENSITIVE = 500; // 


    /**
     * @param level
     * @param message
     */
    public void println(int level, Object message);

    /**
     * @param level
     * @param e
     */
    public void printStackTrace(int level, Exception e);

    /**
     * @param level
     * @return
     */
    public boolean isEnabled(int level);

}


       