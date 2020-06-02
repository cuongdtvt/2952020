package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Import;
@Repository
public class ImportImp implements IImportRepo{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from import", Integer.class);
	}

	@Override
	public int save(Import imports) {
		return jdbcTemplate.update(
				"DECLARE @idImport bigint insert into import (product_id, qty, description, create_date) values(?,?,?,getdate()) SELECT @idImport = SCOPE_IDENTITY() UPDATE [dbo].[product] SET [qty] = (SELECT (SELECT qty FROM product WHERE id = ?) + (SELECT qty FROM import WHERE id = @idImport)) WHERE id = ?",
				
                imports.getProductID(), imports.getQty(), imports.getDescription(),imports.getProductID(),imports.getProductID() );
				
	}

	@Override
	public int update(Import imports) {
		return jdbcTemplate.update(
                "update import set product_id =?, qty =?, description=? where id =?",
                imports.getProductID(), imports.getQty(), imports.getDescription(), imports.getId());

	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "delete import where id = ?",
                id);

	}

	@Override
	public List<Import> findAll() {
		 return jdbcTemplate.query(
	                "select * from import",
	                (rs, rowNum) ->
							new Import(
	                                rs.getLong("id"),
	                                rs.getLong("product_id"),
	                                rs.getLong("qty"),
	                                rs.getString("description"),
	                                rs.getDate("create_date")
	                        )
	        );
	}

	@Override
	public Optional<Import> findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from import where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Import(
                                rs.getLong("id"),
                                rs.getLong("product_id"),
                                rs.getLong("qty"),
                                rs.getString("description"),
                                rs.getDate("create_date")
                        )
        ));
	}

	@Override
	public List<Import> findByName(String name) {
		return jdbcTemplate.query(
                "select * from import where name like ?",
                new Object[]{"%" + name + "%",},
                (rs, rowNum) ->
                new Import(
                        rs.getLong("id"),
                        rs.getLong("product_id"),
                        rs.getLong("qty"),
                        rs.getString("description"),
                        rs.getDate("create_date")
        )
                );
}
	

}
