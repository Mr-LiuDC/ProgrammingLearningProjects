#!/usr/bin/python
# coding: UTF-8
'''
@description: 
@date: Created on 2017年4月21日 下午10:38:30
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''
# 求和

# 提示输入数字

# num1 = input("输入第一个数：")

# num2 = input("输入第二个数：")

# # 计算

# result = float(num1)+float(num2)

# # 显示结果

# print("数字{0}和{1}相加结果为：{2}".format(num1,num2,result))


# 或者采用如下方式，合并为一行代码

print('两数之和为%.1f' % (float(input('输入第一个数：')) + float(input('输入第二个数：'))))
# notes：内置函数 input() 来获取用户的输入，input() 返回一个字符串，所以我们需要使用 float() 方法将字符串转换为数字。
