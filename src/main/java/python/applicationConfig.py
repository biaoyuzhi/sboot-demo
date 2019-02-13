#!/usr/bin/env python 
# -*- coding:utf-8 -*-
# @Author: wuzh
# @time  : 2019/2/1

import os
import yaml
import codecs


def _get_yaml(arg):
    """
    解析yaml
    :return: s  字典
    """
    path = os.path.join(os.path.dirname(__file__) + '/'+arg+'.yaml')
    f = codecs.open(path, encoding='utf-8')
    s = yaml.load(f)
    f.close()
    return s

