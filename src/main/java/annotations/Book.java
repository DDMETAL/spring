package annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("book")
public class Book {
	@Value("��ָoffer")
	private String name;
	@Value("#{config.pageSize}")
	private String pageSize;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", pageSize=" + pageSize + "]";
	}
	
}
