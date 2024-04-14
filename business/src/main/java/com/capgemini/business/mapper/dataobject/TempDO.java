package com.capgemini.business.mapper.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 测试临时表(TempDO)表实体类
 *
 * @author makejava
 * @since 2024-04-12 09:23:53
 */
@Data
@TableName("temp")
public class TempDO {
    //id
    @TableId(type = IdType.ASSIGN_ID)
    private String tempId;
    //用户名
    private String userName;
    //联系方式
    private String phoneNum;

}

