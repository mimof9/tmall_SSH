package action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import bean.Category;
import util.ImageUtil;
import util.Page;

public class CategoryAction extends Action4Result{
	
	@Action("admin_category_list")
	public String list(){
		if(null == page)
			page = new Page(0,5);	//struts���� set get������ һ��Ҫ���޲ι��캯�� �������Զ�����
		int total = categoryService.total();
		page.setTotal(total);
		thecs = categoryService.listByPage(page);	//����Ҫע�� List<Object>����ֱ��ת����List<Category> ��Ҫ�ȱ���޷��͵�List
		return "listCategory";
	}
	
	@Action("admin_category_add")
	public String add(){
		categoryService.save(category);
		
		File imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,category.getId()+".jpg");
        try {
            FileUtils.copyFile(img, file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);           
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return "listCategoryPage";
	}
	
	@Action("admin_category_delete")
	public String delete(){
		categoryService.delete(category);

		File imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder,category.getId()+".jpg");
		file.delete();
		
		return "listCategoryPage";
	}

	@Action("admin_category_edit")
	public String edit(){
//		int id = category.getId();
//        category = categoryService.get(Category.class,id);
//        category = (Category) categoryService.get(Category.class,id);
		t2p(category);
        return "editCategory";
	}
	
	@Action("admin_category_update")
	public String update(){
		categoryService.update(category);
		
		if(null != img){
			File imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
	        File file = new File(imageFolder,category.getId()+".jpg");
	        try {
	            FileUtils.copyFile(img, file);
	            BufferedImage img = ImageUtil.change2jpg(file);
	            ImageIO.write(img, "jpg", file);           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
        return "listCategoryPage";
	}
	
}
