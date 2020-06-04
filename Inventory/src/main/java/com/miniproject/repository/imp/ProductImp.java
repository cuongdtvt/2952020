package com.miniproject.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Product;
import com.miniproject.repository.IProductRepo;

@Repository
public class ProductImp implements IProductRepo{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from product", Integer.class);
	}

	@Override
	public int save(Product product) {
		return jdbcTemplate.update(
                "insert into product (cate_id,name,description,qty, imageUrl) values(?,?,?,?,?)",
                product.getCateID(),product.getName(), product.getDescription(), product.getQty(), product.getImageUrl());
}
	
//	@Override
//	public int save(Category categoryEntity) {
//		 return jdbcTemplate.update(
//	                "insert into category (name, description) values(?,?)",
//	                categoryEntity.getName(), categoryEntity.getDescription());
//	}

	@Override
	public int update(Product product) {
		return jdbcTemplate.update("update product set cate_id = ?,name = ?,description = ?,qty = ?,imageUrl = ? where id = ? ",
				product.getCateID(),product.getName(), product.getDescription(), product.getQty(),product.getImageUrl(), product.getId());
}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "delete product where id = ?",
                id);
	}

////	@Override
////	public List<Product> afindAll(){
////		return jdbcTemplate.query(
////				"SELECT PRODUCT.NAME, category.NAME, PRODUCT.description, product.qty, product.img_url\r\n" + 
////				"FROM PRODUCT INNER JOIN category\r\n" + 
////				"ON product.cate_id = category.id",
////				(rs, rowNum) ->
////							new Product(
////									rs.getString("name"),
////									rs.getString("name"),
////									rs.getString("description"),
////									rs.getLong("qty"),
////	                                rs.getString("img_url")
////									)
////							);
//				
//	}
	@Override
	public List<Product> findAll() {
		 return jdbcTemplate.query(
	                "select p.id,p.cate_id,p.name,c.name as cateName,  p.description, p.qty, p.imageUrl from  product p join category c on c.id = p.cate_id ",
	                (rs, rowNum) ->
							new Product(
	                                rs.getLong("id"),
	                                rs.getLong("cate_id"),
	                                rs.getString("name"),
	                                rs.getString("cateName"),	                                                  
	                                rs.getString("description"),
	                                rs.getLong("qty"),
	                                rs.getString("imageUrl")
	                        )
	        );}
	
	

	@Override
	public Optional<Product> findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select p.id,p.cate_id,p.name,c.name as cateName,  p.description, p.qty, p.imageUrl from  product p join category c on c.id = p.cate_id where p.id =?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Product(
                        		   	rs.getLong("id"),
	                                rs.getLong("cate_id"),
	                                rs.getString("name"),
	                                rs.getString("cateName"),	                                                  
	                                rs.getString("description"),
	                                rs.getLong("qty"),
	                                rs.getString("imageUrl")
                        )
        ));
	}

	@Override
	public List<Product> findByName(String name) {
		 return jdbcTemplate.query(
	                "select * from product where name like ? ",
	                new Object[]{"%" + name + "%",},
	                (rs, rowNum) ->
	                new Product(
                            rs.getLong("id"),
                            rs.getLong("cate_id"),	                     
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getLong("qty"),
                            rs.getString("imageUrl")
	                        )
	        );
	}

}
