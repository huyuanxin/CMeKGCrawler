# 关于本项目（更新于2023/1/5）

近短时间，不知道出于什么原因，本项目的star开始增加，问题也随之而来，因此更新一份说明：
* CMeKg项目的网站已经无法访问，由于本项目的代码是爬虫代码，因此代码已经失效了。
* 基于第一点，目前本项目只有数据库文件能使用了，没有必要将项目运行起来。
* 本人基于此爬虫的项目只是本科的毕业设计，并没有高深的算法在里面，因此直接下载数据库使用即可。
* 最后，感谢大家对项目的认可。

# Describe

The project includes 140000 entities and nearly 700000 relationships

## Relationship

[DISEASE](./doc/疾病.md)

[SYMPTOM](./doc/症状.md)

[DRUG](./doc/药物.md)

[TREATMENT](./doc/诊疗.md)

# Quick Start

## Dependencies

* Java 8 and up
* Maven 3.6.3 and up
* Neo4j
* IDEA

## How To Start

### DownLoad Source Code

```shell
git clone https://gitee.com/huyuanxin/CMeKGCrawler
git clone https://github.com/huyuanxin/CMeKGCrawler
```

### Import Code To IDEA

### Configuration Database Information

```properties
#neo4j
spring.data.neo4j.uri=bolt://ip:port
spring.data.neo4j.username=username
spring.data.neo4j.password=password
```

### Run Application

* Run KnowledgeCrawlerApplication.java.java

# References

If you used Knowledge Crawler in your research, please quote it in the following format:

```
@Software{CollegeCrawler,
  author = {huyuanxin,luhaoyi,zhangtingting},
  title = {{CMeKGCrawler: CMeKGCrawler}},
  year = {2021},
  url = {https://github.com/huyuanxin/CMeKGCrawler},
}
```

# Disclaimers

Please do not apply Knowledge Crawler to any work that may violate the legal provisions and moral constraints. Please use
Knowledge Crawler friendly, abide by the spider agreement, and do not use Knowledge Crawler for any illegal purpose. If you
choose to use Knowledge Crawler, you will abide by this agreement. The author will not bear any legal risks and losses
caused by your violation of this agreement, and all consequences will be borne by you.

# Database
> 如果不想自己进行爬取,可以自行在此下载 <br>
> 项目：https://github.com/huyuanxin/MKGS <br>
> 链接：https://pan.baidu.com/s/1I9GG4zD2rULAKA6Mb365LQ 
> 提取码：MKGS <br>
> 适配Neo4j v5.2&Neo4j v4.4<br>
> 链接: https://pan.baidu.com/s/1UPtlNCEtH2P05LgG1veFEw
> 提取码: MKGS
