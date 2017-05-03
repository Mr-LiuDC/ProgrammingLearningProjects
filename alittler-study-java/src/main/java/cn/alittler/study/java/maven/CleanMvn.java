package cn.alittler.study.java.maven;

import java.io.File;

import org.junit.Test;

public class CleanMvn {
	@Test
	public void test() {
		findAndDelete(new File("G:\\.m2\\repository"));
	}

	@Test
	public void test2() {
		findAndDelete(new File("C:\\Users\\liude\\.m2\\repository"));
	}

	public static boolean findAndDelete(File file) {
		if (!file.exists()) {
		} else if (file.isFile()) {
			if (file.getName().endsWith("lastUpdated")) {
				deleteFile(file.getParentFile());
				return true;
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (findAndDelete(f)) {
					break;
				}
			}
		}
		return false;
	}

	public static void deleteFile(File file) {
		if (!file.exists()) {
		} else if (file.isFile()) {
			print("删除文件:" + file.getAbsolutePath());
			file.delete();
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				deleteFile(f);
				// f.delete();
			}
			print("删除文件夹:" + file.getAbsolutePath());
			print("====================================");
			file.delete();
		}
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
