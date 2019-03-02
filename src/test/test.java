package test;

import java.io.File;

public class test {
	
	public static void main(String[] args){
		File[] root = File.listRoots(); //获取磁盘分区列表
		for(File file : root)
		{
		   System.out.println(file.getAbsolutePath());
		  
		}
		
		// 显示指定目标下的文件
		String path = "D:/"; 
		File f = new File(path);
		//getFiles(f);
		getFile(f);
	}
	
	//返回path路径对应于网络硬盘根目录的本地路径  userRoot + 
	public static String getAbsolutePath(String path) {
		String absolutePath = (File.separator.equals("\\") ? path.replaceAll("/", "\\\\") : path);
		return absolutePath;
	}

	// 获取目录下的所有文件 包括下属所有文件
	public static void getFiles(File file){
		if(file != null){
			File[] f = file.listFiles();
			if(f != null){
				for(int i=0;i<f.length;i++){
					getFile(f[i]);
				}
			}else{
				System.out.println(file);
			}
		}
	}

	//只显示二级目录文件
	public static void getFile(File file){
		if(file != null){
			File[] f = file.listFiles();
			for (File fil : f) {
				System.out.println(fil);
			}
		}
	}
}
