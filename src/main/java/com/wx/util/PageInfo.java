package com.wx.util;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * Created by wx
 * 2018/10/8
 */
@Data
public class PageInfo {

    private Integer page=1;

    private Integer size=10;

    private String prop;

    private String order;

    public PageRequest getPageRequest(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return PageRequest.of(page-1, size, sort);
    }

    public PageRequest getPageRequestWithSort(){
        if(getSort() == null){
            return getPageRequest();
        }else{
            return PageRequest.of(page-1, size,getSort());
        }

    }

    public Sort getSort(){
        Sort sort = null;
        if(StringUtils.isEmpty(prop)){
            return sort;
        }
        if(order.startsWith("asc")){
            sort = new Sort(Sort.Direction.ASC, prop);
        }else{
            sort = new Sort(Sort.Direction.DESC, prop);
        }
        return sort;

    }
}
