package sch.hunnu.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;
import sch.hunnu.util.redisUtil;

@Configuration
@PropertySource("classpath:config/redis.properties")
public class redisConfigCluster {

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

    
    //=========================集群模式=========================//
    /*
     * jedisPoolConfig 连接池
     * 配置 JedisPoolConfig 导入配置
     */
    @Bean("jedisPoolConfigCluster")
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

    /**
     * redis集群模式 
     * @return
     */
    @Bean("redisClusterConfiguration")
    public RedisClusterConfiguration redisClusterConfiguration(){
    	RedisClusterConfiguration cluster = new RedisClusterConfiguration();
    
    	//cluster.setPassword(RedisPassword.of("123456"));		//设置密码
  
    	String[] servers = clusterNodes.split(",");
    	
    	Set<RedisNode> nodes = new HashSet<RedisNode>();
    	
    	for(String serverMes:servers){
    		String[] ipAndPort = serverMes.split(":");
    		RedisNode node = new RedisNode(ipAndPort[0].trim(), Integer.parseInt(ipAndPort[1].trim()));	//生成服务器结点
    		
    		nodes.add(node);
    	}
    	
    	cluster.setClusterNodes(nodes);
    	cluster.setMaxRedirects(mmaxRedirectsac);
    	
    	return cluster;
    }
    
    /**
     * 配置工厂
    * @Title: JedisConnectionFactory 
    * @param @param jedisPoolConfig
    * @param @return
    * @return JedisConnectionFactory
    * @autor lpl
    * @date 2017年12月22日
    * @throws
     */
    @Bean("clusterJedisConnectionFactory")
    public JedisConnectionFactory JedisConnectionFactory(JedisPoolConfig jedisPoolConfigCluster,RedisClusterConfiguration redisClusterConfiguration){
        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfigCluster);
        return JedisConnectionFactory; 
    }

   
    /**
     * 利用redis的连接工厂 生成redisTemplate
     * @param clusterJedisConnectionFactory
     * @return
     */
    @Bean("clusterRT")
    public RedisTemplate<String, Object> ObjectRedisTemplate(JedisConnectionFactory clusterJedisConnectionFactory){
    	RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    	initDomainRedisTemplate(redisTemplate, clusterJedisConnectionFactory);
    	return redisTemplate;
    }
	
    /**
     * 设置数据存入redis后序列化的方式，并且开启事务
     * @param redisTemplate
     * @param factory
     */
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！  
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
    @Bean(name="redisUtilCluster")
    public redisUtil buldRedisUtil(RedisTemplate<String, Object> clusterRT){
    	redisUtil op = new redisUtil();
    	op.setRedisUtil(clusterRT);
    	
    	return op;
    	
    }

}
