package action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	@Result(name="listCategory",location="/admin/listCategory.jsp"),
	@Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
	@Result(name="editCategory", location="/admin/editCategory.jsp"),
	
	@Result(name="listProperty", location="/admin/listProperty.jsp"),
	@Result(name="listPropertyPage", type = "redirect", location="/admin_property_list?category.id=${property.category.id}"),
	@Result(name="editProperty", location="/admin/editProperty.jsp"),
	
	})
public class Action4Result extends Action4Service{
	
}
