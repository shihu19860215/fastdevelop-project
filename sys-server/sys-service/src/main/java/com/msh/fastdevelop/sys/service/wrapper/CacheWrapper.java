package com.msh.fastdevelop.sys.service.wrapper;

import com.msh.fastdevelop.sys.client.po.AuthorityUrlPO;
import com.msh.fastdevelop.sys.client.po.ColumnDictPO;
import com.msh.fastdevelop.sys.client.qo.AuthorityUrlQO;
import com.msh.fastdevelop.sys.client.qo.ColumnDictQO;
import com.msh.fastdevelop.sys.service.service.AuthorityUrlService;
import com.msh.fastdevelop.sys.service.service.ColumnDictService;
import com.msh.frame.common.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CacheWrapper {
    @Autowired
    private AuthorityUrlService authorityUrlService;
    @Autowired
    private ColumnDictService collumnDictService;


    private volatile Map<String, Integer> urlAuthIdMap;
    private Object urlAuthIdMapLock = new Object();
    private Map<String, Map<String, List<ColumnDictPO>>> dictMap;
    private Object dictMapLock = new Object();


    public Map<String, Integer> getUrlAuthIdMap(){
        if(null == urlAuthIdMap){
            synchronized (urlAuthIdMapLock){
                if(null == urlAuthIdMap){
                    List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(new AuthorityUrlQO()).getResult();
                    if(null == authorityUrlPOList){
                        urlAuthIdMap = CollectionUtils.EMPTY_MAP;
                    }else {
                        Map<String, Integer> map = new HashMap<>(authorityUrlPOList.size()*2);
                        for(AuthorityUrlPO authorityUrlPO: authorityUrlPOList){
                            map.put(authorityUrlPO.getUrl(),authorityUrlPO.getLinkAuth());
                        }
                        urlAuthIdMap = map;
                    }
                }
            }
        }
        return urlAuthIdMap;
    }
    public void clearUrlAuthIdMap(){
        urlAuthIdMap = null;
    }

    public List<ColumnDictPO> getDictList(String tableName, String columnName) {
        if(null == dictMap){
            synchronized (dictMapLock){
                if(null == dictMap){
                    List<ColumnDictPO> columnDictPOList = collumnDictService.list(new ColumnDictQO()).getResult();
                    if(null == columnDictPOList){
                        dictMap = CollectionUtils.EMPTY_MAP;
                    }else {
                        Map<String, Map<String, List<ColumnDictPO>>> map = new HashMap<>();
                        for(ColumnDictPO collumnDictPO: columnDictPOList){
                            Map<String, List<ColumnDictPO>> map2 = map.get(collumnDictPO.getTableName());
                            if(null == map2){
                                map2 = new HashMap<>();
                                map.put(collumnDictPO.getTableName(), map2);
                            }
                            List<ColumnDictPO> list = map2.get(collumnDictPO.getColumnName());
                            if(null == list){
                                list = new LinkedList<>();
                                map2.put(collumnDictPO.getColumnName(), list);
                            }
                            list.add(collumnDictPO);
                        }
                        dictMap = map;
                    }
                }
            }
        }
        List<ColumnDictPO> columnDictPOList = null;
        Map<String, List<ColumnDictPO>> map1 = dictMap.get(tableName);
        if(null != map1){
            columnDictPOList = map1.get(columnName);
        }
        if(null == columnDictPOList){
            columnDictPOList = CollectionUtils.EMPTY_LIST;
        }

        return columnDictPOList;
    }

    public void clearDictMap(){
        dictMap = null;
    }

    public void clearAllCache() {
        urlAuthIdMap = null;
        dictMap = null;
    }
}
