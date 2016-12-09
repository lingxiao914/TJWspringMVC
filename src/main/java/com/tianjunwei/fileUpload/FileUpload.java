package com.tianjunwei.fileUpload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileUpload {

	@RequestMapping("/upload")
	@ResponseBody
	public String upload( MultipartFile... files ){
		
		for (MultipartFile f : files) {
			if (f.getSize() > 0) {
				File targetFile = new File("1.jpg");
				try {
					f.transferTo(targetFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	@RequestMapping("/uploads")
	public String uploads(){
		return "fileupload";
	}
}
