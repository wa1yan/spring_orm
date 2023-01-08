# spring_orm

  - Without Persistence.xml
  
  - LocalContainerEntityManagerFactoryBean - use for webapplication 
  
  - Add package to scan and add jpa properties
  
  - HibernateJpaVendorAdapter - use instead of persisence provider


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
