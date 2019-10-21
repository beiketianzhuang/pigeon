package com.msg.pigeon.model.req;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
public class MessageReq {

    @NotEmpty(message = "发送人不能为空")
    private String from;
    @NotEmpty(message = "接收人不能为空")
    private List<String> tos;
    private String message;

}
