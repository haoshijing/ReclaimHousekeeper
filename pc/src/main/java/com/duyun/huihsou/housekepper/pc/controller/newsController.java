package com.duyun.huihsou.housekepper.pc.controller;


import com.alibaba.fastjson.JSON;
import com.duyun.huihsou.housekepper.pc.service.news.NewsService;
import com.duyun.huihsou.housekepper.pc.tool.HTMLSpirit;
import com.duyun.huihsou.housekepper.pc.tool.TimeTool;
import com.duyun.huishou.housekeeper.ApiResponse;
import com.duyun.huishou.housekeeper.constants.RetCode;
import com.duyun.huishou.housekeeper.po.NewsEntity;
import com.duyun.huishou.housekeeper.po.news.newSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pc/portal/news")
public class newsController {


    @Autowired
    private NewsService newsService;



    @RequestMapping(value = "/getNewShowlist", method = RequestMethod.GET)
    public Object getNewShowlist(Integer start,Integer newsPageSize,Integer cutoutLength) {
        try {
            Map map = new HashMap();
            map.put("start", start <= 0 ? 0 : start);
            map.put("size", newsPageSize < 0 ? 10 : newsPageSize);
            List<newSummary> newLitem=newsService.getNewsprofile(map);
            int size = newLitem.size();
            for(int i=0;i<size;i++){
                //截取字符串
                newLitem.get(i).setContent(HTMLSpirit.delHTMLTag(newLitem.get(i).getContent(),cutoutLength));
            }
            //获取所有的页面
            Integer pageNumber= newsService.getCountNews();
            HashMap reMap=new HashMap();
            // 页数
            reMap.put("PageNumber",pageNumber%newsPageSize>0?pageNumber/newsPageSize +1 :pageNumber/newsPageSize);
            reMap.put("list",newLitem);
            return JSON.toJSON(new  ApiResponse(reMap));
        }
        catch(Exception e) {
            System.out.println("异常信息为："+e.getMessage());
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/getOneNewPage", method = RequestMethod.GET)
    public Object getNewShowlist(Integer pageid) {
        try {

           return JSON.toJSON(new ApiResponse(RetCode.OK,"请求数据成功",newsService.selectByPrimaryKey(pageid)));
        }catch (Exception e){
            System.out.println("异常");
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND,"请求失败或没有数据"));
        }
    }

    @RequestMapping(value = "/insertOneNewPage", method = RequestMethod.POST)
    public Object insertOneNewPage(
            Integer id,
            String title,
            String content,
            Byte isTop,
            long insertTime) throws ParseException {
        try {

            if (newsService.insertOneNewPage(new NewsEntity(id, title, content, isTop, insertTime, insertTime)) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "插入数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求插入数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "POSt请求数据格式错误"));
        }
    }

    @RequestMapping(value = "/StickNewsPage", method = RequestMethod.GET)
    public Object StickNewsPage(Integer pageid){
        try {
            Map map = new HashMap();
            map.put("id", pageid);
            if (newsService.StickNewsPage(map) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "置顶数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "数据置顶失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求数据格式错误"));
        }
    }

    @RequestMapping(value = "/updateNewsPage", method = RequestMethod.POST)
    public Object updateNewsPage(Integer id,String title,String content,Byte isTop,Long lastUpdateTime){
        try {
            if (newsService.insertOneNewPage(new NewsEntity(id, title, content, isTop, lastUpdateTime)) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "更新数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "更新数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "POSt请求数据格式错误"));
        }
    }

    @RequestMapping(value = "/deleteNewsPage", method = RequestMethod.GET)
    public Object deleteNewsPage(Integer pageid){
        try {
            if (newsService.deleteNewsByPageId(pageid) == 1) {
                return JSON.toJSON(new ApiResponse(RetCode.OK, "删除数据成功"));
            } else {
                return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "删除数据失败"));
            }
        } catch (Exception e){
            return JSON.toJSON(new ApiResponse(RetCode.NOT_FOUND, "请求数据格式错误"));
        }
    }
}
