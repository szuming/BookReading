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
