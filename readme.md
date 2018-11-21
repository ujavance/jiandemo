
## 2018-11-5
### 登录
1. 校验姓名，用户名可以是2-5位中文或者6-16位英文和数字的组合
2. 校验密码，3-6位英文和数字的组合


### 说明
1. generate 自动生成简单的 SQL 语句
2. json 返回模板， Msg
3. 单例模式，打印 log 信息
4. 图片路径 - 由配置文件读取

### 数据库
1. 外键关联模式使用 cascade
2. user 主键 userid 使用自动增长


### 问题

1. 主键 userId 开始设置为 char(20) 类型，tbl_folder 参考 tbl_user 的 userId 作为外键，后修改为 userId 类型为 int 时，出现无法修改，原因外键关联。
2. like 字段存在冲突，使用 'like'
3. Model 和 ModelAndView 的使用
   ```java
   @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ModelAndView checkUser(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("personal");
        mv.addObject("user", userService.getUser(id));
        return mv;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String checkUser(@PathVariable("id") Integer id) {
        Model mv = new Model();
        mv.addAttribute("user", userService.getUser(id));
        return "personal";
    }
   ```
4. insert 默认返回插入成功的条数，根据返回 int 值判断是否插入成功。
5. 读取 配置文件中的属性
    ```html
    <!-- Spring 配置文件中 -->
    <context:property-placeholder location="classpath:dbconfig.properties,classpath:other.properties" />
    <!-- dbconfig.properties 配置 DataSource 的基本值， 无法配置多个 【context:property-placeholder】 加载一个后，剩下的将失效。-->

    <!-- 采用如下格式配置：同时， XXX.properties、 YYY.properties 都放置在 Resources 文件下
    <context:property-placeholder location="classpath: XXX.properties,classpath:YYY.properties" />
     -->

    <!-- XXX.java 中读取配置文件中的属性值 -->
    @Value("${img.url}")
    private String imgUrl;
    ```
6. 用a标签post提交表单
    ```html
    <form name='form1' action='/url' method='post'>
    <a href='javascript:document.form1.submit();'>登录</a>  
    ```

### 界面

1. AdminLTE-2.3.0 基于 Bootstrap的模板

## 2018-11-6
### 功能
1. 首页浏览文章
2. 发布文章
登录页面放在 view 中，过滤配置
## 2018-11-9

1. 配置拦截器过滤登录请求
2. JQuery 
    ```html
    var str = "abc";str = str.substr(0, str.length-1);
    ```

### 首页发布逻辑
1. 进入首页，加载到用户id放到，发布文章的隐藏域中

### 文件上传
#### 问题
> 1. `$.ajax` post 转换成 get 问题
> 2. Dao 对象无法封装
> 3. SpringMVC value注解

转换成 Get 问题，网上说到是因为跨域问题
Dao 对象无法封住是因为，对象的 Getter 和 Setter 方法没有实现

### 发表文章
Article 表数据插入失败。
> 因为没有设置数据库自动增长键,必须显示设置id。

同时，Comment 表关联 Article articleId，导致必须先删除 Comment 的外键关联，然后才可以修改
Article的 articleId 为自动增长。

### 展示文章

先找到关注用户的id结合，然后根据集合去文章中找到 时间是当天，然后找到评论

MySql
> 触发器 - 向用户表插入一条数据后，就想关注表中插入一条关注信息。

### 文章点赞
> 文章id， 用户id，赞数增加一
> 评论 （文章id， 用户id）,增加一条评论

```javascript
$(".commenttoggle").toggle(800); 
// 动态效果
```

### 进入首页，展示用户的图片名称

## 2018-11-11 22:00:35

### 点赞

### 发布评论

### 问题
1. 数据库更新字段，根据主键更新字段

2. SpringMVC @Value 注解，仅能在 Service 中配置，无法在 Controller 中配置

