package im.heart.oauth2.web;

import im.heart.oauth2.WeChatAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WeChatController {
    private Logger logger = LoggerFactory.getLogger(WeChatController.class);
    @Autowired
    private WeChatAuthService weChatAuthService;
    

}
