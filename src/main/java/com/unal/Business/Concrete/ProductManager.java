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
                (productDal.findAll(),"tüm data listelendi");
    }

    @Override
    public Result add(Product product) {
        productDal.save(product);
        return new SuccessResult("Ürün başarıyla eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (productDal.getByProductName(productName),"Data getirildi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (productDal.getByProductNameAndCategory(productName,categoryId)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameOrCategory(productName,categoryId)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByCategoryIn(categories)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameContains(productName)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameStartsWith(productName)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByNameAndCategory(productName,categoryId)
                        ,"Data getirildi");
    }
}
