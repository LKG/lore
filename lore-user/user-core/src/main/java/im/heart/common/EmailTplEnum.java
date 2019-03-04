package im.heart.common;

import lombok.Data;

public enum EmailTplEnum {
    FIND_PWD("EMAIL_02","findPwd","用户密码找回", "findPwd.ftl");
    public String templateId;
    public String name;
    public String description;
    /**
     * 模板路径
     */
    public String templatePath;
    EmailTplEnum( String templateId,String name,String description,String templatePath) {
        this.name = name;
        this.templateId = templateId;
        this.templatePath = templatePath;
        this.description = description;
    }

    public static EmailTplEnum fromName(String name){
        for(EmailTplEnum refer : EmailTplEnum.values()) {
            if (refer.name.equals(name)) {
                return refer;
            }
        }
        return null;
    }
}
