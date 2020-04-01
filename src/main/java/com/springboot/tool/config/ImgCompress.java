package com.springboot.tool.config;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author 王阳
 * @date 2020/3/31 11:27
 */
public class ImgCompress {

    public static InputStream compressImage(MultipartFile source_file, String target_path) throws IOException {
        InputStream input = null;
        try {
            int maxWidth = 400;//限制最大宽
            int maxHeight = 400;//限制最大高
            //获得文件源
            InputStream ins = source_file.getInputStream();
            File file = new File(source_file.getOriginalFilename());
            inputStreamToFile(ins, file);
            Image img = ImageIO.read(file);
            int originWidth = img.getWidth(null);
            int originHeight = img.getHeight(null);
            int targetWidth = 0;//目标宽
            int targetHeight = 0;//目标高
            //宽或者高超过最大上限时进行压缩
            if (originWidth > maxWidth || originHeight > maxHeight) {
                if(originWidth >= originHeight){//横图或方图
                    targetWidth = maxWidth;
                    targetHeight = (int) Math.round(maxWidth * (double)originHeight / (double)originWidth);
                }else{//竖图
                    targetHeight = maxHeight;
                    targetWidth = (int) Math.round(maxHeight * (double)originWidth / (double)originHeight);
                }
            }
            BufferedImage tag = new BufferedImage(targetWidth,targetHeight,BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img,0,0,targetWidth,targetHeight,null);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(tag, "jpg", os);
            input = new ByteArrayInputStream(os.toByteArray());
            return input;
//            FileOutputStream out = new FileOutputStream(target_path);
            //JPEGImageEncoder可适用于其他图片的类型的转换
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            JPEGEncodeParam encoder_param = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//            encoder_param.setQuality(1f, true);//质量压缩,范围为0.1-1之间,若压缩尺寸过小,建议压缩质量设为最高1f
//            encoder.setJPEGEncodeParam(encoder_param);
//            encoder.encode(tag);
//            out.close();
//            return true;
        } catch(Exception e) {
//            return false;
        }
        return input;
    }

    public static void inputStreamToFile(InputStream ins,File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
