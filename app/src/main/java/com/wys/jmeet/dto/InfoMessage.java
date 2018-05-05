package com.wys.jmeet.dto;

public class InfoMessage {
    // 头像地址
    private String avatarUrl;
    // 用户名
    private String username;
    // 创建时间
    private String createTime;
    // 文件地址
    private String fileUrl;
    // 文件类型
    private int fileType;
    // 描述
    private String description;
    // 点赞数量
    private int agreeNumber;
    // 评论数量
    private int commentNumber;

    public int getAgreeNumber() {
        return agreeNumber;
    }

    public void setAgreeNumber(int agreeNumber) {
        this.agreeNumber = agreeNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
