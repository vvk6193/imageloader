package com.vivek.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.TypedValue;

import com.vivek.imageloader.tasks.ImageLoadTask;

import java.io.File;

/**
 * Created by vivek-pc on 12/14/2015.
 */
public class ImageLoader {
    private Context context;
    private ImageLoader(Context context) {
        this.context = context;
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, r.getDisplayMetrics());

    }

    public static ImageLoader with(Context context) {
        return new ImageLoader(context);
    }

    public ImageLoadTask load(int resourceId) {
        return new ImageLoadTask(resourceId,context);
    }

    public ImageLoadTask load(File file) {
        return new ImageLoadTask(file,context);
    }

    public ImageLoadTask load(String path) {
        return new ImageLoadTask(path,context);
    }

    public ImageLoadTask load(Uri uri) {
        return new ImageLoadTask(uri,context);
    }


}
