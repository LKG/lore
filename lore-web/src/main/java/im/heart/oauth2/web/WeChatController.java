package im.heart.oauth2.web;
import com.alibaba.fastjson.JSON;
import im.heart.core.web.AbstractController;
import im.heart.oauth2.WeChatAuthService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Slf4j
public class WeChatController  extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(WeChatController.class);
    @Autowired
    private WeChatAuthService weChatAuthService;

    @Autowired
    private WxMpService wxMpService;

    /**
     *  获取授权Code
     * @param state
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/authorize")
    public ModelAndView authorize(@RequestParam(value = "state" ,required = false) String state) throws UnsupportedEncodingException {
        String url="http://doc.itaobao.pub/wechat/userInfo";
        String redirectUrl=wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(state,"UTF-8"));
        log.info("【微信网页授权】获取code,redirectUrl={}",redirectUrl);
        return new ModelAndView(redirectToUrl(redirectUrl));
    }

    /**
     *  获取根据code 获取access_token 并用户信息
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/userInfo")
    public ModelAndView userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken=wxMpService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
            log.error("【微信网页授权】,{}",e);
        }
        String openId=wxMpOAuth2AccessToken.getOpenId();
        log.info("【微信网页授权】wxMpOAuth2AccessToken={}", JSON.toJSONString(wxMpOAuth2AccessToken));
        log.info("【微信网页授权】获取openid={},returnUrl={}",openId,returnUrl);
        return new ModelAndView(redirectToUrl(returnUrl+"?openid="+openId));

    }

    /**
     *  微信网页登陆
     * @param returnUrl
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/qrAuthorize")
    public ModelAndView qrAuthorize(@RequestParam(value = "returnUrl" ,required = false) String returnUrl) throws UnsupportedEncodingException {
        String url="doc.itaobao.pub/wechat/userInfo";
        String redirectUrl=wxMpService.buildQrConnectUrl(url, WxConsts.QrConnectScope.SNSAPI_LOGIN,URLEncoder.encode(returnUrl,"UTF-8"));
        return new ModelAndView(redirectToUrl(redirectUrl));
    }

    /**
     * 获取用户信息
     * @param code
     * @param returnUrl
     * @return
     */
    @GetMapping("/qrUserInfo")
    public ModelAndView qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken=new WxMpOAuth2AccessToken();
        try{
            wxMpOAuth2AccessToken=wxMpService.oauth2getAccessToken(code);
        }catch (WxErrorException e){
            log.error("【微信网页】{}",e);
        }
//        log.info("wxMpOAuth2AccessToken={}", JSON.toJson(wxMpOAuth2AccessToken));
        String openId=wxMpOAuth2AccessToken.getOpenId();
        return new ModelAndView(redirectToUrl(returnUrl+"?openid="+openId));
    }
}