package sch.hunnu.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import sch.hunnu.utils.SerializeUtil;
import sch.hunnu.utils.redisUtil;

/**
 * 用于给mybatis做二级缓存
 * @author Hi
 *
 */
public class mybatisRediCache  implements Cache{
	
	
	
	private final static Logger logger = LoggerFactory.getLogger(mybatisRediCache.class);
			
	
	private Jedis  jedis= redisUtil.getJedis(); 
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private String id;
	
	/**
	 * 构造函数 传入id
	 * @param id
	 */
	public mybatisRediCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id+"\n\n\n");
        this.id = id;
    }

	/**
	 * 返回id值
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * 将缓存 以key-value的形式进行序列化然后 写入redis
	 */
	@Override
	public void putObject(Object key, Object value) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value+"\n\n\n");
        jedis.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
	}

	/**
	 * 先将key进行序列化，根据这个序列化后的key 取得redis中指定的序列化后的byte内容取出 然后进行反序列化 成一个对象或者值
	 */
	@Override
	public Object getObject(Object key) {
		Object value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.toString())));
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value+"\n\n\n");
        return value;
	}
	
	/**
	 *	 删除指定的key　value
	 */
	@Override
	public Object removeObject(Object key) {
		  return jedis.del(SerializeUtil.serialize(key.toString()));
	}

	
	/**
	 * 删库 跑路
	 */
	@Override
	public void clear() {
		jedis.flushDB();
		
	}

	/**
	 * 返回reids数据库的大小
	 */
	@Override
	public int getSize() {
		  return Integer.valueOf(jedis.dbSize().toString());
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

}
