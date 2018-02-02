package br.mackenzie.lfs.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.persistence.EntityManager;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.mackenzie.lfs.controllers" })
public class WebConfiguration extends WebMvcConfigurerAdapter {
		
	@Bean
	public ViewResolver thymeleafViewResolver() {
		
		String [] thymeleafViewNames = new String [] {"thymeleaf/*"};
		
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
				
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine);
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		resolver.setViewNames(thymeleafViewNames);
		
		return resolver;
	}

	
	@Bean
	public ViewResolver jspViewResolver () {
				
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
		return resolver;
	}

}
