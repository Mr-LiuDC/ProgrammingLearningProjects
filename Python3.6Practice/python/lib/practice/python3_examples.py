#!/usr/bin/python
# coding: utf-8
'''
@description: 
@date: Created on 2017年4月21日
@author: Mr.LiuDC
@email: 1911939348@qq.com
'''

# 输出Hello World
# print("Hello World. 刘德财")



# 求和
# 提示输入数字
# num1 = input("输入第一个数：")
# num2 = input("输入第二个数：")
# # 计算
# result = float(num1)+float(num2)
# # 显示结果
# print("数字{0}和{1}相加结果为：{2}".format(num1,num2,result))

# 或者采用如下方式，合并为一行代码
# print('两数之和为%.1f' % (float(input('输入第一个数：')) + float(input('输入第二个数：'))))
# notes：内置函数 input() 来获取用户的输入，input() 返回一个字符串，所以我们需要使用 float() 方法将字符串转换为数字。



# 九九乘法表
# for i in range(1, 10):
#     for j in range(1, i + 1):
#         print('{1}x{0}={2}\t'.format(i, j, i * j), end='')      # 占位符{}如果没标号默认从左到右的顺序填充，end=''表示不换行。
#     print()
    


# 最大公约数
# def hcf(x, y):
#     """返回两个数的最大公约数"""
#     if x > y:
#         smaller = y
#     else:
#         smaller = x
#     for i in range(1, smaller + 1):
#         if((x % i == 0) and (y % i == 0)):
#             hcf = i
#     return hcf
# num1 = int(input('输入第一个数：'))
# num2 = int(input('输入第二个数：'))
# print(num1, '和', num2, '的最大公约数为：', hcf(num1, num2))

# 最小公倍数
# def lcm(x, y):
#     if x > y:
#         greater = x
#     else:
#         greater = y
#     while(True):
#         if((greater % x == 0) and (greater % y == 0)):
#             lcm = greater
#             break
#         greater += 1
#     return lcm
# num1 = int(input('输入第一个数：'))
# num2 = int(input('输入第二个数：'))
# print(num1, '和', num2, '的最小公倍数为：', lcm(num1, num2))



# 输出日历
# import calendar
# yy = int(input("输入年份: "))
# mm = int(input("输入月份: "))
# print(calendar.month(yy, mm))



# 文件操作包括 open，read，write
# 写文件
# with open('test.txt', 'wt') as out_file:
#     out_file.write('该文本会写入文件中。\n看到了吧！')

# 读文件
# with open('test.txt', 'rt') as in_file:
#     text = in_file.read()
# print(text)






