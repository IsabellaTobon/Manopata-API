package com.manopata.api.posts.interfaces.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor

public enum AnimalType
{
    CAT, DOG, BIRD, RABBIT, HORSE, RODENT, TURTLE, REPTIL, AMPHIBIAN, INSECT, EXOTIC, FARM, OTHER
}
