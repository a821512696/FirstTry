package sch.hunnu.config;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;
import sch.hunnu.util.redisUtil;

@Configuration
@PropertySource("classpath:config/redis.properties")
public class redisConfig {

	/*
	 * 注解导入资源文件中的值并存储在成员变量里
	 */
	@Value("${redis.maxIdle}")
	private Integer maxIdle;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${redis.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${redis.numTestsPerEvicationRun}")
    private Integer numTestsPerEvictionRun;

    @Value("${redis.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${redis.testWhileIdle}")
    private boolean testWhileIdle;


    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes; 

    @Value("${spring.redis.cluster.max-redirects}")
    private Integer mmaxRedirectsac;

    
    //=========================单机模式=========================//
    /*
     * jedisPoolConfig 连接池
     * 配置 JedisPoolConfig 导入配置
     */
    @Bean("jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲数
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 连接池的最大数据库连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        // 最大建立连接等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        // 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        // 在空闲时检查有效性, 默认false
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
    
       
        return jedisPoolConfig;
    }
    
    /*
     * 单机模式
     * @Bean 默认是单例模式 如果要更改需要添加@Scope
     */
    
    @SuppressWarnings("deprecation")
	@Bean("JCfactory")
    public JedisConnectionFactory JCfactory(JedisPoolConfig jedisPoolConfig){
    	JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);

    	//连接池
    	factory.setPoolConfig(jedisPoolConfig);
    	//ip
    	factory.setHostName("127.0.0.1");
    	//port
    	factory.setPort(6380);
    	 //如果Redis设置有密码  
      //  factory.setPassword("123456");  
        //客户端超时时间单位是毫秒  
    	factory.setTimeout(5000);  
        return factory; 
    }

    /**
     * 利用redis的连接工厂 生成redisTemplate
     */
    
    @Bean("singleRT")
    public RedisTemplate<String, Object> ObjectRedisTemplate(JedisConnectionFactory JCfactory){
    	RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    	initDomainRedisTemplate(redisTemplate, JCfactory);
    	return redisTemplate;
    }
	
    /**
     * 设置数据存入redis后序列化的方式，并且开启事务
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！  
    /*
    	redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    */
    	//定义序列化方式
    	redisTemplate.setKeySerializer(new StringRedisSerializer());
    	redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    	
    	redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    	redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    	
    	//开启事务
    	redisTemplate.setEnableTransactionSupport(true);
    	//设置工厂
    	redisTemplate.setConnectionFactory(factory);
    	
    }
    
    //注入封装好的redisTemplate
    @Bean(name="redisUtil")
    public redisUtil buldRedisUtil(RedisTemplate<String, Object> singleRT){
    	redisUtil op = new redisUtil();
    	op.setRedisUtil(singleRT);
    	
    	return op;
    	
    }

}
