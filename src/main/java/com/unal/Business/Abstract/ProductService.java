package com.unal.Business.Abstract;

import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Entities.Concrete.Product;

import java.util.List;

public interface ProductService {

    //List<Product> getAll(); data resulta T olarak list<Product verdik>
    public DataResult< List<Product>> getAll();
    public Result add(Product product);

}
