package im.heart.material.vo;

import com.alibaba.fastjson.annotation.JSONField;
import im.heart.material.entity.Periodical;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PeriodicalVO  extends Periodical {

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
    public PeriodicalVO(Periodical po){
        this(po,true);
    }
    public PeriodicalVO(Periodical po,boolean lazy){
        BeanUtils.copyProperties(po, this);
    }
}
