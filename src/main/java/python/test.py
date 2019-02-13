#!/usr/bin/env python 
# -*- coding:utf-8 -*-
# @Author: wuzh
# @time  : 2018/12/7
import hashlib
from functools import reduce
from linkDataBase import LinkDataBase


# ---------------------------------------------------------------------------
# 连接数据库操作
obj = LinkDataBase().get_data('1')
print(obj)
# ---------------------------------------------------------------------------
# 一些内置高阶函数的测试:map,reduce,filter,sorted
def f_m(x):
    return x * x
def f_r(x, y):
    return x + y
def f_f(x):
    return x % 2 == 0
def f_a(x, y, fun):
    return fun(x)+fun(y)

print(list(map(f_m, [1, 2, 3, 4])))
print(reduce(f_r, [1, 2, 3, 4]))
print(list(filter(f_f, [1, 2, 3, 4])))
print(f_a(-1, 3, abs))
print(sorted(['bob', 'about', 'Zoo', 'Credit'], key=lambda x: x.lower()))
# ---------------------------------------------------------------------------
# 闭包问题的测试
def count():
    fs = []
    for i in range(1, 4):
        def f(x=i):  # 解决闭包问题的关键
            return x*x
        fs.append(f)
    return fs

f1, f2, f3 = count()
print(f1(), f2(), f3())
# ---------------------------------------------------------------------------
# 判空和空白字符:None,'','  '
a = filter(lambda s: s and len(s.strip()) > 0, ['test', None, '', 'str', '  ', ' ', 'END'])
print(list(a))
# ---------------------------------------------------------------------------
# 装饰器的测试
def log(f):
    def fn(*args, **kwargs):
        print('打印日志，接收到的参数为：', args)
        return f(*args, **kwargs)
    return fn

@log
def add(x, y):
    return x + y
print(add(5, 6))

# ---------------------------------------------------------------------------
# md5加密，加密后为32字节
arg = '123'+'salt'
m = hashlib.md5(bytes(arg, 'utf-8')).hexdigest()
print('md5加密后：' + m)