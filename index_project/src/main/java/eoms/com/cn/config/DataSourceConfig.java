package eoms.com.cn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/12/13 10:54
 */
@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableJpaRepositories(basePackages = {"eoms.com.cn.repository"},
		entityManagerFactoryRef = "entityManagerFactorymain",
		transactionManagerRef = "transactionManagermain")

public class DataSourceConfig {
	@Autowired
	private DataSource dataSource;

	@Bean(name = "entityManagerFactorymain")
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("eoms.com.cn.model");
		factory.setDataSource(dataSource);


		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		jpaProperties.put("hibernate.jdbc.batch_size", 50);
		jpaProperties.put("hibernate.show_sql", true);

		factory.setJpaPropertyMap(jpaProperties);
		factory.afterPropertiesSet();
		System.out.println("entityManagerFactory:" + factory.getObject());
		return factory.getObject();
	}

	@Bean(name = "transactionManagermain")
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		System.out.println("txManager:" + txManager);
		System.out.println(">>>>>>>>>>transactionManagerMain:" + txManager.getClass().getName());
		return txManager;
	}
}
