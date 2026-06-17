package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class NotAppScopeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("注:アプリケーションスコープに保存できません");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("NotAppScopeListener が終了しました");
    }
}