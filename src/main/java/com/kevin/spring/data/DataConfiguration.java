package com.kevin.spring.data;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.kevin.spring.data")
@EnableTransactionManagement
@ComponentScan("com.kevin.spring.data")
@EnableJpaAuditing( auditorAwareRef = "customAuditorAware")
public class DataConfiguration {

	@Bean
	public DataSource dataSourceBean() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
		return embeddedDatabaseBuilder.build();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setGenerateDdl(true);
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalContainerEntityManagerFactoryBean locEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		locEntityManagerFactoryBean.setDataSource(dataSourceBean());
		locEntityManagerFactoryBean.setPackagesToScan("com.kevin.spring.data");
		locEntityManagerFactoryBean.setJpaVendorAdapter(adapter);
		locEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		locEntityManagerFactoryBean.afterPropertiesSet();
		return locEntityManagerFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txmaManager = new JpaTransactionManager();
		txmaManager.setEntityManagerFactory(entityManagerFactory());
		return txmaManager;
	}
	
}
