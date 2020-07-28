package com.example.app.mapper;

import com.example.app.dto.CategoryDto;
import com.example.app.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    @InheritInverseConfiguration
    Category toEntity(CategoryDto category);

    List<CategoryDto> toDtoList(List<Category> list);

    @InheritInverseConfiguration
    List<Category> toEntityList(List<CategoryDto> list);
}
