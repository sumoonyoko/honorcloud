package org.honorcloud.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

@Data
public class User extends Model<Room> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6178720891004579583L;
	
    /**
     * id
     */
    @SuppressWarnings("deprecation")
	@TableId(value = "id", type = IdType.UUID)
	private String id;

    private String openid;

    private String name;
   
    private String image; //头像
    
    private String username;

    private String password;
    
    private static final String ID = "id";
    
    private static final String OPENID = "open_id";
    
    private static final String NAME = "name";
    
    private static final String IMAGE = "image";
    
    private static final String USERNAME = "user_name";
    
    private static final String PASSWORD = "password";

    @Override
    public String toString() {
        return "User{" +
                " id='" + id + '\'' +
                
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
               
                ", image='" + image + '\'' +
                '}';
    }
}
