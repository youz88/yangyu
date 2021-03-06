# -*- coding: utf-8 -*-
import string
import urllib
import urllib2

import re

import sys

import time


class News:
    def __init__(self,baseUrl,newsType=None,pageNo=1):
        self.baseUrl = baseUrl
        self.newsType = newsType
        self.pageNo = pageNo

    def getListByPage(self,pageNo):
        list_url = '/action/ajax/get_more_news_list'
        headers = {
            'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36'
        }
        parms = {
            'newsType':self.newsType,
            'p':pageNo
        }
        url = self.baseUrl + list_url + '?' + urllib.urlencode(parms)
        request = urllib2.Request(url,headers=headers)
        try:
            response = urllib2.urlopen(request)
            return response.read()
        except urllib2.HTTPError, e:
            if hasattr(e,'reason'):
                print u'连接失败,错误原因',e.reason
                return None

    def getContent(self,page):
        pattern = re.compile(r'class="text-ellipsis">(.*?)</span>.*?summary">(.*?)</div>.*?"from">.*?<a.*?<img src="(.*?)".*?<span class="mr"><a.*?>(.*?)</a>.*?发布于(.*?)</span>.*?<a href="(.*?)"',re.S)
        items = re.findall(pattern,page)
        contents = []
        for item in items:
            contentPart = item[1]
            if len(contentPart) > 250:
                contentPart = str(contentPart).decode("utf-8")[:250].encode("utf-8") + '...'
            href = item[5]
            if str(href).startswith("/"):
                href = "https://www.oschina.net" + href
            #拼接json字符串
            contents.append('{"title":"'+item[0]+'","contentPart":"'+contentPart+'","avatar":"'+item[2]+
                            '","author":"'+item[3]+'","publishDate":"'+str(item[4]).strip()+'","href":"'+href+'"}')
        return contents

    def start(self):
        page = self.getListByPage(self.pageNo)
        content = self.getContent(page)
        for c in content:
            print c


baseUrl = 'https://www.oschina.net'
osc = News(baseUrl=baseUrl,pageNo=sys.argv[1])
# osc = News(baseUrl=baseUrl,pageNo=1)
osc.start()
