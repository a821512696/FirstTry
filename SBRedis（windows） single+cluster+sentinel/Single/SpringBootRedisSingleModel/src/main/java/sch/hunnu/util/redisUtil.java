package sch.hunnu.util;

import java.util.List; 
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import redis.clients.jedis.Jedis;

public class redisUtil {
	
	private RedisTemplate<String, Object> template;
	
	public  void  setRedisUtil(RedisTemplate<String, Object> template){
		this.template = template;
	}
	
	
	//=============================common============================  
	
	/**
	 * 设置key 的存活时间
	 * @param key
	 * @param time
	 * @return true 设置成功； false 设置失败
	 */
	public boolean expire(String key,long time){
		try{
		if(time>0){
		template.expire(key, time, TimeUnit.SECONDS);	
		}
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获取键还能存活的时间
	 * @param key
	 * @return 还未到期的时间
	 */
	public long getExpire(String key){
		return template.getExpire(key);
	}
	
	/**
	 * 判断键是否存在
	 * @param key
	 * @return true存在 ；false不存在
	 */
	public boolean hasKey(String key){
		return template.hasKey(key);
	}
	
	/**
	 * 删除一个或者多个key
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	public void del(String ... key){
		if(key!=null && key.length>0){
			if(key.length==1){
				template.delete(key[0]);
			}
			else{	//数组转为list
				template.delete(CollectionUtils.arrayToList(key));
			}
		}
	}
	
	//=============================String============================
	
	 /**
	  * 普通缓存 读操作
	  * @param key
	  * @return Object
	  */
	public Object get(String key){
		return template.opsForValue().get(key);
	}
	
	/**
	 * 普通缓存 写操作
	 * @param key
	 * @param value
	 * @return true 表示操作成功 ；false 表示操作失误
 	 */
	public boolean set(String key,Object value){
		try{
		template.opsForValue().set(key, value);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	 /** 
     * 普通缓存放入并设置时间 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期 
     * @return true成功 false 失败 
     */  
    public boolean set(String key,Object value,long time){  
        try {
            if(time>0){  
                template.opsForValue().set(key, value, time, TimeUnit.SECONDS);  
            }else{  
                set(key, value);  
            }  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  
    
    
    /** 
     * 递增 
     * @param key 键 
     * @param by 要增加几(大于0) 
     * @return 
     */  
    public long incr(String key, long delta){    
        if(delta<0){  
            throw new RuntimeException("递增因子必须大于0");  
        }  
        return template.opsForValue().increment(key, delta);  
    }  
    
    /** 
     * 递减 
     * @param key 键 
     * @param by 要减少几(小于0) 
     * @return 
     */  
    public long decr(String key, long delta){    
        if(delta<0){  
            throw new RuntimeException("递减因子必须大于0");  
        }  
        return template.opsForValue().increment(key, -delta);    
    }    
	
    //================================Map=================================  
    /** 
     * HashGet 
     * @param key 键 不能为null 
     * @param item 项 不能为null 
     * @return 值 
     */  
    public Object hget(String key,String item){  
        return template.opsForHash().get(key, item);  
    }  


    /** 
     * 获取hashKey对应的所有键值 
     * @param key 键 
     * @return 对应的多个键值 
     */  
    public Map<Object,Object> hmget(String key){  
        return template.opsForHash().entries(key);  
    }  
	

    /** 
     * HashSet 
     * @param key 键 
     * @param map 对应多个键值 
     * @return true 成功 false 失败 
     */  
    public boolean hmset(String key, Map<String,Object> map){    
        try {  
            template.opsForHash().putAll(key, map);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * HashSet 并设置时间 
     * @param key 键 
     * @param map 对应多个键值 
     * @param time 时间(秒) 
     * @return true成功 false失败 
     */  
    public boolean hmset(String key, Map<String,Object> map, long time){    
        try {  
            template.opsForHash().putAll(key, map);  
            if(time>0){  
                expire(key, time);  
            }  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 向一张hash表中放入数据,如果不存在将创建 
     * @param key 键 
     * @param item 项 
     * @param value 值 
     * @return true 成功 false失败 
     */  
    public boolean hset(String key,String item,Object value) {  
         try {  
            template.opsForHash().put(key, item, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 向一张hash表中放入数据,如果不存在将创建 
     * @param key 键 
     * @param item 项 
     * @param value 值 
     * @param time 时间(秒)  注意:如果已存在的hash表有时间,这里将会替换原有的时间 
     * @return true 成功 false失败 
     */  
    public boolean hset(String key,String item,Object value,long time) {  
         try {  
            template.opsForHash().put(key, item, value);  
            if(time>0){  
                expire(key, time);  
            }  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 删除hash表中的值 
     * @param key 键 不能为null 
     * @param item 项 可以使多个 不能为null 
     */  
    public void hdel(String key, Object... item){    
        template.opsForHash().delete(key,item);  
    }   

    /** 
     * 判断hash表中是否有该项的值 
     * @param key 键 不能为null 
     * @param item 项 不能为null 
     * @return true 存在 false不存在 
     */  
    public boolean hHasKey(String key, String item){  
        return template.opsForHash().hasKey(key, item);  
    }   

    /** 
     * hash递增 如果不存在,就会创建一个 并把新增后的值返回 
     * @param key 键 
     * @param item 项 
     * @param by 要增加几(大于0) 
     * @return 
     */  
    public double hincr(String key, String item,double by){    
        return template.opsForHash().increment(key, item, by);  
    }  

    /** 
     * hash递减 
     * @param key 键 
     * @param item 项 
     * @param by 要减少记(小于0) 
     * @return 
     */  
    public double hdecr(String key, String item,double by){    
        return template.opsForHash().increment(key, item,-by);    
    }    

    //============================set=============================  
    /** 
     * 根据key获取Set中的所有值 
     * @param key 键 
     * @return 
     */  
    public Set<Object> sGet(String key){  
        try {  
            return template.opsForSet().members(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 根据value从一个set中查询,是否存在 
     * @param key 键 
     * @param value 值 
     * @return true 存在 false不存在 
     */  
    public boolean sHasKey(String key,Object value){  
        try {  
            return template.opsForSet().isMember(key, value);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将数据放入set缓存 
     * @param key 键 
     * @param values 值 可以是多个 
     * @return 成功个数 
     */  
    public long sSet(String key, Object...values) {  
        try {  
            return template.opsForSet().add(key, values);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 将set数据放入缓存 
     * @param key 键 
     * @param time 时间(秒) 
     * @param values 值 可以是多个 
     * @return 成功个数 
     */  
    public long sSetAndTime(String key,long time,Object...values) {  
        try {  
            Long count = template.opsForSet().add(key, values);  
            if(time>0) expire(key, time);  
            return count;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 获取set缓存的长度 
     * @param key 键 
     * @return 
     */  
    public long sGetSetSize(String key){  
        try {  
            return template.opsForSet().size(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 移除值为value的 
     * @param key 键 
     * @param values 值 可以是多个 
     * @return 移除的个数 
     */  
    public long setRemove(String key, Object ...values) {  
        try {  
            Long count = template.opsForSet().remove(key, values);  
            return count;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  
    //===============================list=================================  

    /** 
     * 获取list缓存的内容 
     * @param key 键 
     * @param start 开始 
     * @param end 结束  0 到 -1代表所有值 
     * @return 
     */  
    public List<Object> lGet(String key,long start, long end){  
        try {  
            return template.opsForList().range(key, start, end);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 获取list缓存的长度 
     * @param key 键 
     * @return 
     */  
    public long lGetListSize(String key){  
        try {  
            return template.opsForList().size(key);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  

    /** 
     * 通过索引 获取list中的值 
     * @param key 键 
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推 
     * @return 
     */  
    public Object lGetIndex(String key,long index){  
        try {  
            return template.opsForList().index(key, index);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, Object value) {  
        try {  
            template.opsForList().rightPush(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, Object value, long time) {  
        try {  
            template.opsForList().rightPush(key, value);  
            if (time > 0) expire(key, time);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, List<Object> value) {  
        try {  
            template.opsForList().rightPushAll(key, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 将list放入缓存 
     * @param key 键 
     * @param value 值 
     * @param time 时间(秒) 
     * @return 
     */  
    public boolean lSet(String key, List<Object> value, long time) {  
        try {  
            template.opsForList().rightPushAll(key, value);  
            if (time > 0) expire(key, time);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }  

    /** 
     * 根据索引修改list中的某条数据 
     * @param key 键 
     * @param index 索引 
     * @param value 值 
     * @return 
     */  
    public boolean lUpdateIndex(String key, long index,Object value) {  
        try {  
            template.opsForList().set(key, index, value);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }   

    /** 
     * 移除N个值为value  
     * @param key 键 
     * @param count 移除多少个 
     * @param value 值 
     * @return 移除的个数 
     */  
    public long lRemove(String key,long count,Object value) {  
        try {  
            Long remove = template.opsForList().remove(key, count, value);  
            return remove;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return 0;  
        }  
    }  
	
}
