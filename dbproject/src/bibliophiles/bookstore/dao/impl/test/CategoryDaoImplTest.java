package bibliophiles.bookstore.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bibliophiles.bookstore.dao.impl.CategoryDaoImpl;
import bibliophiles.bookstore.domain.Category;

public class CategoryDaoImplTest {

	@Test
	public void CategoryDaoImplTest1(){
		CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
		List<Category> categories = new ArrayList<Category>();
		categories = categoryDaoImpl.all();
		for(Category category : categories){
			System.out.println(category);
		}
	}
	
	@Test
	public void CategoryDaoImplTest2(){
		CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
		Category category = new Category();
		category = categoryDaoImpl.findByCategoryID("c1");
		System.out.println(category);
		
	}
}
