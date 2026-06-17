package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CounterListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		Integer count = 0;
		context.setAttribute("count", count);
		
		System.out.println("CounterListener 起動");
	}
	public void contextDestroyed(ServletContextEvent sce) {	
		 System.out.println("CounterListener 終了");
	}
}
