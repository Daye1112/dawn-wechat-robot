package com.darren1112.dwr.sdk.starter.qx.enums;

/**
 * 接口类型枚举
 *
 * @author darren
 * @since 2023/2/14
 */
public enum ApiTypeEnum {
    /**
     * 接口类型
     */
    WECHAT_LIST("X0000", "获取微信列表"),
    SEND_MSG("Q0001", "发送文本消息"),
    MODIFY_DOWNLOAD_IMAGE("Q0002", "修改下载图片"),
    PERSONA_INFO("Q0003", "获取个人信息"),
    QUERY_OBJECT_INFO("Q0004", "查询对象信息"),
    FRIENDS_LIST("Q0005", "获取好友列表"),
    GROUP_CHAT_LIST("Q0006", "获取群聊列表"),
    PUBLIC_NUMBERS_LIST("Q0007", "获取公众号列表"),
    a("Q0008", "获取群成员列表"),
    b("Q0009", "发送聊天记录"),
    c("Q0010", "发送图片"),
    d("Q0011", "发送本地文件"),
    e("Q0012", "发送分享链接"),
    f("Q0013", "发送小程序"),
    g("Q0014", "发送音乐分享"),
    h("Q0015", "发送XML"),
    i("Q0016", "确认收款"),
    j("Q0017", "同意好友请求"),
    k("Q0018", "添加好友_通过v3"),
    l("Q0019", "添加好友_通过wxid"),
    m("Q0020", "查询陌生人信息"),
    n("Q0021", "邀请进群"),
    o("Q0022", "删除好友"),
    p("Q0023", "修改对象备注"),
    q("Q0024", "修改群聊名称"),
    r("Q0025", "发送名片"),
    ;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String desc;

    ApiTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

}
