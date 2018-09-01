package action;

public class Action4Parameter extends Action4Service{
	//错误消息
    protected String msg;
    //分类排序方式
    protected String sort;
    //搜索关键字
    protected String keyword;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
