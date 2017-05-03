package cn.alittler.study.java.maven;

import java.io.File;

import org.junit.Test;

public class MvnClean {

	@Test
	public void test() {
		findAndDelete(new File("G:\\.m2\\repository"));
	}

	@Test
	public void test2() {
		findAndDelete(new File("C:\\Users\\liude\\.m2\\repository"));
	}

	public boolean findAndDelete(File file) {
		deleteEmptyDir(file);
		if (!file.exists()) {
			System.out.println("文件或目录：[" + file + "]不存在");
		} else if (file.isFile()) {
			if (file.getName().endsWith("lastUpdated")) {
				deleteFile(file.getParentFile());
				return true;
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files.length < 1) {
				file.delete(); // 删除空目录
			}
			for (File f : files) {
				if (findAndDelete(f)) {
					break;
				}
			}
		}
		return false;
	}

	public void deleteFile(File file) {
		deleteEmptyDir(file);
		if (!file.exists()) {
			System.out.println("文件或目录：[" + file + "]不存在");
		} else if (file.isFile()) {
			System.out.println("删除文件:" + file.getAbsolutePath());
			file.delete();
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files.length < 1) {
				file.delete(); // 删除空目录
			}
			for (File f : files) {
				deleteFile(f); // 递归删除
			}
			System.out.println("删除文件夹: " + file.getAbsolutePath());
			file.delete();
			System.out.println("==================================");
		}
	}

	public void deleteEmptyDir(File dir) {
		if (dir.isDirectory()) {
			File[] fs = dir.listFiles();
			if (fs != null && fs.length > 0) {
				for (int i = 0; i < fs.length; i++) {
					File tmpFile = fs[i];
					if (tmpFile.isDirectory()) {
						deleteEmptyDir(tmpFile);
					}
					if (tmpFile.isDirectory()
							&& tmpFile.listFiles().length <= 0) {
						tmpFile.delete();
					}
				}
			}
			if (dir.isDirectory() && dir.listFiles().length == 0) {
				dir.delete();
			}
		}
	}

}
