package cn.alittler.study.java.maven;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FuckLastUpdated {
	
	public static Map<Object, Object> findLastUpdated(String repositoryPath) {
		Map<Object, Object> lastUpdatedPaths = new HashMap<>();
		File file = new File(repositoryPath);
		if (!file.exists()) {
			System.out.println("路径 【"+ repositoryPath +"】 不存在");
		}else if (file.isFile()) {
			if (file.getName().endsWith("lastUpdated")) {
				lastUpdatedPaths.put(file.getName(), file.getParentFile().toPath());
			}
		}else if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (File f : subFiles) {
				if (f != null) {
					findLastUpdated(f.toString());
				}
			}
		}
		return lastUpdatedPaths;
	}

}
