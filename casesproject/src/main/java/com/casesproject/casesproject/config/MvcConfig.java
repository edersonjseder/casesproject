package com.casesproject.casesproject.config;

import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.casesproject.casesproject.utils.RequestParameterConverter;
import com.casesproject.casesproject.utils.StringToEnumConverter;


@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	private ListableBeanFactory beanFactory;
	
	public MvcConfig(ListableBeanFactory beanFactory) {
        super();
        this.beanFactory = beanFactory;
    }
	

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
        Map<String, Object> components = beanFactory.getBeansWithAnnotation(RequestParameterConverter.class);
		components.values().parallelStream().forEach(c -> {
			if(c instanceof Converter<?, ?>) {
				registry.addConverter((Converter<?, ?>)c);
			}
		});
    }
}
