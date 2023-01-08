package com.waiyanhtet.orm.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.waiyanhtet.orm.repo"})
@EnableTransactionManagement
public class DataAccessConfig {
	
	@Bean
	DataSource datasource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource datasource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		
		bean.setDataSource(datasource);
		bean.setPackagesToScan("com.waiyanhtet.orm.entity");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		bean.setJpaPropertyMap(map);
		
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;
	}
	
	@Bean
	JpaTransactionManager txManager() {
		return new JpaTransactionManager();
	}

}
