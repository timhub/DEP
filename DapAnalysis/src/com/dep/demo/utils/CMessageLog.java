/*
 * (C) Copyright 2012 CashEdge Inc. All rights reserved.
 * This software is confidential and proprietary information of CashEdge Inc and except as authorized
 * or permitted under the Agreement between you and CashEdge you have no rights to use, transfer or otherwise
 * sublicense the CashEdge Software. You may not (i) copy or otherwise reproduce the CashEdge Software;
 * (ii) rent, transfer or grant any rights in the CashEdge Software in any form to any person.
 **/
package com.dep.demo.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author terrance tian
 *
 */
public final class CMessageLog implements IMessage {

	private static CMessageLog theInstance = null;
	private static Logger log4JLogger;

	private int logLevel = 5;

	private CMessageLog() {
		config();
	}

	/**
	 * The user will invoke this method to get instance of CMessageLog
	 * 
	 * @return
	 */
	public static CMessageLog getInstance() {
		if (theInstance == null) {
			theInstance = new CMessageLog();
		}
		return theInstance;
	}

	/**
	 * The method will config log4j
	 */
	private void config() {
		try {
			PropertyConfigurator.configure("D:\\Cashedge-AllData2\\DEP\\DapAnalysis\\WebContent\\log4j.properties");
			log4JLogger = Logger.getLogger("com.dep");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cashedge.common.utils.IMessage#isEnabled(int)
	 */
	public boolean isEnabled(int level) {
		if (level <= logLevel) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cashedge.common.utils.IMessage#printStackTrace(int, java.lang.Exception)
	 */
	public void printStackTrace(int level, Exception e) {
		 java.io.ByteArrayOutputStream ops = new java.io.ByteArrayOutputStream();
	     java.io.PrintStream ps = new java.io.PrintStream(ops);
	     e.printStackTrace(ps);
	     println(level, ops);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cashedge.common.utils.IMessage#println(int, java.lang.Object)
	 */
	public void println(int level, Object message) {
		if (log4JLogger == null) {
			return;
		}
		message = getCallerInfo() + message;
		switch (level) {
		case IMessage.DEBUG1:
			if (this.isEnabled(IMessage.DEBUG1)) {
				log4JLogger.debug(message);
			}
			break;
		case IMessage.DEBUG2:
			if (this.isEnabled(IMessage.DEBUG2)) {
				log4JLogger.debug(message);
			}
			break;
		case IMessage.INFO:
			if (this.isEnabled(IMessage.INFO)) {
				log4JLogger.info(message);
			}
			break;
		case IMessage.WARNING:
			if (this.isEnabled(IMessage.WARNING)) {
				log4JLogger.warn(message);
			}
			break;
		case IMessage.ERROR:
			if (this.isEnabled(IMessage.ERROR)) {
				log4JLogger.error(message);
			}
			break;
		case IMessage.CRITICAL:
			if (this.isEnabled(IMessage.CRITICAL)) {
				log4JLogger.fatal(message);
			}
			break;
		}
	}
	
	 /**
     * This method will get the info of caller
     * @return
     */
    public String getCallerInfo() {
        StringBuffer sb1 = new StringBuffer();
        try {
            Throwable ex = new Throwable();
            StackTraceElement[] stackElements = ex.getStackTrace();
            int slen = stackElements.length;
            if (slen >= 2) {
                StackTraceElement selem = stackElements[2];
                sb1.append("(");
                sb1.append(selem.getFileName());
                sb1.append(":");
                sb1.append(selem.getLineNumber());
                sb1.append(") ");
            } else {
                sb1.append("N/A ");
            }
        } catch (Exception e) {
            sb1.append("N/A excp ");
        }
        return sb1.toString();
    }
    
    
    
    public boolean isDebugEnabled() {
    	return isEnabled(DEBUG1);
    }
    
    public void debug(String msg) {
    	if(!isDebugEnabled()){
    		return;
    	}
    	println(DEBUG1, msg);
    }

	public void error(Exception e, String string) {
		printStackTrace(ERROR, e);		
	}
}
