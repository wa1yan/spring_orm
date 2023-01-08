# spring_orm


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

### Note! Datasource config with persistence.xml
