package com.unal.Business.Concrete;

import com.unal.Business.Abstract.ProductService;
import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Core.Utilities.Results.SuccessDataResult;
import com.unal.Core.Utilities.Results.SuccessResult;
import com.unal.DataAccess.Abstract.ProductDal;
import com.unal.Entities.Concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDal productDal;

    @Autowired
    public ProductManager(ProductDal productDal) {
        this.productDal = productDal;
    }

    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccessDataResult<List<Product>>
                (productDal.findAll(),"Data listelendi");
    }

    @Override
    public Result add(Product product) {
        productDal.save(product);
        return new SuccessResult("Ürün başarıyla eklendi");
    }
}
