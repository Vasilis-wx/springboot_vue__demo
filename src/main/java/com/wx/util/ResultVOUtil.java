package com.wx.util;

import com.wx.VO.ResultVO;

import java.util.Map;

/**
 * Created by wx
 * 2018/8/17
 */
public class ResultVOUtil {

    public static ResultVO succsee(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return  resultVO;
    }

    public static ResultVO successMap(Map<String,Object> map){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(map);
        return  resultVO;
    }

    public static ResultVO success(){
        return succsee(null);
    }

    public static ResultVO error(int code,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return  resultVO;
    }
}
