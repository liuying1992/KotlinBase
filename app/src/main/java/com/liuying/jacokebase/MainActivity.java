package com.liuying.jacokebase;

import android.content.Intent;
import android.os.Bundle;
import com.liuying.jacokebase.activity.LifecycleAActivity;
import com.liuying.jacokebase.activity.MTestActivity;
import com.liuying.jacokebase.base.BaseActivity;
import com.liuying.jacokebase.model.JetpacketViewModel;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //java调用Kotlin方法 需要注意在build.gradle中添加相关 plugins
    JetpacketViewModel jetpacketViewModel = new JetpacketViewModel();
    jetpacketViewModel.launchData();
    findViewById(R.id.tv_content).setOnClickListener(
        v -> startActivity(new Intent(this, MTestActivity.class)));
    findViewById(R.id.btn_a).setOnClickListener(
        v -> startActivity(new Intent(this, LifecycleAActivity.class)));
  }
}