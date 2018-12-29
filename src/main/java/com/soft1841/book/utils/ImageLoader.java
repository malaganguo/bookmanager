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
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImageLoader {
//    private static ImageLoader instance = new ImageLoader();
//
//    private ImageLoader() {
//    }
//
//    public static ImageLoader getInstance() {
//        return instance;
//    }
//
//    //线程池
//    private ExecutorService executor = Executors.newFixedThreadPool(8);
//
//    public List<Image> loadImages(String path) {
//        List<Image> images = new ArrayList<>();
//        File file = new File(path);
//        if (!file.isDirectory()) {
//            throw new RuntimeException("need directory!");
//        }
//        File[] files = file.listFiles(new FilenameFilter() {
//
//            @Override
//            public boolean accept(File dir, String name) {
//                //判断是图片类型文件
//                if (name.endsWith(".jpg") || (name.endsWith(".png"))) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        //并发加载图片，并使用Future保存加载结果
//        List<Future<Image>> futures = new ArrayList<>();
//        for (final File f : files) {
//            Future<Image> future = executor.submit(() -> {
//                return new Image(f.getName(), f.getAbsolutePath());
//            });
//            futures.add(future);
//        }
//
//        //等待所有并发加载返回结果
//        try {
//            for (Future<MyLabel> future : futures) {
//                MyLabel icon = future.get();
//                images.add(icon);
//            }
//        } catch (InterruptedException e) {
//            System.err.println("中断异常");
//        } catch (ExecutionException e) {
//            System.err.println("线程池异常");
//        }
//
//        //Java8使用stream API 进行排序
//        List<JLabel> sortedList = images.stream().sorted().collect(Collectors.toList());
//
//        return sortedList;
//    }
//
//    //继承MyImageView并实现Comparable接口，从而对MyImageView进行排序
//    private static class MyImageView extends ImageView implements Comparable<MyImageView> {
//        private static final long serialVersionUID = 1L;
//        private String fileName;
//
//        public MyImageView(String fileName, String fullPath) {
//            this.fileName = fileName;
//            //使用thumbnailator生成缩略图
//            setImage(new Image(fullPath));
//        }
//
//        @Override
//        public int compareTo(MyImageView o) {
//            int result = this.fileName.compareTo(o.fileName);
//            return result;
//        }
//    }
}