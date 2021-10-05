package com.sy.springsecurity_oauth_jjwt_demo.restful.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 孙宇
 * @since 2021-10-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String url;

    private String path;

    private String component;

    private String menuName;

    @TableField("iconCls")
    private String iconCls;

    private Boolean keepAlive;

    private Boolean requireAuth;

    @TableField("parentId")
    private Integer parentId;


}
