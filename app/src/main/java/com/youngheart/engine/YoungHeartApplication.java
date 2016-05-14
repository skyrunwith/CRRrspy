package com.youngheart.engine;

import com.infrastructure.cache.CacheManager;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;

import java.io.File;

public class YoungHeartApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate(); 
		
		CacheManager.getInstance().initCacheDir();
		// 设置硬盘缓存
		// 默认为StorageUtils.getCacheDirectory(getApplicationContext())
		// 即/mnt/sdcard/android/data/包名/cache/
		// .discCache(new
		// UnlimitedDiscCache(StorageUtils.getCacheDirectory(getApplicationContext())))

		// 设置硬盘缓存的最大大小
		// .discCacheSize(50 * 1024 * 1024)

		// 设置硬盘缓存的文件的最多个数
		// .discCacheFileCount(100)

		// 设置硬盘缓存文件名生成规范
		// 默认为new HashCodeFileNameGenerator()
		// .discCacheFileNameGenerator(new Md5FileNameGenerator())
		File dis = StorageUtils.getCacheDirectory(getApplicationContext());

		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
				.writeDebugLogs()
				.diskCache(new UnlimitedDiskCache(dis))
				.diskCacheSize(50 * 1024 * 1024)
				.diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.build();
		ImageLoader.getInstance().init(configuration);
	}
}
