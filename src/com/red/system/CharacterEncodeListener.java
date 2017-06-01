package com.red.system;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.red.action.ActionBase;

/**
 * Application Lifecycle Listener implementation class CharacterEncodeListener
 *
 */
public class CharacterEncodeListener extends ActionBase implements ServletContextListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6072537035118606234L;

	/**
     * Default constructor. 
     */
    public CharacterEncodeListener() {
       System.out.println(System.getProperty("file.encoding"));
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
      System.setProperty("file.encoding", "UTF-8");
      System.out.println(System.getProperty("file.encoding"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
