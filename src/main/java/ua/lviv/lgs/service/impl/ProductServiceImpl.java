package ua.lviv.lgs.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	private static ProductService productServiceImpl;
	private ProductDao productDao;

	private ProductServiceImpl()
			throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static ProductService getProductService()
			throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}

		return productServiceImpl;
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);

	}

	@Override
	public Map<Integer, Product> readAllMap() {
		return readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}
}