3. MySQL数据库中的Date,DateTime,TimeStamp和Time类型

  |          | **timestamp**                                                | **datetime**                                                 |
  | -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | 大小     | 4个字节                                                      | 8个字节                                                      |
  | 值       | 允许为空值，但是不可以自定义值，所以为空值时没有任何意义。   | 允许为空值，不可以设定默认值，所以在不允许为空值的情况下，必须手动指定datetime字段的值才可以成功插入数据 |
  | 时间     | 不能早于1970或晚于2037                                       | 1000-9999                                                    |
  | 时区     | 时区转化 ，存储时对当前的时区进行转换，检索时再转换回当前的时区 | 与时区无关                                                   |
  | 默认值   | 默认值为CURRENT_TIMESTAMP()，其实也就是当前的系统时间        | 可以在指定datetime字段的值的时候使用now()变量来自动插入系统的当前时间。 |
  | 修改记录 | 修改表中的记录会自动被更新为当前的系统时间                   | 不变<br />适合用来记录数据的原始的创建时间                   |
  | 选择     | 1. 时间范围<br />2. 存储长度<br />3. 时区、是否自动更新      |                                                              |

  [数据库中timestamp,datetime,int时间类型区别](https://blog.csdn.net/xcymorningsun/article/details/53393023)

4. 一对一查询实现的两种方式

    ```xml
    // 方式一：嵌套结果：使用嵌套结果映射来处理重复的联合结果的子集封装联表查询的数据(去除重复的数据)
    <!--
    	SELECT * from class c, teacher t where c.teacher_id=t.t_id and c.c_id = 1;
    -->
    // 方式二：嵌套查询：通过执行另外一个SQL映射语句来返回预期的复杂类型
    <!--
        SELECT * FROM class WHERE c_id=1;
        SELECT * FROM teacher WHERE t_id=1 
    -->
    
    // 1. xml 配置文件
    <select id="selectCommentOfArticle" parameterType="int" resultMap="CommentOfArticleMap">
        SELECT C.commentId, C.commentBody, C.commentCreateTime, A.userId, A.userName, A.userImg
        from tbl_user A, tbl_comment C
        WHERE A.userId = C.userId and C.articleId = #{id}
    </select>
    
    // 2. 文章评论
    <resultMap id="CommentOfArticleMap" type="com.uj.jian.bean.Comment">
        <id column="commentId" property="commentid" />
        <result column="commentBody" property="commentbody" />
        <result column="commentCreateTime" property="commentcreatetime" />
    
        <association javaType="com.uj.jian.bean.User" property="user">
            <id column="userId" property="userid" />
            <result column="userName" property="username" />
            <result column="userImg" property="userimg" />
        </association>
    </resultMap>
    
    // 3. Comment 中有属性 User
    
    // 
    ```

    [MyBatis学习总结(五)——实现关联表查询 ](https://www.cnblogs.com/xdp-gacl/p/4264440.html ) [孤傲苍狼](https://www.cnblogs.com/xdp-gacl/)

5. 设置 Typora 快捷键方法

    ```html
    // File -> Preference -> Advanced Setting (最下面) -> Open Advenced Setting -> conf.user.json
    // 配置以下快捷键。（其中有很多快捷键在默认设置里已经包括，如 ctrl+shift+p 等）
    // 1. 修改默认为 ctrl+d 的select word 为ctrl+alt+d
    // 2. 设置 删除一行为 ctrl+d
    // 3. 设置插入代码为 ctrl+shift+a
    // 4. 将以下配置 粘贴到 conf.user.json 中，然后重新打开 typora 测试是否生效。
      "keyBinding": {
        // for example: 
        // "Always on Top": "Ctrl+Shift+P"
        "Always On Top": "Ctrl+Shift+P",
        "Code Fences": "Ctrl+Shift+F",
        "Ordered List": "Ctrl+Alt+o",
        "Unordered List": "Ctrl+Alt+u",
        "Select Word":"Ctrl+Alt+D",
        "Delete Line/Sentence":"Ctrl+D",
        "Code Fences":"Ctrl+Shift+A"
      },
    ```

6. jQuery 函数的使用
    ```javascript
    //parseInt 方法都有两个参数, 第一个参数就是要转换的对象, 第二个参数是进制基数, 可以是 2, 8, 10, 16, 默认以 10 进制处理
    parseInt(str);
    
    $(selector).html(content);	  //改变被选元素的（内部）HTML
    $(selector).append(content);	  //向被选元素的（内部）HTML 追加内容
    $(selector).prepend(content);  //向被选元素的（内部）HTML “预置”（Prepend）内容
    $(selector).after(content);	  //在被选元素之后添加 HTML
    $(selector).before(content);	  //在被选元素之前添加 HTML
    
    // 用a标签post提交表单
    <form name='form1' action='oneGetAllCultivateEndCertificateServlet' method='post'>  
        <input type='hidden' name='page' value='1'/>  
        <input type='hidden' name='hiddenA' value='A'/>  
        <a href='javascript:document.form1.submit();'>提交</a>  
    </form>
    // 原文：https://blog.csdn.net/moshushin/article/details/44461213 
    
    
    // parent()，parents()
    $(selector).parent() 该元素的父元素
    $(selector).parents() 该元素的父元素集合
    
    /* 
    jQuery中的.html()和.text()及.val()区别
    　　　　.html(),.text(),.val()三种方法都是用来读取选定元素的内容；
    　　　　.html()是用来读取元素的html内容（包括html标签）；
    　　　　.text()用来读取元素的纯文本内容，包括其后代元素；
    　　　　.val()是用来读取表单元素的"value"值；
    　　　　.html()和.text()方法不能使用在表单元素上,而.val()只能使用在表单元素上；
    　　　　.html()方法使用在元素集合上时，只读取第一个元素；.val()方法和.html()相同，如果其应用在元素集合上时，只能读取第一个表单元素的"value"值，但是.text()不一样，如果.text()应用在多个元素上时，将会读取所有选中元素的文本内容；
    　　　　.html(htmlString),.text(textString)和.val(value)三种方法都是用来替换选中元素的内容，如果三个方法同时运用在多个元素上时，那么将会替换所有选中元素的内容；
    　　　　.html(),.text(),.val()都可以使用回调函数的返回值来动态的改变多个元素的内容；
    */
    ```

7. 表单默认，回车提交数据

   ```html
   <form id='form1' action='a1.jsp' method='post'>
       <input style='display:none' />
       <input type='text' name='name' onkeydown='if(event.keyCode==13){saveComment($("this"));}' />
   </form>
   
   <scritp type="text/javascript">
       function saveComment(dom){
       	dom.val();
       	if (commentContent.length > 1) {
               $.ajax({
                   url: "${APP_PATH}/comment",
                   data: {commentbody: commentContent, articleid: commentId, userid: userid},
                   type: "put",
                   success: function (result) {
                       if (result.code == 100) {
                           console.log(result);
       				   // 使用 ajax 不经过后台直接插入一条评论
                           insertComment(commentContent, dom);
       				   // 清空评论表单 input 中的数据
                           dom.val("");
                       }
                   }
               });
           }
       }
   </scritp>
   ```



## 2018-11-14
### 防止多次点赞
1. 先找到是否已经点赞
    已经点赞，返回【已经点赞】提示信息
2. 点赞成功后，将点赞记录保存到 tbl_read 表格 
    (1 表示已经点赞 0表示未点赞)
3. 返回已经点赞
4. WriteMapper 中加入已经点赞的 MySQL

### 排序问题
> 时间，按照从当前日期往前排


### 个人中心
2. person Get 方式 person/102 表示进入102用户的界面
3. 根据 id,使用 Ajax 在 tbl_user 中查询到，用户相关信息
   `userId`, `userName`, ` `, `userImg`,`likes`, `fans`, `follows`
4. 根据 id , 使用Ajax在 tbl_article中，根据 时间 向前排序，每页10条进行分页。显示用户发表的文章信息。
   可以进行点击。可以发表评论。
   复用首页的代码
   `articleId`, `articleWords`, `articleHead`, `articleTime`, `articleBody`, `articleReadNums`, `userId`, `tagId`, `likenum`, `userImg`) VALUES (1, NULL, '1541819465738-捕获.PNG', '2018-11-11 20:34:04', '删库跑路，请找我。', 0, 1, 1, 8, 'user1-128x128.jpg');
5. 使用 Redis 进行进行相似关注好友运算

### 关注

1. 关注。关注后，post 提交信息 userid，targetid，currentime
2. 是否关注。根据userid，targetid进行判断
3. 获取关注集合。根据当前用户ID获取关注列表，并写入到 Redis 中。在用户页面展示相似关注用户 
4. 读取用户关注信息，从推荐中减去当前信息，然后推荐