package com.bawei.xbanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> images;
    ArrayList<String> titles;
    @BindView(R.id.banner)
    XBanner banner;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
// 初始化XBanner中展示的数据
        images = new ArrayList<>();
        titles = new ArrayList<>();

        images.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=e9449e382d9759ee4a5067cd8ac0242b/94cad1c8a786c9179e80a80cc23d70cf3bc75700.jpg");
        titles.add("这是第1张图片");
        images.add("http://img.ivsky.com/img/bizhi/co/201711/27/nissan_vmotion2_0-001.jpg");
        titles.add("这是第2张图片");
        images.add("http://img.ivsky.com/img/tupian/co/201709/18/zise_huaduo.jpg");
        titles.add("这是第3张图片");
        images.add("http://img.ivsky.com/img/tupian/co/201709/16/dahailidehaiguitupian.jpg");
        titles.add("这是第4张图片");

        // 为XBanner绑定数据
        banner.setData(images, titles);

        // XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(MainActivity.this).load(images.get(position)).into((ImageView) view);
            }
        });

// 设置XBanner的页面切换特效，选择一个即可，总的大概就这么多效果啦，欢迎使用
        //     banner.setPageTransformer(Transformer.Default);//横向移动
        //banner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
        //banner.setPageTransformer(Transformer.Rotate);  //单页旋转
        //banner.setPageTransformer(Transformer.Cube);    //立体旋转
       // banner.setPageTransformer(Transformer.Flip);  // 反转效果
        //banner.setPageTransformer(Transformer.Accordion); //三角换页
       // banner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
        //banner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
       // banner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
        //banner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
       // banner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
        //banner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面

        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(1000);

        //xbanner的点击事件
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Toast.makeText(MainActivity.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({ R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                banner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
                break;
            case R.id.button2:
                banner.setPageTransformer(Transformer.Rotate);  //单页旋转
                break;
            case R.id.button3:
                banner.setPageTransformer(Transformer.Default);//横向移动
                break;
            case R.id.button4:
                banner.setPageTransformer(Transformer.Cube);    //立体旋转
                break;
            case R.id.button5:
                banner.setPageTransformer(Transformer.Flip);  // 反转效果
                break;
            case R.id.button6:
                banner.setPageTransformer(Transformer.Accordion); //三角换页
                break;
            case R.id.button7:
                banner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
                break;
            case R.id.button8:
                banner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
                break;
            case R.id.button9:
                banner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
                break;
            case R.id.button10:
                banner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
                break;
            case R.id.button11:
                banner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
                break;
            case R.id.button12:
                banner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面
                break;
        }
    }
}
