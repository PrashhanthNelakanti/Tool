package com.prashhanthN.ticketTool.common.repo;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import com.prashhanthN.ticketTool.common.modal.Products;

public interface ProductsRepo extends JpaAttributeConverter<Products, Integer> {

}
