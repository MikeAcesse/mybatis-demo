package com.fzk.mybatis.dao;

import com.fzk.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/21 18:00
 */
public interface OrderMapper {
	OrderUser queryOrderUserByOrderNumber(@Param("number") String number);
}
