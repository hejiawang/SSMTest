package com.wang.test.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.wang.test.utils.MatrixToImageWriter;

@Controller
@RequestMapping("/qrCode")
public class QRCodeController extends BaseController {

    private static final String KEY = "keycode";  
    private static final String SIZE = "msize";  
    private static final String IMAGETYPE = "JPEG";  
	
	@RequestMapping(value = "/createQRCode")
	public void createQRCode(HttpServletRequest request,HttpServletResponse response, String keycode){
		
		if (keycode != null && !"".equals(keycode)) {  
            ServletOutputStream stream = null;  
            try {  
                int size=129;  
                String msize = request.getParameter(SIZE);  
                if (msize != null && !"".equals(msize.trim())) {  
                	size=Integer.valueOf(msize);  
                }  
                stream = response.getOutputStream();  
                QRCodeWriter writer = new QRCodeWriter(); 
                BitMatrix m = writer.encode(keycode, BarcodeFormat.QR_CODE, size, size);  
                MatrixToImageWriter.writeToStream(m, IMAGETYPE, stream);  
            } catch (Exception e) {  
                e.printStackTrace();
            } finally {
            	try{
            		if (stream != null) {  
                        stream.flush();
                        stream.close();
                    }  
            	} catch(Exception e){
            		e.printStackTrace();
            	}
            }  
        }  
	}
	
}
