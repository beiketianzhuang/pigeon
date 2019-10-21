package com.msg.pigeon.model.req;

import com.msg.pigeon.validation.UserPassword;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class UserReq {

    @NotEmpty(message = "用户名不能为空")
    @Length(min = 4, max = 20, message = "用户名的字符长度必须为4-20个字符")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度必须在6-20字符之间")
    @UserPassword
    private String password;

}
