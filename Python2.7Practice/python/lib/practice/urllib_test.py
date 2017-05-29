#!/usr/bin/python
# coding: utf-8
'''
@description: 
@date: Created on 2017年4月19日
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''

import urllib2
import urllib

# 不用代理
urllib
html = urllib.urlopen("http://www.baidu.com")
print(html.read())

# 全局代理
proxy_handler = urllib2.ProxyHandler({'http': 'web-proxy.atl.hp.com:8080'})
opener = urllib2.build_opener(proxy_handler)
urllib2.install_opener(opener)
f = urllib2.urlopen('http://www.google.com')
print f.read()

# 非全局代理
proxy_handler = urllib2.ProxyHandler({'http': 'web-proxy.atl.hp.com:8080'})
opener = urllib2.build_opener(proxy_handler)
f = opener.open("http://www.google.com")
print f.read()
