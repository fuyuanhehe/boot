package com.boot.boot.logger;

import java.io.Serializable;

/**
 * 说明：日志（注解）记录模型
 * */
public class LoggerModel implements Serializable {
    private static final long serialVersionUID = 8854304753156197872L;

    private String content; // 操作内容
    private int operType; // 0:增加;1:修改;2:删除,3查询
    private String remark; // 备注（预留字段，暂时无用）

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LoggerModel{" +
                "content='" + content + '\'' +
                ", operType=" + operType +
                ", remark='" + remark + '\'' +
                '}';
    }
}
