package com.shop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.shop.util.Message;


/**
 * @author chuankun
 *@2016年5月4日 下午8:47:42
 * email:yichuankun@qq.com
 */
@Controller
@RequestMapping("/file")
public class UploadController {
	
	private String relativePath;
    /**
     * 上传文件，并以当前时间给文件重命名
     * 返回值：如果文件为空，则返回错误提示;若成功则返回文件相对路径
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
               // 这里我用到了jar包
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
 
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    if(fileName.equalsIgnoreCase("")){
                    	return Message.getMessage(0, "文件为空！","");
                    }
//                    String path2= Thread.currentThread()
//                            .getContextClassLoader().getResource("").getPath();
////                            + "download" + File.separator;
//                   int now = path2.indexOf("WEB-INF");
////                   System.out.println(path2.substring(0, now));
//                   path2 = path2.substring(0,now);
////                    System.out.println(">>>>>>>>>>"+path2);
                    
                    String path1="file/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
                    		fileName.substring(fileName.lastIndexOf(".")); //获取文件后缀
                    String path = getRelativePath()+path1;
                    File localFile = new File(path);
                    System.out.println(path);
                    file.transferTo(localFile);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("path", path1);
                    return Message.getMessage(1, "", map);
                }
 
            }
           
        }

        return Message.getMessage(0, "文件为空！","");
 
    }
    
    /**
     * 获取当前路径
     * @return
     */
    private String getRelativePath(){
    	if(relativePath!=null)
    		return relativePath;
    	relativePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    	int cut = relativePath.lastIndexOf("WEB-INF");
    	relativePath = relativePath.substring(0, cut);
    	return relativePath;
    	
    }
    
}