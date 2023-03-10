# Spring ORM configuration with Java in Legacy Springframework


## LocalContainerEntityManagerFactoryBean use for webapplication container

       @Bean
      LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        var bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return bean;
      }

      @Bean
      JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
      }

## LocalEntityManagerFactoryBean use for standalone application

       @Bean
	LocalEntityManagerFactoryBean entityManagerFactoryBean() {
		var bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

### Note! Datasource config with persistence.xml
	<?xml version="1.0" encoding="UTF-8"?>
	<persistence version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
		<persistence-unit name="spring-orm-start" transaction-type="RESOURCE_LOCAL">
			<properties>
				<property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
				<property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:testDB"/>
				<property name="javax.persistence.jdbc.user" value="sa"/>
				<property name="javax.persistence.jdbc.password" value="sa"/>
				<property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
				<property name="hibernate.show_sql" value="true"/>
				<property name="hibernate.format_sql" value="true"/>
			</properties>
		</persistence-unit>
	</persistence>
