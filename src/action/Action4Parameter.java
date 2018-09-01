package action;

public class Action4Parameter extends Action4Service{
	//错误消息
    protected String msg;
    //分类排序方式
    protected String sort;

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
}
