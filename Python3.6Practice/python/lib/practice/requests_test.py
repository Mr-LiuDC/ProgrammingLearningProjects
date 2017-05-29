#!/usr/bin/python
# coding: utf-8
'''
@description: 
@date: Created on 2017年4月24日
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''

import requests
my_proxy = {
    'http': 'http://web-proxy.usa.hp.com:8080',
    'https': 'http://web-proxy.usa.hp.com:8080'
}
# html = requests.get('http://www.jianshu.com/', proxies=my_proxy)
# print(html.text)

# proxy = requests.get('http://api.xicidaili.com/free2016.txt', proxies=my_proxy)
# print(proxy.text)


# 网上的代理地址http://www.freeproxylists.net/zh 似乎不能用
web_proxy = {'https':'144.217.189.250:8799'}
baidu = requests.get('http://www.baidu.com', proxies=web_proxy)
print(baidu.text)


