package com.darren1112.dwr.spi.qx.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * 千寻-修改下载图片param
 *
 * @author luyuhao
 * @since 2023/2/13
 */
@Data
public class ModifyDownloadImageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型 "23:30-23:30"为全天下载, "00:01-23:59"为全天不下载
     */
    private String type;
}
