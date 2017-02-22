package com.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
  * @ClassName: FtpHelper
  * @Description: TODO
  * @author zxn
  * @date 2016年7月18日 上午10:20:16
  *
 */
public class FtpHelper {

	private static Logger logger = LoggerFactory.getLogger(FtpHelper.class);

	private static FtpHelper ftpHelper;

	private FTPClient ftp;

	private FtpHelper() {
	}

	private FtpHelper(String ip, int port, String username, String password) {
		ftp = new FTPClient();
		try {
			ftp.connect(ip, port);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				try {
					logger.debug("FTP服务器拒绝连接");
					throw new Exception("FTP服务器拒绝连接");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (username != null) {
				if (!ftp.login(username, password)) {
					ftp.disconnect();
					try {
						logger.debug("登陆验证失败，请检查账号和密码是否正确");
						throw new Exception("登陆验证失败，请检查账号和密码是否正确");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			ftp.setControlEncoding("UTF-8");//这里设置编码
	        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
	        conf.setServerLanguageCode("zh");
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
	        
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FtpHelper getInstance() {
		if (ftpHelper == null) {
			return new FtpHelper();
		}
		return ftpHelper;
	}
	/**
	 * 
	  * 获取FtpHelper实例
	  *@param FTP服务器ip
	  *@param 端口号
	  *@param 用户名
	  *@param 密码
	  *@return 
	  *@date 2016年7月18日 上午10:10:32
	  *@author zxn
	 */
	public static FtpHelper getInstance(String ip, int port, String username, String password) {
		if (ftpHelper == null) {
			return new FtpHelper(ip.trim(), port, username.trim(), password.trim());
		}
		return ftpHelper;
	}
	/**
	 * 
	  * 获取FtpHelper实例，默认端口号21
	  *@param FTP服务器ip
	  *@param 用户名
	  *@param 密码
	  *@return 
	  *@date 2016年7月18日 上午10:10:32
	  *@author zxn
	 */
	public static FtpHelper getInstance(String ip, String username, String password) {
		if (ftpHelper == null) {
			return new FtpHelper(ip.trim(), 21, username.trim(), password.trim());
		}
		return ftpHelper;
	}

	/**
	 * 
	  *从FTP服务器下载文件到本地
	  *@param FTP上文件的路径（包括文件名）
	  *@param 下载到本地的文件路径（包括文件名）
	  *@return 
	  *@date 2016年7月18日 上午10:12:16
	  *@author zxn
	 */
	public boolean downloadFile(String remotePath, String localPath) {
		File file = new File(localPath);
		try {
			remotePath = new String(remotePath.getBytes(),"ISO-8859-1");
			OutputStream os = new FileOutputStream(file);
			ftp.retrieveFile(remotePath, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 
	  * 上传文件到FTP服务器
	  *@param 上传到的FTP服务器路径
	  *@param 需要上传的文件路径（包括文件名）
	  *@param 上传到FTP服务器的文件名
	  *@return 
	  *@date 2016年7月18日 上午10:14:25
	  *@author zxn
	 */
	public boolean uploadFile(String path, String uploadFile, String filename) {
		boolean success = false;

			try {
				filename = new String(filename.getBytes(),"ISO-8859-1");
				InputStream input = new FileInputStream(uploadFile);
				ftp.changeWorkingDirectory(path);
				ftp.storeFile(filename, input);
				input.close();
				success = true;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return success;
	}

	/**
	 * 
	  * 获取FTP指定目录下的文件列表
	  *@param FTP服务器的指定路径
	  *@return 
	  *@date 2016年7月18日 上午10:16:29
	  *@author zxn
	 */
	public List<FTPFile> getFtpFileList(String remotePath) {
		List<FTPFile> ftpfiles = null;
		try {
			ftpfiles = Arrays.asList(ftp.listFiles(remotePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ftpfiles;
	}
	
	/**
	 * 
	  * 获取当前工作位置的文件列表
	  *@return 
	  *@date 2016年7月18日 上午10:18:38
	  *@author zxn
	 */
	public List<FTPFile> getNowFileList(){
		List<FTPFile> ftpfiles = null;
		try {
			ftpfiles = Arrays.asList(ftp.listFiles());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ftpfiles;
	}
	
	/**
	 * 
	  * 关闭FTP服务器连接
	  *@date 2016年7月18日 上午10:19:01
	  *@author zxn
	 */
	public void closeClient() {
		try {
			ftp.logout();
			ftp.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	  * 设置当前FTP服务器工作位置
	  *@param remoteFoldPath
	  *@return 
	  *@date 2016年7月18日 上午10:19:29
	  *@author zxn
	 */
	public Boolean setPath(String remoteFoldPath) {
		try {
			return ftp.changeWorkingDirectory(remoteFoldPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		FtpHelper ftp = FtpHelper.getInstance("127.0.0.1", 21, "zero", "zero");
//		ftp.downloadFile("/2.jpg", "D:/2.jpg");
//		ftp.uploadFile("/", "F:/化作樱花树.txt", "化作樱花树.txt");
		System.out.println(ftp.getNowFileList());
		ftp.setPath("../");
		for(FTPFile f:ftp.getFtpFileList("/")){
			System.out.println(f.getName());
		}
		ftp.closeClient();
	}
}
