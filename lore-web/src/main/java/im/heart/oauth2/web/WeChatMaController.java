package im.heart.oauth2.web;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import im.heart.core.web.AbstractController;
import im.heart.oauth2.WeChatAuthService;
import im.heart.usercore.entity.FrameUserConnect;
import im.heart.usercore.service.FrameUserConnectService;
import im.heart.usercore.service.FrameUserService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

@Slf4j
public class WeChatMaController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(WeChatMaController.class);
    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private FrameUserService frameUserService;
    @Autowired
    private FrameUserConnectService frameUserConnectService;

    @RequestMapping("/wx/user/sessionInfo")
    public ModelAndView getSessionInfo (String code){
        try{

            WxMaJscode2SessionResult sessionInfo= this.wxMaService.jsCode2SessionInfo(code);
            Optional<FrameUserConnect> frameUserConnectOpt=this.frameUserConnectService.findByOpenIdAndType(sessionInfo.getOpenid(),"");
            if(frameUserConnectOpt.isPresent()){

            }
        }catch (WxErrorException e){
            log.error(e.getStackTrace()[0].getMethodName(), e);
        }
      return null;
    }
}