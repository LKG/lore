package im.heart.material.vo;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.material.entity.MaterialPeriodical;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class MaterialPeriodicalVO  extends MaterialPeriodical {
    @JSONField(serialize = false)
    private String importLog;

    /**
     * //用户是否收藏该商品
     */
    private Boolean isCollect;

    /**
     * //用户是否购买过该商品
     */
    private Boolean isBuy;

    @JSONField(format="yyyy-MM-dd")
    private Date createTime;
    /** 静态路径. */
    private static String staticPath="";
    @JSONField (serialize = false)
    private Date modiTime;
    @JSONField (serialize = false)
    private Boolean isPub;
//    @JSONField (serialize = false)
//    private Status checkStatus;

    @JSONField (serialize = false)
    private String pathUrl;

    @JSONField (serialize = false)
    private String realFilePath;

//    @JSONField (serialize = false)
//    private Status status;
    public MaterialPeriodicalVO(MaterialPeriodical po){
        this(po,true);
    }
    public MaterialPeriodicalVO(MaterialPeriodical po,boolean lazy){
        BeanUtils.copyProperties(po, this);
    }
}
