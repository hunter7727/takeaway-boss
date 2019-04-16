package com.pmdiss.convertor;

import com.ajy.core.common.enums.ResponseCode;
import com.ajy.core.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author wenqiang
 *
 * 通用转换类
 */
@Slf4j
public class CommonConvertor {

    /**
     * @author qiang.wen
     * @param po
     * @param vo
     * @param <P>
     * @param <V>
     * @return
     * po转换为vo
     */
    public static <P,V> V convertPo2Vo(P po, V vo){
        if(po == null || vo == null){
            throw new ApiException(ResponseCode.ILLEGAL_PARAM.getCode(),ResponseCode.ILLEGAL_PARAM.getMsg());
        }
        try {
            BeanUtils.copyProperties(vo,po);
        } catch (Exception e) {
            log.error("转换错误",e);
        }
        return vo;
    }

    /**
     * @author qiang.wen
     * @param vo
     * @param po
     * @param <V>
     * @param <P>
     * @return
     * vo转换为po
     */
    public static <V,P> P convertVo2Po(V vo,P po){
        if(po == null || vo == null){
            throw new ApiException(ResponseCode.ILLEGAL_PARAM.getCode(),ResponseCode.ILLEGAL_PARAM.getMsg());
        }
        try {
            BeanUtils.copyProperties(po,vo);
        }catch (Exception e){
            log.error("转换错误",e);
        }
        return po;
    }
}
