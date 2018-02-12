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
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "br.mackenzie.lfs.controllers" })
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver thymeleafViewResolver() {

		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		resolver.setViewNames(new String[] { "thymeleaf/*" });

		return resolver;
	}

	@Bean
	public ViewResolver jspViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
		return resolver;
	}

}
