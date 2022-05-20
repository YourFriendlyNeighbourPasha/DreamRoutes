package com.redscarf.dreamroutes.mappers.interfaces;

public interface GenericMapper<T, TDto, TCreateDto> {

    TDto fromEntityToDto(T entity);

    T fromDtoToEntity(TDto dto);

    T fromCreateDtoToEntity(TCreateDto createDto);

}
