package bibliophiles.bookstore.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.impl.CategoryServiceImpl;

public class CategoryServiceImplTest {

	@Test
	public void CategoryServiceImplAllTest(){
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		List<Category> categories = new ArrayList<Category>();
		categories = categoryServiceImpl.all();
		for(Category category : categories){
			System.out.println(category);
		}
	}
	
	@Test
	public void CategoryServiceImplFindByIdTest(){
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		Category category = new Category();
		category = categoryServiceImpl.findByCategoryID("c1");
			System.out.println(category);
	}
}
