package com.unal.DataAccess.Abstract;

import com.unal.Entities.Concrete.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDal extends JpaRepository<Product,Integer> {
}
