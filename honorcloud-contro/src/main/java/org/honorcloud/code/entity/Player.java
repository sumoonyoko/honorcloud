package org.honorcloud.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sumoon
 * @since 2020-03-09
 */
public class Player extends Model<Player> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    private String playerCode;

    /**
     * 用户名称
     */
    private String playerName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String playerImg;

    /**
     * 类型：微信用户，QQ用户、本地用户等
     */
    private String type;

    /**
     * 是否在线（0：不在线，1：在线）
     */
    private String online;

    /**
     * 权限分级，1-5
     */
    private String permission;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 自我介绍
     */
    private String intro;

    /**
     * 本命英雄
     */
    private String heros;

    /**
     * 职业
     */
    private String careers;

    private String enabled;

    private String locked;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlayerImg() {
        return playerImg;
    }

    public void setPlayerImg(String playerImg) {
        this.playerImg = playerImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getHeros() {
        return heros;
    }

    public void setHeros(String heros) {
        this.heros = heros;
    }

    public String getCareers() {
        return careers;
    }

    public void setCareers(String careers) {
        this.careers = careers;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public static final String ID = "id";

    public static final String PLAYER_CODE = "player_code";

    public static final String PLAYER_NAME = "player_name";

    public static final String PASSWORD = "password";

    public static final String PLAYER_IMG = "player_img";

    public static final String TYPE = "type";

    public static final String ONLINE = "online";

    public static final String PERMISSION = "permission";

    public static final String REGISTER_TIME = "register_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String INTRO = "intro";

    public static final String HEROS = "heros";

    public static final String CAREERS = "careers";

    public static final String ENABLED = "enabled";

    public static final String LOCKED = "locked";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Player{" +
        "id=" + id +
        ", playerCode=" + playerCode +
        ", playerName=" + playerName +
        ", password=" + password +
        ", playerImg=" + playerImg +
        ", type=" + type +
        ", online=" + online +
        ", permission=" + permission +
        ", registerTime=" + registerTime +
        ", updateTime=" + updateTime +
        ", intro=" + intro +
        ", heros=" + heros +
        ", careers=" + careers +
        ", enabled=" + enabled +
        ", locked=" + locked +
        "}";
    }
}
