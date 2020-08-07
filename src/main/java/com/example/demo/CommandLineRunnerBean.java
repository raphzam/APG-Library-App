package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;


    public void run(String...strings){

        //USER ROLE
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setEnabled(true);

        Role userRole = new Role("user", "ROLE_USER");

        userRepository.save(user);
        roleRepository.save(userRole);

        //ADMIN ROLE
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEnabled(true);

        Role adminRole1 = new Role("admin", "ROLE_USER");
        Role adminRole2 = new Role("admin", "ROLE_ADMIN");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

//        PRELOADING DATA

        Category fiction = new Category("Fiction");
        categoryRepository.save(fiction);

        Category nonFiction = new Category("Non-fiction");
        categoryRepository.save(nonFiction);

        Category bio = new Category("Biography");
        categoryRepository.save(bio);

        Category novel = new Category("Novel");
        categoryRepository.save(novel);

        Category youngAdult = new Category("Young Adult");
        categoryRepository.save(youngAdult);

        Book book = new Book();
        book.setTitle("Clifford the dog");
        book.setCategory(fiction);
        bookRepository.save(book);

        Book book2 = new Book();
        book2.setTitle("Arthur goes to school");
        book2.setCategory(fiction);
        bookRepository.save(book2);

//        Book book3 = new Book();
//        book.setCategory();
//        book.setTitle();
//        book.setCoverArt();
//        book.setAuthor();
//        book.setInStock();
//        book.setISBN();
//        book.setQuantity();
//        book.setYear();
//        bookRepository.save();


    }
}
