package com.miniproject.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Export;
import com.miniproject.repository.IExportRepo;
@Repository
public class ExportImp implements IExportRepo{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from export", Integer.class);
	}

	@Override
	public int save(Export export) {
		return jdbcTemplate.update(
				"DECLARE @idExport bigint insert into export (product_id, qty, description, create_date) values(?,?,?,getdate()) SELECT @idExport = SCOPE_IDENTITY() UPDATE [dbo].[product] SET [qty] = (SELECT (SELECT qty FROM product WHERE id = ?) - (SELECT qty FROM export WHERE id = @idExport)) WHERE id = ?",
				
                export.getProductID(), export.getQty(), export.getDescription(),export.getProductID(),export.getProductID() );
	}

	@Override
	public int update(Export export) {
		return jdbcTemplate.update(
                "update export set product_id =?, qty =?, description=? where id =?",
                export.getProductID(), export.getQty(), export.getDescription(), export.getId());

	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "delete export where id = ?",
                id);
	}

	@Override
	public List<Export> findAll() {
		 return jdbcTemplate.query(
				   "select e.id, e.product_id, p.name as productName,e.qty, e.description, e.create_date from product p join export e on e.product_id = p.id",
	                (rs, rowNum) ->
							new Export(
	                                rs.getLong("id"),
	                                rs.getLong("product_id"),
	                                rs.getString("productName"),
	                                rs.getLong("qty"),
	                                rs.getString("description"),
	                                rs.getDate("create_date")
	                        )
	        );
	}
	
	
	@Override
	public Optional<Export> findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from export where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Export(
                                rs.getLong("id"),
                                rs.getLong("product_id"),
                                rs.getLong("qty"),
                                rs.getString("description"),
                                rs.getDate("create_date")
                        )
        ));
	}

	@Override
	public List<Export> findByName(String name) {
		return jdbcTemplate.query(
                "select * from export where name like ?",
                new Object[]{"%" + name + "%",},
                (rs, rowNum) ->
                new Export(
                        rs.getLong("id"),
                        rs.getLong("product_id"),
                        rs.getLong("qty"),
                        rs.getString("description"),
                        rs.getDate("create_date")
        )
                );
}

}
