package im.heart.oauth2;

public enum  IdentityType {
    QQ("qq","QQ登录"),
    WECHAT("wechat","微信登录");
    private IdentityType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String code;
    public String desc;
}
