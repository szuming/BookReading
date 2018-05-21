# Redis开发与运维

## 第一章--初识Redis
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p2|Redis特性|[null](https://www.baidu.com)|
|p5|Redis经典使用场景|[null](https://www.baidu.com)|根本是对热数据的内存处理
|p7|Redis的安装|[安装博客](https://i.cnblogs.com/EditPosts.aspx?postid=9050938)|源码安装


## 第二章--API的理解和使用
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p18|数据结构和内部编码|[null](https://www.baidu.com)|外部提供了5中数据结构，但内部每种结构都有不同的实现，用于不同场景
|p19|单线程架构|[null](https://www.baidu.com)|单线程架构与IO多路复用模型实现高性能
|p24|get与mget比较|[null](https://www.baidu.com)|若要执行多次get操作应使用get方法来减少网络请求次数
|p25|CAS机制|[CAS参考博客](https://www.cnblogs.com/myopensource/p/8177074.html)|redis不需使用CAS机制实现计数功能，降低了CPU消耗
|p28|String典型场景|[null](https://www.baidu.com)|缓存功能；计数；共享session；限速
|p35|Hash内部编码|[null](https://www.baidu.com)|当field个数小于512（默认）且所有value都小于64字节时使用ziplist
|p37|Hash典型场景|[null](https://www.baidu.com)|用于存储对象如user(相比于使用String存储多个键与使用String存储序列化的对象)
|p43|List内部编码|[quickList](https://matt.sh/redis-quicklist)|与Hash相似，数据较小时使用ziplist;数据大时使用linkedlist;3.2版本后使用quicklist
|p44|List典型场景|[null](https://www.baidu.com)|list可实现Stack,Queue,Capped Collection,Message Queue;常用于消息队列与文章列表
|p50|Set内部编码|[null](https://www.baidu.com)|当元素全是int并且个数少于512（默认）时用intset实现，否则用hashtable
|p51|Set典型场景|[null](https://www.baidu.com)|标签，生成随机数，社交需求；使用set的交并集操作得到相同兴趣爱好，
|p53|list,set,zset对比|[null](https://www.baidu.com)|
|p59|zset内部编码|[null](https://www.baidu.com)|当元素个数小于128（默认）且每个元素大小小于64字节（默认）使用ziplist;否则使用skiplist
|p60|Zset典型场景|[null](https://www.baidu.com)|排行榜系统
|p64|迁移键|[null](https://www.baidu.com)|推荐使用migrate,其具有原子性与支持批量操作
|p68|遍历键|[null](https://www.baidu.com)|keys可遍历所有键但会因键的数量导致阻塞，因此推荐使用scan
|p72|多数据库|[null](https://www.baidu.com)|因为Redis是单进程所以该功能逐渐被抛弃，若需要可通过一台服务器配置多个redis实例（以端口区分）实现

## 第三章--小功能大用处
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p75|慢查询分析|[null](https://www.baidu.com)|记录命令的实际执行时间，用于性能分析
|p86|Pipeline优化RTT|[null](https://www.baidu.com)|与mget等批量操作命令相似，都是为了减少命令网络传输时间，但mget是一条命令，Pipeline将多条命令组成命令块发给redis服务端
|p88|redis事务|[null](https://www.baidu.com)|redis事务未提供回滚功能且不支持命令之间的逻辑关系计算
|p88|redis使用Lua脚本|[null](https://www.baidu.com)|Lua脚本在redis中是原子执行的，且可以定制自己的命令存储在redis供多次调用，还可以减少网络开销
|p100|使用Bitmaps计算用户访问量|[null](https://www.baidu.com)|Bitmaps实际上是字符串，但是可以对其进行位操作
|p109|redis发布订阅的使用场景|[null](https://www.baidu.com)|聊天室，公告牌，服务
|p110|GEO使用场景|[null](https://www.baidu.com)|附近位置，摇一摇


## 第四章--客户端
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p114|redis通信协议RESP|[redis各语言客户端实现](http://redis.io/clients)|按格式与reids服务器交互
|p123|jedis直连与线程池比较|[null](https://www.baidu.com)|直连简单用于长期连接，连接池管理与保护连接，无需新生连接
|p134|redis输入缓冲区异常处理|[null](https://www.baidu.com)|client list精确定位异常的连接；info clients找出最大的输入缓冲区
|p137|redis输出缓冲区的预防|[null](https://www.baidu.com)|
|p147|客户端常见异常|[null](https://www.baidu.com)|无法获取连接，读写超时，连接超时，客户端缓冲区异常等


## 第五章--持久化
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p155|RDB持久化|[LZF算法进行压缩](https://blog.csdn.net/zhanfu2905/article/details/68947902)|使用bgsave执行，父进程会fork子进程来执行RDB
|p157|RDB优缺点分析|[null](https://www.baidu.com)|二进制文件适用于备份与全量复制，加载恢复速度快于AOF；因为fork无法实时备份，兼容问题
|p158|AOF持久化|[null](https://www.baidu.com)|将每个命令写入日记中，重启时再重新执行AOF文件中的命令来达到目的


## 第六章--复制
|  #  |      Title     |   src   |  重点                
|-----|----------------|---------------|-------------
|p171|一主一从|[null](https://www.baidu.com)|当并发量高且需要持久化时可通过在从节点开启AOP来保证性能跟数据持久化
|p172|一主多从|[null](https://www.baidu.com)|可实现读写分离，当读占比较大资源时交给从节点去完成读动作，但写命令会让主节点给多个从节点发送命令消耗网络
|p172|树状主从|[null](https://www.baidu.com)|从节点可以作为主节点给根主节点分担负载压力
|p173|复制过程|[null](https://www.baidu.com)|1.保存主节点的信息2.建立socket连接3.发送ping4.密码验证5.同步数据集6.命令持续发送 
|p177|数据同步|[null](https://www.baidu.com)|通过主从各自复制偏移量，复制积压缓存区，主节点运行id实现
|p178|全量复制|[null](https://www.baidu.com)|从节点发送psync命令，主节点执行bgsave，产生的RDB文件发送给从节点
|p181|部分复制|[null](https://www.baidu.com)|若因网络或被切断电源等原因主从节点失去连接，从节点可要求主节点补发部分缺失数据（通过复制偏移量计算这部分数据）
|p183|心跳|[null](https://www.baidu.com)|为了维护长连接而发送心跳命令，主节点默认每隔10秒对从节点发送ping，从节点每秒都会发送replconf来上报自身复制偏移量
|p184|异步复制|[null](https://www.baidu.com)|主节点执行完客户端的命令会立刻返回结果给客户端，并不等待子节点完成复制，所以复制过程是异步的
|p184|主从读写分离|[null](https://www.baidu.com)|只需向主节点写命令，从节点复杂读取数据返还给主节点


## 第七章--阻塞
|  #  |      Title     |   src   |  重点     
|-----|----------------|---------------|-------------
|p189|发现阻塞|[null](https://www.baidu.com)|利用log4j日志系统统计异常信息，通过发邮件/短信/微信报警

          






### 模仿jedis




