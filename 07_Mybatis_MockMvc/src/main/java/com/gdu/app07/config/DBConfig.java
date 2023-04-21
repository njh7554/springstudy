package com.gdu.app07.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@PropertySource(value={"classpath:application.properties"})	// application.properties 파일의 속성을 읽어 오자!
@EnableTransactionManagement								// transaction 처리를 허용하겠다. 		
@Configuration
public class DBConfig {
	
	@Autowired
	private Environment env;
	
	
	// HikaryConfig	Bean  application.properties에 있는 설정값을 불러온다.
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		// application.properties에 있는 spring.datasource.hikari.driver-class-name=oracle.jdbc.OracleDriver 값을 가져온다.
		hikariConfig.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
		hikariConfig.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
		hikariConfig.setUsername(env.getProperty("spring.datasource.hikari.username"));
		hikariConfig.setPassword(env.getProperty("spring.datasource.hikari.password"));
		return hikariConfig;
	}
	
	// HikariDataSource Bean	
	@Bean(destroyMethod="close")
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	// SqlSessionFactory Bean
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {  
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(hikariDataSource());
		// application.properties에 있는 mybatis.config-location을 전달
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(env.getProperty("mybatis.config-location")));
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
		return bean.getObject();  // SqlSessionFactory
	}
	
	// SqlSessionTemplate Bean (기존의 SqlSession)   결론적으로는 이걸 만들기위해 위의 작업들을 해주는 것.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception { // factory를 가져오기 때문에 던져줘야함.
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	// TransactionManager Bean
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(hikariDataSource());
	}
	
}
