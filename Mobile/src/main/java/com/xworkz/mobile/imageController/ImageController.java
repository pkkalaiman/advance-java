package com.xworkz.mobile.imageController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class ImageController {

	public ImageController() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}

	@PostMapping("/Imageupload")
	public String onUpload(@RequestParam("mani") MultipartFile multipartFile) throws IOException {
		System.out.println("MultiPartFile :" + multipartFile);
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getContentType());
		System.out.println(multipartFile.getSize());
		System.out.println(multipartFile.getBytes());

		byte[] bytes = multipartFile.getBytes();
		Path path = Paths.get("C:\\imageupload-files\\" + multipartFile.getOriginalFilename());
		Files.write(path, bytes);
		return "ImageUpload";
	}

	@GetMapping("/display")
	public void onDownload(HttpServletResponse response, @RequestParam String filName) throws IOException {
		response.setContentType("mani/jpg");
		File file = new File("C:\\imageupload-files\\" + filName);
		// File Into Byte--> Response
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();

	}

}
