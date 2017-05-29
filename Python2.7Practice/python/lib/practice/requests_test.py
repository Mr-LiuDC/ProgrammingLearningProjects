#!/usr/bin/python
# coding: UTF-8
'''
@description: 
@date: Created on 2017年4月22日 下午9:02:31
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''
import requests
# r = requests.get('https://api.github.com/user', auth=('user', 'pass'))
# r = requests.get('https://api.github.com/user', auth=('442823529@qq.com', '442823529@qq.com'))
# print r.status_code
# print r.headers['content-type']
# print r.encoding
# print r.text
# print r.json()


html = requests.get("https://www.baidu.com")
print html.text

