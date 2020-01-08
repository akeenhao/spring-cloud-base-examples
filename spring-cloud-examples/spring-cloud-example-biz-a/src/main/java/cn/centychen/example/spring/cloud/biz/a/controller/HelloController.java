package cn.centychen.example.spring.cloud.biz.a.controller;

import cn.centychen.example.spring.cloud.biz.a.service.RemoteService;
import com.sun.jna.Library;
import com.sun.jna.Native;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cent.Chen
 * @Description
 * @date 2019/8/2 10:16 AM
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private RemoteService remoteService;

    /**
     * 示例方法
     *
     * @return
     */
    @GetMapping
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello,This is Biz-A Service.";
    }

    @GetMapping
    @RequestMapping("/go")
    public String go() {
        System.setProperty("jna.encoding", "GBK");//解决中文乱码
        return Dll.INSTANCE.go("777");

    }


    public static void main(String[] args) {
        Dll.INSTANCE.go("777");
    }
    public interface Dll extends Library {
        String dir=Native.class.getResource("").getPath().substring(1);
        String s1=dir+"lib/oci.dll";

        //        this.getc ("/").getpath()+"api.dll"
//        Dll INSTANCE = (Dll) Native.loadLibrary("./oci.dll", Dll.class);// 加载动态库文件
        Dll INSTANCE = (Dll) Native.loadLibrary(s1, Dll.class);// 加载动态库文件
        String go(String s);
    }


    /**
     * 示例方法：调用服务B
     *
     * @return
     */
    @GetMapping(path = "/call2b")
    public String sayHello2B() {
        return remoteService.sayHello();
    }
}
