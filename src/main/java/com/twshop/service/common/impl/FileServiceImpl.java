package com.twshop.service.common.impl;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.base.util.cipher.MD5Util;
import com.base.util.conf.PropUtil;
import com.base.util.file.LocalFileUtil;
import com.base.util.string.StringUtil;
import com.twshop.Constants;
import com.twshop.service.common.IFileService;
import com.twshop.vo.common.UploadResultVO;

/**
 * @classname: FileServiceImpl
 * @description: 文件服务
 * @author java
 *
 */
@Service
public class FileServiceImpl implements IFileService {

	@Override
	public File find(String fileName) throws Exception {
		return new File(getPath() + fileName);
	}

	@Override
	public UploadResultVO insertImgFile(MultipartFile file) throws Exception {
		UploadResultVO result = null;
		if (file != null && StringUtil.isNotBlank(file.getOriginalFilename())) {
			String fileName = insertSourceFile(file.getOriginalFilename(), file.getSize(), file.getContentType(),
					file.getBytes(), getPath());
			result = new UploadResultVO(fileName, file.getContentType(), Constants.SITE_NAME_IMG + fileName);
		}
		return result;
	}

	@Override
	public String insertNorFile(MultipartFile file, String path) throws Exception {
		if (file != null && StringUtil.isNotBlank(file.getOriginalFilename())) {
			return insertSourceFile(file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes(),
					path);
		}
		return "";
	}

	@Override
	public String insertTempFile(MultipartFile file) throws Exception {
		if (file != null && StringUtil.isNotBlank(file.getOriginalFilename())) {
			return insertSourceFile(file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes(),
					getTempPath());
		}
		return null;
	}

	@Override
	public String getTempPath() {
		String path = null;
		String fs = System.getProperties().getProperty("file.separator");
		if ("\\".equals(fs)) {
			path = PropUtil.getInstance().get("resource.temppath.windows");
		} else {
			path = PropUtil.getInstance().get("resource.temppath.linux");
		}
		return path;
	}

	@Override
	public void del(String file_name) throws Exception {
		if (StringUtil.isNotBlank(file_name)) {
			LocalFileUtil.delFile(getPath() + file_name);
		}
	}

	private String getPath() {
		String path = null;
		String fs = System.getProperties().getProperty("file.separator");
		if ("\\".equals(fs)) {
			path = PropUtil.getInstance().get("resource.path.windows");
		} else {
			path = PropUtil.getInstance().get("resource.path.linux");
		}
		return path;
	}

	private String insertSourceFile(String file_name, long file_size, String context_type, byte[] bs,
			String resource_folder) throws Exception {
		String uuid = MD5Util.MD5EncodeWithUtf8(new String(bs));

		String suffix = file_name.substring(file_name.lastIndexOf("."), file_name.length());

		String targetPath = resource_folder + uuid + suffix;

		LocalFileUtil.writeFile(targetPath, bs);

		return uuid + suffix;
	}

}
