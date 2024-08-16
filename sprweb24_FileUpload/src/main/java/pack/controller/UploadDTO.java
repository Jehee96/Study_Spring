package pack.controller;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadDTO {
	private String myName;
	private MultipartFile myFile;
	
}
