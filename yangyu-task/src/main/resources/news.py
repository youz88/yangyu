# -*- coding: utf-8 -*-
import urllib
import urllib2

import re

import sys


class News:
    def __init__(self,url,newsType=None,pageNo=1):
        self.url = url
        self.newsType = newsType
        self.pageNo = pageNo

    def getContentByPage(self,pageNo):
        headers = {
            'user-agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36'
        }
        parms = {
            'newsType':self.newsType,
            'p':pageNo
        }
        url = self.url + '?' + urllib.urlencode(parms)
        request = urllib2.Request(url,headers=headers)
        try:
            response = urllib2.urlopen(request)
            return response.read()
        except urllib2.HTTPError, e:
            if hasattr(e,'reason'):
                print u'连接失败,错误原因',e.reason
                return None

    def getContent(self,page):

        p = re.compile(r'class="text-ellipsis">(.*?)</span>.*?summary">(.*?)</div>.*?<span class="mr"><a.*?>(.*?)</a>(.*?)</span>',re.S)
        items = re.findall(p,page)
        contents = []
        for item in items:
            print 'title:',item[0],'\ncontent:',item[1],'\nauthor:',item[2],'\ndate:',item[3],'\n---------------------\n',

    def start(self):
        page = self.getContentByPage(self.pageNo)
        content = self.getContent(page)

url = 'https://www.oschina.net/action/ajax/get_more_news_list'
jrtt = News(url=url,pageNo=sys.argv[1])
jrtt.start()
