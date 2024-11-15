# Recipe Management System - Data Model

## Overview
This document outlines the main entities and their relationships for the Recipe Management System.

## Entities and Relationships
### Recipe
- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the recipe.
  - `description`: A short description of the recipe.
  - `difficulty`: Difficulty level (e.g., Easy, Medium, Hard).
  - `preparation_time`: Time needed to prepare the recipe.
- **Relationships**:
  - One-to-Many with `Step`: A recipe has multiple steps.
  - Many-to-Many with `Ingredient`: A recipe can include multiple ingredients.
  - Many-to-One with `Category`: A recipe belongs to one category.

### Ingredient
- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the ingredient.
- **Relationships**:
  - Many-to-Many with `Recipe`: An ingredient can be part of multiple recipes.

### Category
- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the category (e.g., Dessert, Main Course).
- **Relationships**:
  - One-to-Many with `Recipe`: A category contains multiple recipes.

### Step
- **Attributes**:
  - `id`: Unique identifier.
  - `description`: Instructions for the step.
  - `step_number`: Order of the step in the recipe.
- **Relationships**:
  - Many-to-One with `Recipe`: A step belongs to a single recipe.
