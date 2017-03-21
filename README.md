# SimpleES
note:
<br>
-->model:
仿照倒排索引,以id维度关联起book对象的属性(bookbook,bookPress等)
-->dataDump:
查询mysql表中的数据，生成各个model;
-->dataProcess:
dump得到的数据是一个包含book对象各个属性的model的一个list;
第一个process将这个list进行按id进行组装;
即:
原始list:
[id0,bookbook],[id1,bookbookPress],[id1,bookbook],[id0,bookPress]...
第一次process后list:
[id0,[bookbook,bookPress]],[id1,[bookbook,bookPress]]...;
第二个process将通过这个list生成最终需要建索引document对象,这里其实就是book对象:
这里简单的将类目,出版社信息读到内存中作为缓存(这里缓存内存还是其他缓存服务比如redis可调整),book对象在此process中根据类目id,出版社id设置类目,出版社;
即:
原始list:
[id0,[bookbook,bookPress]],[id1,[bookbook,bookPress]]...;
第二次process后list:
[id0,pressId,pressName,categoryId,categoryName,...]...
-->dataIndex:
将process生成的list<Book>转换为json,发送到ElasticSearch集群建立索引;
此时如果安装了ES插件，可直接在插件的“基本查询”中进行相关查询(未安装也可以,只是不直观,可通过CURL工具发送http请求进行查询,需要了解一下ElasticSearch REST API);
-->dataSearch:
聚合：包含类目聚类，出版社聚类，价格聚类等
搜索：包含关键词搜索，类目搜索，价格搜索等
排序：包含默认排序(score)，销量排序，价格排序等


