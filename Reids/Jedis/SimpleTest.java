package Reids.Jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.nio.channels.Pipe;

public class SimpleTest {
    private Jedis jedis=null;
    private final int port=6379;
    private final String host="127.0.0.1";
    public void basicTest(){
        try{
            jedis=new Jedis(host,port);
            //String
            jedis.set("hello","world");
            System.out.println(jedis.get("hello"));
            //hash
            jedis.hset("myhash","f1","v1");
            jedis.hset("myhash","f2","v2");
            System.out.println(jedis.hgetAll("myhash"));
            //list
            jedis.rpush("mylist","1");
            jedis.rpush("mylist","2");
            System.out.println(jedis.lrange("mylist",0,-1));
            //set
            jedis.sadd("myset","a");
            jedis.sadd("myset","b");
            System.out.println(jedis.smembers("myset"));
            //zset
            jedis.zadd("myzset",99,"tom");
            jedis.zadd("myzset",100,"ming");
            System.out.println(jedis.zrangeByScore("myzset",0,100));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public void serializerTest(){

    }

    public void poolTest(){
        //默认配置
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        JedisPool jedisPool=new JedisPool(poolConfig,"127.0.0.1",6379);
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            System.out.println(jedis.get("hello"));
            Pipeline pipeline=jedis.pipelined();
            pipeline.del("hello");
            pipeline.del("1");
            pipeline.sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();          //使用了jedisPool后close代表归还连接池
        }
    }

    public void LuaTest(){
        //默认配置
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        JedisPool jedisPool=new JedisPool(poolConfig,"127.0.0.1",6379);
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            String key="hello";
            String script="return redis.call('get',KEYS[1])";
            Object result=jedis.eval(script,1,key);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();          //使用了jedisPool后close代表归还连接池
        }
    }


    public static  void main(String[] argv){
        SimpleTest simpleTest=new SimpleTest();
        simpleTest.basicTest();
        simpleTest.LuaTest();
        simpleTest.poolTest();
    }
}
