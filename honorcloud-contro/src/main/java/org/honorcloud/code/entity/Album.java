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
public class Album extends Model<Album> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String albumCode;

    private String albumName;

    private LocalDateTime updateTime;

    private String playerCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumCode() {
        return albumCode;
    }

    public void setAlbumCode(String albumCode) {
        this.albumCode = albumCode;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public static final String ID = "id";

    public static final String ALBUM_CODE = "album_code";

    public static final String ALBUM_NAME = "album_name";

    public static final String UPDATE_TIME = "update_time";

    public static final String PLAYER_CODE = "player_code";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Album{" +
        "id=" + id +
        ", albumCode=" + albumCode +
        ", albumName=" + albumName +
        ", updateTime=" + updateTime +
        ", playerCode=" + playerCode +
        "}";
    }
}
