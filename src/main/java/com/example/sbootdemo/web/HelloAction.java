package com.example.sbootdemo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.sbootdemo.common.Cache;
import com.example.sbootdemo.mqtt.MqttService;
import com.example.sbootdemo.pojo.Person;
import com.example.sbootdemo.pojo.User;
import com.example.sbootdemo.service.NewsCrawler;
import com.example.sbootdemo.service.QueueService;
import com.example.sbootdemo.service.TestService;
import com.example.sbootdemo.service.UserService;
import com.example.sbootdemo.util.AuthUtils;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.Vector;

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
    @Autowired
    private MqttService mqttService;

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
        testService.add(2, "1");
    }

    @GetMapping("/getQueue")
    public void getQueue() {
        new Thread("wuzh") {
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

        new Thread("hh") {
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
     *
     * @return
     */
    @GetMapping("/resttemplate")
    public String testRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //加上下面一行解决中文乱码问题，因为RestTemplate()中默认添加的StringHttpMessageConverter的编码格式是ISO-8859-1
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String forObject = restTemplate.getForObject("http://www.baidu.com", String.class);
        System.err.println("-------------" + forObject);
        return forObject;
    }

    /**
     * mqtt发布端发布信息测试
     */
    @GetMapping("/mqtt")
    public void mqttTest() {
        mqttService.pubMsgToTopic("666666666", "bibi");
    }

    /**
     * 事务测试
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/trans")
    public String transactionalTest() {
        String test;
        try {
//            userService.transactionalTest();
            test = userService.translogicTest();
        } catch (Exception e) {
            return "fail!!";
        }
        return "success!!" + test;
    }

    /**
     * 测试一个SQl语句的效果
     *
     * @return
     */
    @GetMapping("/sql")
    public String sqlTest() {
        Person person = new Person("qq", "123");
        //返回值id是影响行数，最新的id值在下面操作最后已经在对象person.id中了
        Long id = userService.getIdTest(person);
        Long id1 = person.getId();
        return id1 + ",,," + id;
    }


    /**
     * MD5测试,能加密不能解密，Spring自带的DigestUtils，加密出来是32字节的。适合作为其他加密算法的key值
     */
    @GetMapping("/md5")
    public void md5Test() {
        String hex = DigestUtils.md5DigestAsHex("654321".getBytes());
        System.err.println(hex + "-----------length:" + hex.length());
    }

    /**
     * 将多个文件合并到一个新文件里去，注意下面第三个文件的内容是有顺序的，与Vector的添加顺序有关
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/file")
    public String fileMergeTest() throws Exception {
        File file1 = new File("F:\\1.txt");
        File file2 = new File("F:\\2.txt");
        System.err.println(file1.length());
        System.err.println(file2.length());
        InputStream is1 = new FileInputStream(file1);
        InputStream is2 = new FileInputStream(file2);
        Vector<InputStream> v = new Vector<InputStream>();
        v.add(is1);
        v.add(is2);

        Enumeration<InputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);

        //目的地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\3.txt"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = sis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        sis.close();
        return "success!!";
    }

    /**
     * 将一个文件的内容拆分成若干个固定字节大小，便于后续操作（此处打印在控制台）
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/split")
    public String fileSplitTest() throws Exception {
        //公网上的文件
        URL url = new URL("https://routerupgrade-3caretec.oss-cn-hangzhou.aliyuncs.com/liteupgrade/user1.4096.new.6.bin");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        System.out.println(connection.getContentLength() + "--------------文件包含字节数---------------");
        //本地文件
//        File file = new File("F:\\1.txt");
//        FileInputStream is = new FileInputStream(file);

        int i;
        byte[] bytes = new byte[500];
        while ((i = is.read(bytes)) != -1) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(500);
            baos.write(bytes, 0, i);
            String aaa = baos.toString();
            System.err.println(aaa + "##########");
        }
        return "success!!";
    }

    /**
     * 将服务器端的文件下载到客户端本地上
     *
     * @return
     */
    @GetMapping("/download")
    public void downloadToLocal(HttpServletResponse resp) throws Exception{
        //服务器端需要被下载的文件路径
        String serverFile = "F:/aa.txt";

        InputStream is = new FileInputStream(new File(serverFile));
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-disposition", "attachment; filename=" + serverFile.substring(serverFile.lastIndexOf("/") + 1)); // 设定输出文件头
        OutputStream bos = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = is.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        is.close();
        bos.close();
    }

    /**
     * 网络爬虫测试接口
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/crawler")
    public String crawlerTest() throws Exception {
        NewsCrawler crawler = new NewsCrawler("crawl", true);
        crawler.setThreads(5);
        crawler.getConf().setTopN(10);
        //crawler.setResumable(true);//设置是否为断点爬取，默认为false
        /*start crawl with depth of 4*/
        crawler.start(2);
        return "success";
    }

    /**
     * 如果该接口放在公网域名中被访问，返回值是访问者的公网ip
     *
     * @param request
     * @return
     */
    @GetMapping("/getip")
    public String getPublicIp(HttpServletRequest request) {
        String ip;
        // 处理代理情况
        ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip)
                || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip)
                || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip)
                || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                InetAddress inet = null;// 根据网卡取本机配置的IP
                try {
                    inet = InetAddress.getLocalHost();//idea-PC/192.168.212.144
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();//192.168.212.144
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割,多级代理的时候会得到多个以,分割的ip，
        //这时候第一个是真实的客户端ip
        if (ip != null && ip.length() > 15) { // "***.***.***.***".length()
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 测试对Cache中的同一对象进行wait和赋值后再notify操作的可行性
     * notify的实现在定时任务ScheduledTask类中
     *
     * @return  等待30秒，如果超时未被赋值，响应的user的name和password均为null，否则name和password为被赋予的值。测试结果为是可行的。
     */
    @GetMapping("/wait")
    public String waitAndNotifyTest() throws InterruptedException {
        User user = User.builder().id(1).build();
        Cache.putCache("wait",user);
        synchronized (user){
            long remaining = 30*1000;
            long future = System.currentTimeMillis()+remaining;
            while (user.getName()==null&&remaining>0){
                user.wait(remaining);
                remaining = future-System.currentTimeMillis();
            }
            Cache.removeCache("wait");
        }
        return user.toString();
    }

    /**
     * 测试日志文件的打印
     *
     */
    private static Logger logger = LoggerFactory.getLogger(HelloAction.class);
    @GetMapping("/log")
    public String logTest(){
        logger.info("#######INFO########");
        logger.error("#######ERROR########");
        logger.warn("#######WARN########");
        return "success";
    }

    /**
     * 测试java项目中引入.py文件，并获取python文件的执行结果。
     * 注意点：1、运行本java项目的机器上安装python环境。2、将编写好的python文件放到java项目的某一个包中。3、python环境具有python文件引用的所有模块(包括第三方模块)
     *
     */
    @GetMapping("/python")
    public String pythonTest() throws Exception{
        String projectPath = System.getProperty("user.dir"); //获得项目路径
        Process process = Runtime.getRuntime().exec("F:\\PyCharmWorkSpace\\venv\\Scripts\\python.exe "+projectPath+"/src/main/java/python/test.py");// 本机的python运行环境 & 即将要调用的py文件
        BufferedReader in = new BufferedReader(new
                InputStreamReader(process.getInputStream(),"gbk")); //设置编码方式，否则输出中文时容易乱码
        String line;
        StringBuilder str = new StringBuilder();
        while ((line = in.readLine()) != null) {
            System.err.println(line);
            str.append(line);
        }
        in.close();
        process.waitFor();
        return String.valueOf(str);
    }

}
