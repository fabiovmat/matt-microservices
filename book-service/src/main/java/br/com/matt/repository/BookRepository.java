package br.com.matt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matt.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
