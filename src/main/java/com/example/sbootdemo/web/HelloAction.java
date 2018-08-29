package com.example.sbootdemo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.sbootdemo.pojo.User;
import com.example.sbootdemo.service.QueueService;
import com.example.sbootdemo.service.TestService;
import com.example.sbootdemo.service.UserService;
import com.example.sbootdemo.util.AuthUtils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

/**
 * User: DHC
 * Date: 2018/3/2
 * Time: 14:02
 * Version:V1.0
 */
@RestController
public class HelloAction {
    @Value("${server.port}")
    private int port;
    @Autowired
    private UserService userService;
    @Autowired
    private QueueService queueService;
    @Autowired
    private TestService testService;
    @Autowired
    private StringEncryptor stringEncryptor;

    @GetMapping("/hello")
    public User index() {
        System.out.println("+++++++++++" + port);
        User user = userService.findUserById(1);
        String encrypt = stringEncryptor.encrypt("root");
        System.err.println(encrypt);
        return user;
    }

    @GetMapping("/add")
    public void add() {
        //测试数据库中的sex字段为tinyint类型，这里将String类型的sex属性插入数据库，运行正常
        testService.add(2,"1");
    }

    @GetMapping("/getQueue")
    public void getQueue(){
        new Thread("wuzh"){
            @Override
            public void run() {
                synchronized (HelloAction.class) {
                    try {
                        queueService.putUser(User.builder().id(1).name("wuzh").password("123456").build());
                        this.sleep(10);
                        User user = queueService.pollUser("router");
                        System.err.println(LocalTime.now() + "-----------" + Thread.currentThread().getName() + "取得队列中的对象为：" + user.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("hh"){
            @Override
            public void run() {
                synchronized (HelloAction.class) {
                    try {
                        queueService.putUser(User.builder().id(2).name("hh").password("123hh").build());
                        this.sleep(10);
                        User user = queueService.pollUser("router");
                        System.err.println(LocalTime.now() + "-----------" + Thread.currentThread().getName() + "取得队列中的对象为：" + user.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 微信公众号授权登入逻辑下面2个接口：/wxLogin和/callBack，外加一个工具类AuthUtils
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/wxLogin")
    public void login(HttpServletResponse response) throws IOException {
        //第一步：用户授权并获取code
        String backUrl = "http://localhost:80/callBack";//此回调URL要求能在外网中访问，提供给微信后台回调时访问
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtils.APP_ID +
                "&redirect_uri=" + URLEncoder.encode(backUrl) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        response.sendRedirect(url);
    }

    @GetMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //第二步：用code换取access_token
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtils.APP_ID +
                "&secret=" + AuthUtils.APP_SECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtils.doGetJson(url);
        String openid = (String) jsonObject.get("openid");
        String token = (String) jsonObject.get("access_token");
        //第三步：刷新token时间非必须，这里不写
        //第四步：用access_token和openid获取用户信息
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + token +
                "&openid=" + openid +
                "&lang=zh_CN";
        JSONObject userInfo = AuthUtils.doGetJson(infoUrl);
        System.err.println(userInfo);
    }

    /**
     * 测试RestTemplate获得的乱码问题
     * @return
     */
    @GetMapping("/resttemplate")
    public String testRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        //加上下面一行解决中文乱码问题，因为RestTemplate()中默认添加的StringHttpMessageConverter的编码格式是ISO-8859-1
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String forObject = restTemplate.getForObject("http://www.baidu.com", String.class);
        System.err.println("-------------"+forObject);
        return forObject;
    }
}
