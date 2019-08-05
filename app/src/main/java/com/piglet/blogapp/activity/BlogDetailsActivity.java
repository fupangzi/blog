package com.piglet.blogapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import com.piglet.blogapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_test_html)
    TextView tvTestHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_details);
        ButterKnife.bind(this);
        tvTestHtml.setText(Html.fromHtml("<h2>2018-01-04</h2>\n" +
                "<pre><code class=\"lang-\"># 使用vue的Webpack模板生成脚手架\n" +
                "</code></pre>\n" +
                "<h2>2018-01-05</h2>\n" +
                "<pre><code class=\"lang-\"># 引入ElementUI\n" +
                "\n" +
                "# babel-plugin-component自定义主题\n" +
                "# 首页\n" +
                "# 登陆页\n" +
                "# 注册页面\n" +
                "# 日志页\n" +
                "</code></pre>\n" +
                "<h2>2018-01-07</h2>\n" +
                "<pre><code class=\"lang-\"># 调整底部栏始终固定在底部\n" +
                "# 日志页 添加时间轴\n" +
                "# 首页的文章列表\n" +
                "</code></pre>\n" +
                "<h2>2018-01-08</h2>\n" +
                "<pre><code class=\"lang-\"># 使用组件-博客作者tab页 \n" +
                "# 添加第三方图标\n" +
                "</code></pre>\n" +
                "<h2>2018-01-09</h2>\n" +
                "<pre><code class=\"lang-\"># 调整顶部导航栏：激活文字颜色，click点击\n" +
                "# 组件-最新文章tab页\n" +
                "\n" +
                "# 最新文章、最热文章使用相同组件\n" +
                "# 底部栏设计\n" +
                "# 页面与两边边距改为100\n" +
                "</code></pre>\n" +
                "<h2>2018-01-10</h2>\n" +
                "<pre><code class=\"lang-\"># 写博客 引入mavonEditor编辑器\n" +
                "# 顶部导航栏都放入一个Menu中\n" +
                "# 写文章页面\n" +
                "#　mavonEditor局部引入\n" +
                "\n" +
                "#　页面的中间区域固定宽度，自动居中\n" +
                "# 发布和取消\n" +
                "# 发布dialog\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-11</h2>\n" +
                "<pre><code class=\"lang-\"># 文章组件用守卫来改变body背景色\n" +
                "# 调整登陆和注册页面，使其居中\n" +
                "\n" +
                "#子页面调整根元素为div\n" +
                "#文章详情页\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-12</h2>\n" +
                "<pre><code class=\"lang-\"># 文章详情页 内容 评论等\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-13</h2>\n" +
                "<pre><code class=\"lang-\">## 重新调整页面结构\t\n" +
                "#顶部和底部 抽成 BaseHeader BaseFooter 组件\n" +
                "#BlogView为单独页，以前是Home的子路由\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-15</h2>\n" +
                "<pre><code class=\"lang-\"># 文章分类去掉子级\n" +
                "# 将首页的文章列表抽成 ArticleItem组件\n" +
                "# 增加文章的评论展示\n" +
                "# 增加文章分类、标签页\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-15 2</h2>\n" +
                "<pre><code class=\"lang-\"># 回到顶部去掉过渡动画（影响顶部导航栏）\n" +
                "# 顶部导航栏 增加登录后菜单\n" +
                "# 首页增加 最热标签\n" +
                "# 增加 文章分类 标签的详情页\n" +
                "# 将文章详情页、 文章分类标签页 改为Home的子路由（以前单独页）\n" +
                "# Home组件增加路由判断：更正导航栏的状态、条件显示底部栏\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-16</h2>\n" +
                "<pre><code class=\"lang-\"># 将写文章的顶部Header合并到BaseHeader中\n" +
                "# 图片都放到了static目录下\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-24</h2>\n" +
                "<pre><code class=\"lang-\"># 将自定义的theme放到assets下\n" +
                "# 加入axios\n" +
                "# 加入vuex\n" +
                "# 实现登录\n" +
                "# 实现退出\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-25</h2>\n" +
                "<pre><code class=\"lang-\"># 实现注册逻辑\n" +
                "# 写文章功能实现\n" +
                "# 写文章时支持插入图片\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-26</h2>\n" +
                "<pre><code class=\"lang-\"># 引入lodash工具类\n" +
                "# 优化写文章的工具栏：滚动时固定顶部\n" +
                "# 写文章 后台获取文章分类和标签\n" +
                "\n" +
                "# 首页的文章列表\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-27</h2>\n" +
                "<pre><code class=\"lang-\"># 修改首页文章列表的样式\n" +
                "# 首页加载文章功能\n" +
                "# 文章查看功能\n" +
                "# 文章分类和标签功能列表\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-28</h2>\n" +
                "<pre><code class=\"lang-\"># 文章分类和标签详情\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-29</h2>\n" +
                "<pre><code class=\"lang-\"># 文章分类和标签的文章数\n" +
                "# 首页最热文章\n" +
                "# 首页最新文章\n" +
                "# 首页最热标签\n" +
                "\n" +
                "</code></pre>\n" +
                "<h2>2018-01-30</h2>\n" +
                "<pre><code class=\"lang-\"># BaseHeader放回views中\n" +
                "# 修改Axios后置拦截，全局处理错误\n" +
                "# 将登录 退出 和头像 放到一起\n" +
                "\n" +
                "</code></pre>\n" +
                ""));
    }
}
