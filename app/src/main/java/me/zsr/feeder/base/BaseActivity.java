package me.zsr.feeder.base;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.avos.avoscloud.AVAnalytics;

import me.zsr.feeder.BuildConfig;
import me.zsr.feeder.dao.FeedSource;
import me.zsr.feeder.data.FeedDB;
import me.zsr.feeder.util.LogUtil;

/**
 * @description:
 * @author: Match
 * @date: 15-7-5
 * @version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onResume() {
        super.onResume();
        AVAnalytics.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AVAnalytics.onPause(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (BuildConfig.DEBUG) {
            if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
                // Dump db
                for (FeedSource feedSource : FeedDB.getInstance().loadAll()) {
                    LogUtil.e("FeedSource=" + feedSource.toString());
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
