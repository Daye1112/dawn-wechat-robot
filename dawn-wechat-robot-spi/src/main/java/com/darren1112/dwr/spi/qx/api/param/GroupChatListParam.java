package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-获取群聊列表Param
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
public class GroupChatListParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 1=从缓存中获取，2=重新遍历二叉树并刷新缓存
     */
    private String type;
}
