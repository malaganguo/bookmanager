package com.soft1841.book.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * 使用线程池来加载网络图片
 */
public class ImageLoader {
    private static ImageLoader instance = new ImageLoader();

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        return instance;
    }

    String[] imgSources = {
            "http://pj7ldvis7.bkt.clouddn.com/avatar/1.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/2.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/3.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/4.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/5.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/6.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/7.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/8.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/9.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/10.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/11.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/12.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/13.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/14.jpg",
            "http://pj7ldvis7.bkt.clouddn.com/avatar/15.jpg"
    };

    //线程池
    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Image> loadImages() {
        List<Image> images = new ArrayList<>();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (String path : imgSources) {
                    images.add(new Image(path));
                }
            }
        });
        return images;
    }

    public static void main(String[] args) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        long from = System.currentTimeMillis();
        List<Image> images = imageLoader.loadImages();
        long to = System.currentTimeMillis();
        long period = to - from;
        System.out.println("use " + period + " milliseconds");
    }
}