/**
 * Created by Dao fengfeng on 2016/12/15.
 */
$("#banner>aside>ul>li").on("mouseover", function () {
  $(this).addClass("active").siblings("li").removeClass("active");
});