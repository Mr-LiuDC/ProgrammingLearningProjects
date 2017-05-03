package cn.alittler.study.java.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @description: 执行文件压缩的工具类
 * @date: Created on 2017年4月17日
 * @author: Mr.LiuDC
 * @email: 1911939348@qq.com
 */
public class ZipHelper {

	private byte[] buf;

	// 用于压缩中。要去除的绝对父路路径，目的是将绝对路径变成相对路径。
	private String deleteAbsoluteParent;

	/**
	 * 构造方法。默认缓冲区大小为512字节。
	 */
	public ZipHelper() {
		this(512);
	}

	/**
	 * 构造方法。
	 * 
	 * @param bufSize
	 *            指定压缩或解压时的缓冲区大小
	 */
	public ZipHelper(int bufSize) {
		this.buf = new byte[bufSize];
		deleteAbsoluteParent = null;
	}

	/**
	 * 压缩文件夹内的所有文件和目录。
	 * 
	 * @param zipDirectory
	 *            需要压缩的文件夹名
	 */
	public void doZip(String zipDirectory) {
		File zipDir = new File(zipDirectory);
		doZip(new File[] { zipDir }, zipDir.getName());
	}

	/**
	 * 压缩文件夹内的所有文件和目录。
	 * 
	 * @param zipDirectory
	 *            需要压缩的文件夹名
	 */
	public void doZip(String zipDirectory, String zipPath) {
		File zipDir = new File(zipDirectory);
		doZip(new File[] { zipDir }, zipPath);
	}

