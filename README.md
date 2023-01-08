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
