package com.mogou.repository;

import com.mogou.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Trouve tous les produits dont la quantité en stock est inférieure à une valeur spécifiée.
     * Le nom de la méthode est interprété par Spring Data JPA pour générer la requête SQL correspondante.
     *
     * @param quantity La quantité maximale (exclusive) pour les produits recherchés.
     * @return Une liste de produits avec un stock bas.
     */
    List<Product> findByQuantityLessThan(Integer quantity);
}