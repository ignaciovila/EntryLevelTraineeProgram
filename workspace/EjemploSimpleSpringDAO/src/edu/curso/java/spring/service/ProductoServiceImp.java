package edu.curso.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.*;

@Service
@Transactional
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoDAO productoDAO;

	@Override
	public Long crearNuevoProductoSimple(Producto producto) throws Exception {
		if (producto.getPrecio() <= 0)
			throw new Exception("El producto tiene mal el precio");
		productoDAO.guardarProducto(producto);
		return producto.getId();
	}
}
