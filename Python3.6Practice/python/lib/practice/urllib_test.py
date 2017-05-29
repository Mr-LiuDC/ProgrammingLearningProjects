#!/usr/bin/python
# coding: utf-8
'''
@description: 
@date: Created on 2017年4月18日
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''
import urllib.request
# from urllib import request
# import urllib
# 
proxy_support = urllib.request.ProxyHandler({"http" : "http://web-proxy.atl.hp.com:8080"})
opener = urllib.request.build_opener(proxy_support)
urllib.request.install_opener(opener)
html = urllib.request.urlopen("http://www.google.com")
print (html.read())





# import urllib.request
# 
# # set up authentication info
# authinfo = urllib.request.HTTPBasicAuthHandler()
# authinfo.add_password(realm='PDQ Application',
#                       uri='https://mahler:8092/site-updates.py',
#                       user='klem',
#                       passwd='geheim$parole')
# 
# proxy_support = urllib.request.ProxyHandler({"http" : "http://ahad-haam:3128"})
# 
# # build a new opener that adds authentication and caching FTP handlers
# opener = urllib.request.build_opener(proxy_support, authinfo,
#                                      urllib.request.CacheFTPHandler)
# 
# # install it
# urllib.request.install_opener(opener)
# 
# f = urllib.request.urlopen('http://www.python.org/')
