#!/usr/bin/env python 
# -*- coding:utf-8 -*-
# @Author: wuzh
# @time  : 2018/12/3
import pymysql
from applicationConfig import _get_yaml


class LinkDataBase(object):
    def __init__(self, arg="application"):
        self.con = pymysql.connect(host=_get_yaml(arg)["dataBase"]["host"],
                                   user=_get_yaml(arg)["dataBase"]["user"],
                                   password=_get_yaml(arg)["dataBase"]["password"],
                                   db=_get_yaml(arg)["dataBase"]["db"],
                                   port=_get_yaml(arg)["dataBase"]["port"],
                                   charset=_get_yaml(arg)["dataBase"]["charset"])
        self.cur = self.con.cursor()

    def get_data(self, ids):
        self.cur.execute('select * from person where id = "%s"' % ids)  # 变量的传值使用单独的引号引起来，避免了查询语句的报错，同时解决了SQL注入的情况
        obj = self.cur.fetchall()
        self.con.close()
        return obj

    def up_data(self, ids):
        sql_update = 'update person set name = "%s", password = "%s" where id = "%s"'
        self.cur.execute(sql_update % ('wuzh', '中文也可以', ids))
        self.con.commit()
        self.con.close()

    def insert_data(self):
        sql = 'insert into person(name, password) values ("%s","%s")'
        self.cur.execute(sql % ('wuzh', '中文也可以'))
        self.con.commit()
        self.con.close()

    def delete_data(self, ids):
        sql = 'delete from person where id = "%s"'
        self.cur.execute(sql % ids)
        self.con.commit()
        self.con.close()
