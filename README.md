# SimpleES
note:
-->model:
���յ�������,��idά�ȹ�����book���������(bookbook,bookPress��)
-->dataDump:
��ѯmysql���е����ݣ����ɸ���model;
-->dataProcess:
dump�õ���������һ������book����������Ե�model��һ��list;
��һ��process�����list���а�id������װ;
��:
ԭʼlist:
[id0,bookbook],[id1,bookbookPress],[id1,bookbook],[id0,bookPress]...
��һ��process��list:
[id0,[bookbook,bookPress]],[id1,[bookbook,bookPress]]...;
�ڶ���process��ͨ�����list����������Ҫ������document����,������ʵ����book����:
����򵥵Ľ���Ŀ,��������Ϣ�����ڴ�����Ϊ����(���ﻺ���ڴ滹����������������redis�ɵ���),book�����ڴ�process�и�����Ŀid,������id������Ŀ,������;
��:
ԭʼlist:
[id0,[bookbook,bookPress]],[id1,[bookbook,bookPress]]...;
�ڶ���process��list:
[id0,pressId,pressName,categoryId,categoryName,...]...
-->dataIndex:
��process���ɵ�list<Book>ת��Ϊjson,���͵�ElasticSearch��Ⱥ��������;
��ʱ�����װ��ES�������ֱ���ڲ���ġ�������ѯ���н�����ز�ѯ(δ��װҲ����,ֻ�ǲ�ֱ��,��ͨ��CURL���߷���http������в�ѯ,��Ҫ�˽�һ��ElasticSearch REST API);
-->dataSearch:
�ۺϣ�������Ŀ���࣬��������࣬�۸�����
�����������ؼ�����������Ŀ�������۸�������
���򣺰���Ĭ������(score)���������򣬼۸������


