package ua.lviv.lgs.service;

import java.util.Map;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.AbstractCrud;

public interface ProductService extends AbstractCrud<Product> {
	public Map<Integer, Product> readAllMap();

}
