$(function () {
    getRecommondInfo(1);
});
/*
*  获取 推荐用户 列表
* */
function getRecommondInfo(userid) {
    $.ajax({
        url: "/recommond",
        data: "userid=" + userid,
        type: "GET",
        success: function (result) {
            if (result.code == 100) {
                build_RecommondInfo(result);
            }
        }
    });
}
/*
* 解析拼凑成 推荐列表
* 遍历数据集，组合dom 元素，将元素添加到元素尾部
* {
*   "code":100,
*   "msg":"Success！",
*   "extend":{
*       "recommondUserInfo":[
*       {
*           "userid":3,"username":"vvPuN","password":null,"userimg":"user3-128x128.jpg","articlenumber":6,"likes":55,"fans":61,"follows":8
*       }
*    ]}}
* */
function build_RecommondInfo(result) {
    /*存储文章集*/
    $("#recommondUserInfo").empty();
    var articlesInfo = result.extend.recommondUserInfo;
    $.each(articlesInfo, function (index, item) {
        var box = $("<li></li>");
        var img = $("<img src=\"\" class=\"user-image\" alt=\"\">").attr("src", "/static/img/" + item.userimg).attr("alt", item.username);
        var name = $("<a class=\"users-list-name\" href=\"#\"></a>").html(item.username).attr("href", "/person/" + item.userid);
        var btn = $("<span class=\"users-list-date\"> + follow</span>").prop("data-user", item.userid);
        box.append(img).append(name).append(btn);
        $("#recommondUserInfo").append(box);
    });

}