package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTree {

	// 获取根节点
	public List<String> FileList() {
		List<String> list = new ArrayList<String>();
		File[] root = File.listRoots(); // 获取磁盘分区列表
		for (File file : root) {
			String path = file.getAbsolutePath();
			list.add(path);
		}
		return list;
	}
	
	// 获取子节点
	public List<String> FileList(String path){
		List<String> list = new ArrayList<String>();
		File f = new File(path);
		if(f != null){
			File[] fs = f.listFiles();
			for (File fil : fs) {
//				System.out.println(fil.getAbsolutePath());
				list.add(fil.getAbsolutePath());
			}
		}
		return list;
	}
}
