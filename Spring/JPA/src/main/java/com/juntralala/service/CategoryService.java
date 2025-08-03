package com.juntralala.service;

import com.juntralala.entity.Category;
import com.juntralala.repositoy.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void create() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName("Category-" + i);
            categoryRepository.save(category);
        }
        throw new RuntimeException("Ups, please rollback transaction");
    }

    public void test() {
        this.create();
    }

}
