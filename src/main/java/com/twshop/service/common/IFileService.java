package com.twshop.service.common;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.twshop.vo.common.UploadResultVO;

/**
 * 上传文件
 * 
 */
public interface IFileService {

	/**
	 * 根据文件名获取文件
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	File find(String fileName) throws Exception;

	/**
	 * 上传图片
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	UploadResultVO insertImgFile(MultipartFile file) throws Exception;

	/**
	 * 插入正常文件
	 * 
	 * @param file
	 * @param path
	 * @throws Exception
	 */
	String insertNorFile(MultipartFile file, String path) throws Exception;

	/**
	 * 上传临时图片
	 * 
	 * @param file
	 * @return
	 */
	String insertTempFile(MultipartFile file) throws Exception;

	/**
	 * 获取上传临时文件路径
	 * 
	 * @return
	 * @throws Exception
	 */
	String getTempPath() throws Exception;

	/**
	 * 删除图片
	 * 
	 * @param file_name
	 * @throws Exception
	 */
	void del(String file_name) throws Exception;
}
