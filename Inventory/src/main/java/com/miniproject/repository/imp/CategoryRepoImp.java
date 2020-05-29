package com.miniproject.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Category;
import com.miniproject.repository.ICategoryRepo;
@Repository
public class CategoryRepoImp implements ICategoryRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from category", Integer.class);
	}

	@Override
	public int save(Category categoryEntity) {
		 return jdbcTemplate.update(
	                "insert into category (name, description) values(?,?)",
	                categoryEntity.getName(), categoryEntity.getDescription());
	}

	@Override
	public int update(Category categoryEntity) {
		return jdbcTemplate.update(
                "update category set name =?, description = ? where id = ?",
				categoryEntity.getName(), categoryEntity.getDescription(), categoryEntity.getId());
	}
	

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "delete category where id = ?",
                id);
	}

	@Override
	public List<Category> findAll() {
		 return jdbcTemplate.query(
	                "select * from category",
	                (rs, rowNum) ->
							new Category(
	                                rs.getLong("id"),
	                                rs.getString("name"),
	                                rs.getString("description")
	                        )
	        );
	}

	@Override
	public Optional<Category> findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from category where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Category(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("description")
                        )
        ));
	}

	@Override
	public List<Category> findByName(String name) {
		 return jdbcTemplate.query(
	                "select * from category where name like ?",
	                new Object[]{"%" + name + "%",},
	                (rs, rowNum) ->
	                new Category(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("description")
	                        )
	        );
	}

}
