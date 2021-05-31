/**
 * 
 */
package com.ysx.threadTest;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yangs
 *
 */
public class JncCopyOnWriteArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		new Thread().start();
	}

}
