$(function () {

});
/*
* 提交 userId
* 根据 userId 推荐用户列表
* */
function getRecommondInfo(userid) {
    $.ajax({
        url: "${APP_PATH}/recommond",
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
* */
function build_RecommondInfo(result) {
    /*存储文章集*/
    $("#recommondUserInfo").empty();
    var articlesInfo = result.extend.pageInfo.list;
    $.each(articlesInfo, function (index, item) {
        var box = $("<li></li>");
        var img = $("<img src=\"\" class=\"user-image\" alt=\"\">").attr("src", item.userimg).attr("alt", item.username);
        var name = $("<a class=\"users-list-name\" href=\"#\"></a>").html(item.username)
        var btn = $("<span class=\"users-list-date\"> + 关注</span>").prop("data-user", item.userid);
        box.append(img).append(name).append(btn);
        $("#recommondUserInfo").append(box);
    });

}