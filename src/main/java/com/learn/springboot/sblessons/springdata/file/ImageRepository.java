package com.learn.springboot.sblessons.springdata.file;

import org.springframework.data.repository.CrudRepository;

public interface ImageRepository  extends CrudRepository<Image, Long> {
}
