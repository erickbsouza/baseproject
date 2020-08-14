package br.com.mobit.gvm;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.com.mobit.gvm.config.AppConfig;
import br.com.mobit.gvm.config.ViewScopeConfig;

public class AppInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class, ViewScopeConfig.class);
		ctx.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(ctx));
		servletContext.addListener(new RequestContextListener());
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);

	}

}
