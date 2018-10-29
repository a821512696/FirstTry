package sch.hunnu.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadFileUtils {
	
	// 上传文件存储目录
    //private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir")+"\\uploadFiles";
 
    // 上传配置
	 //设置缓冲区大小3MB
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    //设置一个完整请求的最大允许大小
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 20; // 40MB
    //一次请求最大的总文件大小 (包含文件和表单数据)
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
	public static String uploadFiles(HttpServletRequest request) throws IOException{
		
		if(!ServletFileUpload.isMultipartContent(request)){
			return "Error: 表单必须包含 enctype=multipart/form-data";
		}
		//设置文件的保存路径
		String projectPath = System.getProperty("user.dir");	//获取当前项目的完全路径
				
		//获取磁盘工厂 并配置
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		//设置临时存储文件的目录
		File temporary = new File(projectPath+File.separator+"temporarySave");
		if( !temporary.exists()){
			temporary.mkdirs();											//如果不存在则创建临时存储目录
		}
		factory.setRepository(temporary);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);
		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);
		//中文处理
		upload.setHeaderEncoding("UTF-8");
		
		//设置存储目录  可动态指定 拼接字符串即可
		File save = new File(projectPath+ File.separator+"uploadFiles");
		if(!save.exists()){
			save.mkdirs();	//如果不存在则创建目录
		}
		String savePath = save.getCanonicalPath();
		//System.out.println(savePath);
		
		//System.out.println(request.getRequestURI());
		try{
			List<FileItem> formFiles = upload.parseRequest(request);	//从HttpServletRequest中解析文件的请求
			
			if(formFiles!=null && formFiles.size()>0){
				for(FileItem item :formFiles){		//对于文件数据 进行本地保存
					if(!item.isFormField()){	
						String filename = new File(item.getName()).getName();
						String fileSavePath = savePath+File.separator+filename;		//构建文件的存储路径
						File saveFile = new File(fileSavePath);
						
						//String filename2 = file.getName();
						//System.out.println("vertify !:1:"+filename+"   2:"+filename2);
						//System.out.println("realpath :"+fileSavePath);
						
						item.write(saveFile);										//写入本地
					}else{
						System.out.println(item.getFieldName());
						System.out.println(item.getString("UTF-8"));
					}
				}
			}else{
				System.out.println("file items is null!");
			}
			
			
			return "上传文件完成";
		}catch(Exception ex){
			ex.printStackTrace();
			return "上传文件失败";
		}
		
	}
	public static void main(String[] args) throws IOException {
		 System.out.println( File.separator);
	}
	
}
