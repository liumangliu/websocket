package com.coding.controller;

import com.coding.handler.WebSocketServer;
import com.coding.handler.WebSocketServerTest;
import com.coding.service.MsgSendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liumang
 */
@Slf4j
@Api(tags = "消息接口")
@RequiredArgsConstructor
@RestController
public class MsgController {
    /**
     * 日志打印
     */
    private final static Logger logger = LoggerFactory.getLogger(MsgController.class);

    private final MsgSendService msgSendService;
    private final WebSocketServer webSocketServer;
    private final WebSocketServerTest webSocketServerTest;


    @ApiOperation("发送消息")
    @RequestMapping("/send")
    public String send(@RequestBody Map<String,Object> data) {
        logger.info("转换前参数：{} \n",data);
        String s = JSONObject.toJSONString(data);
        logger.info("转换后参数：{}",s);

        int size = msgSendService.sendMsg(s);
        webSocketServer.sendToAll(s);
        return data.get("flg").toString();
    }

//    @ApiOperation("发送消息")
//    @GetMapping("testSend")
//    public String testSend(String msg) {
////        Map<String,Object> map=new HashMap<>();
////        map.put("msg",msg);
////        map.put("date", LocalDateTime.now().toString());
////        int size = msgSendService.sendMsg(map);
//        webSocketServerTest.sendToAll(msg);
//        return "发送成功" + "test";
//    }


}