	/**
	 * 压缩多个文件或目录。可以指定多个单独的文件或目录。而 <code>doZip(String zipDirectory)</code>
	 * 则直接压缩整个文件夹。
	 * 
	 * @param files
	 *            要压缩的文件或目录组成的<code>File</code>数组。
	 * @param zipFileName
	 *            压缩后的zip文件名，如果后缀不是".zip"， 自动添加后缀".zip"。
	 */
	public void doZip(File[] files, String zipFileName) {
		// 未指定压缩文件名，默认为"ZipFile"
		if (zipFileName == null || zipFileName.equals(""))
			zipFileName = "ZipFile";

		// 添加".zip"后缀
		if (!zipFileName.endsWith(".zip"))
			zipFileName += ".zip";
		ZipOutputStream zipOut = null;
		try {

			zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(zipFileName)));
			compressFiles(files, zipOut, true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				zipOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			zipOut = null;
		}
	}

	/**
	 * 压缩多个文件或目录。可以指定多个单独的文件或目录。而 <code>doZip(String zipDirectory)</code>
	 * 则直接压缩整个文件夹。
	 * 
	 * @param files
	 *            要压缩的文件或目录组成的<code>File</code>数组。
	 * @param zipFileName
	 *            压缩后的zip文件名，如果后缀不是".zip"， 自动添加后缀".zip"。
	 */
	public void doZip(String zipFileName, Map<String, byte[]> fileInfos,
			String basePath) {
		// 未指定压缩文件名，默认为"ZipFile"
		if (zipFileName == null || zipFileName.equals(""))
			zipFileName = "ZipFile";

		// 添加".zip"后缀
		if (!zipFileName.endsWith(".zip"))
			zipFileName += ".zip";

		ZipOutputStream zipOut = null;

		try {
			zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(zipFileName)));
			// 加入一个目录
			basePath = basePath == null ? "" : basePath + "/";
			zipOut.putNextEntry(new ZipEntry(basePath + "/"));

			if (fileInfos != null && !fileInfos.isEmpty()) {
				Set<String> fileNames = fileInfos.keySet();
				for (String fileName : fileNames) {
					zipOut.putNextEntry(new ZipEntry(basePath + fileName));
					zipOut.write(fileInfos.get(fileName));
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				zipOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			zipOut = null;
		}
	}

	/**
	 * 压缩文件和目录。由doZip()调用
	 * 
	 * @param files
	 *            要压缩的文件
	 * @param zipOut
	 *            zip输出流
	 * @param isAbsolute
	 *            是否是要去除的绝对路径的根路径。因为compressFiles()
	 *            会递归地被调用，所以只用deleteAbsoluteParent不行。必须用isAbsolute来指明
	 *            compressFiles()是第一次调用，而不是后续的递归调用。即如果要压缩的路径是
	 *            E:\temp，那么第一次调用时，isAbsolute=true，则deleteAbsoluteParent会记录
	 *            要删除的路径就是E:\ ，当压缩子目录E:\temp\folder时，isAbsolute=false，
	 *            再递归调用compressFiles()时，deleteAbsoluteParent仍然是E:\ 。从而保证了
	 *            将E:\temp及其子目录均正确地转化为相对目录。这样压缩才不会出错。不然绝对 路径E:\也会被写入到压缩文件中去。
	 */
	private void compressFiles(File[] files, ZipOutputStream zipOut,
			boolean isAbsolute) throws IOException {

		for (File file : files) {
			if (file == null)
				continue; // 空的文件对象

			// 删除绝对父路径
			if (file.isAbsolute()) {
				if (isAbsolute) {
					deleteAbsoluteParent = file.getParentFile()
							.getAbsolutePath();
					deleteAbsoluteParent = appendSeparator(deleteAbsoluteParent);
				}
			} else
				deleteAbsoluteParent = "";

			if (file.isDirectory()) {// 是目录
				compressFolder(file, zipOut);
			} else {// 是文件
				compressFile(file, zipOut);
			}
		}
	}

	/**
	 * 压缩文件或空目录。由compressFiles()调用。
	 * 
	 * @param file
	 *            需要压缩的文件
	 * @param zipOut
	 *            zip输出流
	 */
	public void compressFile(File file, ZipOutputStream zipOut)
			throws IOException {

		String fileName = file.toString();

		/* 去除绝对父路径。 */
		if (file.isAbsolute())
			fileName = fileName.substring(deleteAbsoluteParent.length());
		if (fileName == null || fileName == "")
			return;

		/*
		 * 因为是空目录，所以要在结尾加一个"/"。 不然就会被当作是空文件。 ZipEntry的isDirectory()方法中,目录以"/"结尾.
		 * org.apache.tools.zip.ZipEntry : public boolean isDirectory() { return
		 * getName().endsWith("/"); }
		 */
		if (file.isDirectory())
			fileName = fileName + "/";// 此处不能用"\\"

		zipOut.putNextEntry(new ZipEntry(fileName));

		// 如果是文件则需读;如果是空目录则无需读，直接转到zipOut.closeEntry()。
		if (file.isFile()) {
			FileInputStream fileIn = new FileInputStream(file);
			int readedBytes = 0;
			while ((readedBytes = fileIn.read(this.buf)) > 0) {
				zipOut.write(this.buf, 0, readedBytes);
			}
			fileIn.close();
		}

		zipOut.closeEntry();
	}

	/**
	 * 递归完成目录文件读取。由compressFiles()调用。
	 * 
	 * @param dir
	 *            需要处理的文件对象
	 * @param zipOut
	 *            zip输出流
	 */
	private void compressFolder(File dir, ZipOutputStream zipOut)
			throws IOException {

		File[] files = dir.listFiles();

		if (files.length == 0)// 如果目录为空，则单独压缩空目录。
			compressFile(dir, zipOut);
		else
			// 如果目录不为空,则分别处理目录和文件.
			compressFiles(files, zipOut, false);
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFileName
	 *            需要解压的zip文件名
	 */
	public void unZip(String unZipFileName) throws Exception {
		unZip(new File(unZipFileName));
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFile
	 *            需要解压的zip文件对象
	 */
	public void unZip(File unZipFile) throws Exception {
		unZip(unZipFile, null);
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFileName
	 *            需要解压的zip文件名
	 */
	public void unZip(String unZipFileName, String tarPath) throws Exception {
		unZip(new File(unZipFileName), tarPath);
	}

	/**
	 * 解压指定zip文件。
	 * 
	 * @param unZipFileName
	 *            需要解压的zip文件名
	 */
	public void unZip(File file, String tarPath) throws Exception {
		if (file == null || !file.exists() || file.isDirectory())
			throw new Exception("文件不存在或不是文件类型");

		ZipFile zipFile = null;

		try {
			// 取得文件绝对路径
			String unZipFileName = file.getAbsolutePath();

			// 取得最后一个路径
			if (tarPath == null || "".equals(tarPath.trim())) {
				tarPath = unZipFileName.substring(0,
						unZipFileName.lastIndexOf(File.separator));
			}

			zipFile = new ZipFile(unZipFileName);

			for (Enumeration<?> entries = zipFile.entries(); entries
					.hasMoreElements();) {
				java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry) entries
						.nextElement();
				file = new File(tarPath + File.separator + entry.getName());

				if (entry.isDirectory()) {// 是目录，则创建之
					file.mkdirs();
				} else {// 是文件
					// 如果指定文件的父目录不存在,则创建之.
					File parent = file.getParentFile();
					if (parent != null && !parent.exists()) {
						parent.mkdirs();
					}

					FileHelper.convertToFile(zipFile.getInputStream(entry), file);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			try {
				zipFile.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			zipFile = null;
		}
	}

	/**
	 * 给文件路径或目录结尾添加File.separator
	 * 
	 * @param fileName
	 *            需要添加路径分割符的路径
	 * @return 如果路径已经有分割符，则原样返回，否则添加分割符后返回。
	 */
	private String appendSeparator(String path) {
		if (!path.endsWith(File.separator))
			path += File.separator;
		return path;
	}

	public static void main(String[] args) throws Exception {
		// ZipHelper zip = new ZipHelper();
		// File file = new File("./src/");
		// zip.doZip(new File[] { file }, "./src.zip");
		// Thread.sleep(10000);
		// zip.unZip("C:/Users/liude/Desktop/src.zip");
	}
}