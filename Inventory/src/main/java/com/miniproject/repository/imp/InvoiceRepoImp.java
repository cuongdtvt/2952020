package com.miniproject.repository.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.miniproject.model.Invoice;
import com.miniproject.repository.IInvoiceRepo;
@Repository
public class InvoiceRepoImp implements IInvoiceRepo{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from invoice", Integer.class);
	}

	@Override
	public int save(Invoice invoiceEntity) {
		 return jdbcTemplate.update(
	                "insert into invoice (product_id, type, qty) values(?,?,?)",
	                invoiceEntity.getProductID(), invoiceEntity.isType(), invoiceEntity.getQty());
	}

	@Override
	public int update(Invoice invoiceEntity) {
		 return jdbcTemplate.update(
	                "update invoice set product_id =?, type =?, qty=? where id =?",
	                invoiceEntity.getProductID(), invoiceEntity.isType(), invoiceEntity.getQty(), invoiceEntity.getId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "delete invoice where id = ?",
                id);
	}

	@Override
	public List<Invoice> findAll() {
		 return jdbcTemplate.query(
	                "select * from invoice",
	                (rs, rowNum) ->
							new Invoice(
	                                rs.getLong("id"),
	                                rs.getLong("product_id"),
	                                rs.getBoolean("type"),
	                                rs.getLong("qty")
	                        )
	        );
	}

	@Override
	public Optional<Invoice> findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from invoice where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Invoice(
                                rs.getLong("id"),
                                rs.getLong("product_id"),
                                rs.getBoolean("type"),
                                rs.getLong("qty")
                        )
        ));
	}

	@Override
	public List<Invoice> findByName(String name) {
		 return jdbcTemplate.query(
	                "select * from invoice where name like ?",
	                new Object[]{"%" + name + "%",},
	                (rs, rowNum) ->
	                new Invoice(
                            rs.getLong("id"),
                            rs.getLong("product_id"),
                            rs.getBoolean("type"),
                            rs.getLong("qty")
	                        )
	        );
	}

}
