package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    //Se crea un objeto tipo Autowired que se crearà automàticamente y solo una vez
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
        var lista = productoDao.findAll();
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
     @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    //lista los produtos que estan en un rango de precios y los ordena por descripcion
    @Override
    @Transactional(readOnly = true)//esuna transaccion de solo lectura, esto para que la consulta sea mas rapida
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup){
        return  productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    //lista los produtos que estan en un rango de precios y los ordena por descripcion
    @Override
    @Transactional(readOnly = true)//esuna transaccion de solo lectura, esto para que la consulta sea mas rapida
    public List<Producto> metodoJPQL(double precioInf, double precioSup){
        return  productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    //lista los produtos que estan en un rango de precios y los ordena por descripcion
    @Override
    @Transactional(readOnly = true)//esuna transaccion de solo lectura, esto para que la consulta sea mas rapida
    public List<Producto> metodoNativo(double precioInf, double precioSup){
        return  productoDao.metodoNativo(precioInf, precioSup);
    }
    
}
