package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *  事务控制的配置类
 * @author zhy
 *
 */
public class TransactionManager {

	@Bean(name="transactionManager")
	public PlatformTransactionManager createTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
