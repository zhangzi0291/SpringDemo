package com.demo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QrCodeUtil {

	public static void main(String[] args){
		createQrcode("https://www.baidu.com");
		readQRCode("e:/qrcode/qrcode.png");
	}
	
	public static String createQrcode(String _text){
		return createQrcode(_text,300,300);
	}
	    
	public static String createQrcode(String _text,int qrcodeWidth, int qrcodeHeight){
        String qrcodeFilePath = "";
        try {
            String qrcodeFormat = "png";
            HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); 
            BitMatrix bitMatrix = new MultiFormatWriter().encode(_text, BarcodeFormat.QR_CODE, qrcodeWidth, qrcodeHeight, hints);

            BufferedImage image = new BufferedImage(qrcodeWidth, qrcodeHeight, BufferedImage.TYPE_INT_RGB);
            Random random = new Random();
            File QrcodeFile = new File("E:\\qrcode\\qrcode."+ qrcodeFormat);
            ImageIO.write(image, qrcodeFormat, QrcodeFile);
            MatrixToImageWriter.writeToFile(bitMatrix, qrcodeFormat, QrcodeFile);
            qrcodeFilePath = QrcodeFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qrcodeFilePath;
    }
	
	private static void readQRCode(String filePath) {
        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File(filePath);
            BufferedImage image = null;
            image = ImageIO.read(file);
            HashMap hashMap = new HashMap();
            hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = formatReader.decode(binaryBitmap, hashMap);
            System.out.println("解析结果："+result.toString());
            System.out.println("二维码格式类型："+result.getBarcodeFormat());
            System.out.println("二维码文本："+result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
