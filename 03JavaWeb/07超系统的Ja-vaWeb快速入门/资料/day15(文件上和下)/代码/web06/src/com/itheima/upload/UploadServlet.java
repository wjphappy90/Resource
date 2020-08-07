package com.itheima.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.utils.UploadUtils;

/**
 * 文件上传的Servlet
 */
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// 判断表单的enctype属性：
			boolean flag = ServletFileUpload.isMultipartContent(request);
			if(!flag){
				// enctype属性不是multipart/form-data
				request.setAttribute("msg", "表单的格式不正确！");
				request.getRequestDispatcher("/jsp/upload.jsp").forward(request, response);
				return;
			}
			// 1.创建磁盘文件项工厂
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 1.1设置缓冲区的大小：
			diskFileItemFactory.setSizeThreshold(3 * 1024 * 1024);// 设置缓冲区的大小为3M
			// 1.2设置临时文件存放的路径:
			// 获得临时文件存放的路径：
			String tempPath = getServletContext().getRealPath("/temp");
			diskFileItemFactory.setRepository(new File(tempPath));
			// 2.创建一个核心的解析类
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			// 设置文件上传的文件的大小：
//			fileUpload.setSizeMax(5*1024*1024);
			// 3.利用核心类解析Request，解析后会得到多个部分。返回一个List集合。List集合装的是每个部分的内容（FileItem文件项）。
			List<FileItem> list = fileUpload.parseRequest(request);
			// 4.遍历List集合，会得到代表每个部分的文件项的对象。根据文件项判断是否是文件上传项。
			for (FileItem fileItem : list) {
				// 判断这个文件项是否是普通项还是文件上传项。
				if(fileItem.isFormField()){
					// 普通项:
					// 接收普通项的值:(接收值不能再使用request.getParameter())
					String name = fileItem.getFieldName();// 获得普通项的名称
					// 获得普通项的值
					String value = fileItem.getString("UTF-8");
					System.out.println(name+"    "+value);
				}else{
					// 文件上传项:
					// 获得文件上传项的文件的名称:
					String filename = fileItem.getName();
					// System.out.println("文件名:"+filename);
					int idx = filename.lastIndexOf("\\");
					if(idx != -1){
						// 使用老版本浏览器：
						filename = filename.substring(idx+1);
					}
					// 得到唯一文件名:
					String uuidFilename = UploadUtils.getUuidFilename(filename);
					// 获得文件上传的文件的数据:
					InputStream is = fileItem.getInputStream();
					// 获得文件上传的路径：磁盘绝对路径。
					String realPath = getServletContext().getRealPath("/upload");
					// 进行目录分离:
					String path = UploadUtils.getRealPath(uuidFilename);
					String newPath = realPath + path;
					File file = new File(newPath);
					if(!file.exists()){
						file.mkdirs();
					}
					// 创建一个输出流，写入到设置的路径中。
					OutputStream os = new FileOutputStream(newPath+"/"+uuidFilename);
					// 两个流对接:
					int len = 0;
					byte[] b = new byte[1024];
					while((len = is.read(b)) != -1){
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
				// 删除临时文件
				fileItem.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
